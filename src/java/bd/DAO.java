package bd;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Control;
import modelo.Hospitalizacion;
import modelo.HospitalizacionUsuario;
import modelo.Medicamentos;
import modelo.Paciente;
import modelo.Respaldo;
import modelo.TipoTurno;
import modelo.TipoUsuario;
import modelo.Usuario;

public class DAO {
    public final Conexion C;
    private String sql;
    public List<TipoUsuario> listaTipoUsuario;
    public List<TipoTurno> listaTipoTurno;
    public List<Respaldo> respaldos;
    
    
    public DAO() throws SQLException {
        C = new Conexion(
                DatosConexion.SERVER,
                DatosConexion.BD,
                DatosConexion.USER,
                DatosConexion.PASS
        );
    }
    
    /*
     Inicio Métodos TipoUsuario
     */
    
    public TipoUsuario getTipoUsuarioPorId(int id) throws SQLException {
        TipoUsuario tipo = null;
        sql = "SELECT * FROM tipoUsuario WHERE tipoUsuario_id = '" + id + "'";
        C.resultado = C.ejecutarSelect(sql);
        if (C.resultado.next()) {
            tipo = new TipoUsuario(C.resultado.getInt(1), C.resultado.getString(2));
        }
        C.sentencia.close();
        return tipo;
    }
    
    public List<TipoUsuario> getTiposUsuario() throws SQLException {
        sql = "SELECT * FROM tipoUsuario;";
        C.resultado = C.ejecutarSelect(sql);
        TipoUsuario tipo;
        listaTipoUsuario = new ArrayList<>();
        while (C.resultado.next()) {
            tipo = new TipoUsuario();
            tipo.setId(C.resultado.getInt(1));
            tipo.setNombre(C.resultado.getString(2));
            listaTipoUsuario.add(tipo);
        }
        C.sentencia.close();
        return listaTipoUsuario;
    }
    
    /*
     Fin Métodos TipoUsuario
     */
    
    /*----------------------------------------------------------------------*/
    
    /*
     Inicio Métodos TipoTurnos
     */
    
    public TipoTurno getTipoTurnoPorId(int id) throws SQLException {
        TipoTurno tipo = null;
        sql = "SELECT * FROM tipoTurno WHERE tipoTurno_id = '" + id + "'";
        C.resultado = C.ejecutarSelect(sql);
        if (C.resultado.next()) {
            tipo = new TipoTurno(C.resultado.getInt(1), C.resultado.getString(2), C.resultado.getString(3), C.resultado.getString(4));
        }
        C.sentencia.close();
        return tipo;
    }
    
    public List<TipoTurno> getTiposTurno() throws SQLException {
        sql = "SELECT * FROM tipoTurno;";
        C.resultado = C.ejecutarSelect(sql);
        TipoTurno tipo;
        listaTipoTurno = new ArrayList<>();
        while (C.resultado.next()) {
            tipo = new TipoTurno();
            tipo.setId(C.resultado.getInt(1));
            tipo.setNombre(C.resultado.getString(2));
            tipo.setHoraEntrada(C.resultado.getString(3));
            tipo.setHoraSalida(C.resultado.getString(4));
            listaTipoTurno.add(tipo);
        }
        C.sentencia.close();
        return listaTipoTurno;
    }
    
    /*
     Fin Métodos TipoTurnos
     */
    
    /*----------------------------------------------------------------------*/
    
    /*
     Inicio Métodos Usuario
     */
    
    public void crearUsuario(Usuario u) throws SQLException {
        sql = "INSERT INTO usuario VALUES("
                + "NULL,"
                + "'" + u.getRut() + "',"
                + "'" + u.getNombre() + "',"
                + "'" + u.getApellidos()+ "',"
                + "'" + u.getFechaNacimiento()+ "',"
                + "'" + u.getEmail()+ "',"
                + "AES_ENCRYPT('" + u.getClave() + "',666),"
                + "" + u.getIdTipoUsuario() + ","
                + "" + u.getIdTipoTurno() + ""
                + ");";
        C.ejecutar(sql);
    }
    
    public Usuario getUsuarioPorId(int id) throws SQLException {
        Usuario user = null;
        sql = "SELECT * FROM usuario WHERE usuario_id = '" + id + "'";
        C.resultado = C.ejecutarSelect(sql);
        if (C.resultado.next()) {
            user = new Usuario(
                    C.resultado.getInt(1),
                    C.resultado.getString(2),
                    C.resultado.getString(3),
                    C.resultado.getString(4),
                    C.resultado.getDate(5),
                    C.resultado.getString(6),
                    C.resultado.getString(7),
                    C.resultado.getInt(8),
                    C.resultado.getInt(9)
            );
        }
        C.sentencia.close();
        return user;
    }
    
    public Usuario getUsuarioPorRut(int rut) throws SQLException {
        Usuario user = null;
        sql = "SELECT * FROM usuario WHERE usuario_rut = '" + rut + "'";
        C.resultado = C.ejecutarSelect(sql);
        if (C.resultado.next()) {
            user = new Usuario(
                    C.resultado.getInt(1),
                    C.resultado.getString(2),
                    C.resultado.getString(3),
                    C.resultado.getString(4),
                    C.resultado.getDate(5),
                    C.resultado.getString(6),
                    C.resultado.getString(7),
                    C.resultado.getInt(8),
                    C.resultado.getInt(9)
            );
        }
        C.sentencia.close();
        return user;
    }
    
    public Usuario getUsuarioRutClave(String nombre, String clave) throws SQLException {
        Usuario user = null;
        sql = "SELECT * FROM usuario WHERE usuario_rut = '" + nombre + "' AND usuario_clave = AES_ENCRYPT('" + clave + "',666)";
        C.resultado = C.ejecutarSelect(sql);
        if (C.resultado.next()) {
            user = new Usuario(
                    C.resultado.getInt(1),
                    C.resultado.getString(2),
                    C.resultado.getString(3),
                    C.resultado.getString(4),
                    C.resultado.getDate(5),
                    C.resultado.getString(6),
                    C.resultado.getString(7),
                    C.resultado.getInt(8),
                    C.resultado.getInt(9)
            );
        }
        C.sentencia.close();
        return user;
    }
    
    public List<Usuario> getUsuarioLike(String arg) throws SQLException {
        sql = "SELECT * FROM usuario WHERE "
                + "usuario_nombre like '%" + arg + "%' "
                + "OR "
                + "usuario_apellidos like '%" + arg + "%';";
        C.resultado = C.ejecutarSelect(sql);
        Usuario u;
        List<Usuario> lu = new ArrayList<>();
        while (C.resultado.next()) {
            u = new Usuario();
            u.setId(C.resultado.getInt(1));
            u.setRut(C.resultado.getString(2));
            u.setNombre(C.resultado.getString(3));
            u.setApellidos(C.resultado.getString(4));
            u.setFechaNacimiento(C.resultado.getDate(5));
            u.setEmail(C.resultado.getString(6));
            u.setClave(C.resultado.getString(7));
            u.setIdTipoUsuario(C.resultado.getInt(8));
            u.setIdTipoTurno(C.resultado.getInt(9));
            lu.add(u);
        }
        C.sentencia.close();
        return lu;
    }
    
    public void actualizarUsuario(Usuario u) throws SQLException {
        sql = "UPDATE usuario SET "
                + "usuario_nombre = '" + u.getNombre() + "', "
                + "usuario_apellidos = '" + u.getApellidos()+ "', "
                + "usuario_email = '" + u.getEmail()+ "', "
                + "usuario_idTipoUsuario = '" + u.getIdTipoUsuario()+ "', "
                + "usuario_idTipoTurno = " + u.getIdTipoTurno()+ " "
                + "WHERE "
                + "usuario_id = '" + u.getId() + "';";
        C.ejecutar(sql);
    }

    public void actualizarClaveUsuario(String clave, int id) throws SQLException {
        sql = "UPDATE usuario SET "
                + "usuario_clave = AES_ENCRYPT('" + clave + "',666) "
                + "WHERE "
                + "usuario_id = '" + id + "';";
        C.ejecutar(sql);
    }
    
    public void eliminarUsuario(int id) throws SQLException {
        sql = "DELETE FROM usuario WHERE usuario_id = '" + id + "';";
        C.ejecutar(sql);
    }

    public List<Usuario> getUsuarios() throws SQLException {
        sql = "SELECT * FROM usuario;";
        C.resultado = C.ejecutarSelect(sql);
        Usuario u;
        List<Usuario> lu = new ArrayList<>();
        while (C.resultado.next()) {
            u = new Usuario();
            u.setId(C.resultado.getInt(1));
            u.setRut(C.resultado.getString(2));
            u.setNombre(C.resultado.getString(3));
            u.setApellidos(C.resultado.getString(4));
            u.setFechaNacimiento(C.resultado.getDate(5));
            u.setEmail(C.resultado.getString(6));
            u.setClave(C.resultado.getString(7));
            u.setIdTipoUsuario(C.resultado.getInt(8));
            u.setIdTipoTurno(C.resultado.getInt(9));
            lu.add(u);
        }
        C.sentencia.close();
        return lu;
    }
    
    
    
    /*
     Fin Métodos Usuario
     */
    
    /*----------------------------------------------------------------------*/
    
    /*
     Inicio Métodos Paciente
     */
    
    public void crearPaciente(Paciente pa) throws SQLException {
        sql = "INSERT INTO paciente VALUES("
                + "NULL,"
                + "'" + pa.getRut() + "',"
                + "'" + pa.getNombre() + "',"
                + "'" + pa.getApellidos()+ "',"
                + "'" + pa.getFechaNacimiento()+ "',"
                + "'" + pa.getDireccion()+ "'"
                + ");";
        C.ejecutar(sql);
    }
    
    public Paciente getPacientePorId(int id) throws SQLException {
        Paciente pas = null;
        sql = "SELECT * FROM paciente WHERE paciente_id = '" + id + "'";
        C.resultado = C.ejecutarSelect(sql);
        if (C.resultado.next()) {
            pas = new Paciente(
                    C.resultado.getInt(1),
                    C.resultado.getString(2),
                    C.resultado.getString(3),
                    C.resultado.getString(4),
                    C.resultado.getDate(5),
                    C.resultado.getString(6)
            );
        }
        C.sentencia.close();
        return pas;
    }
    
    public Paciente getPacientePorRut(int rut) throws SQLException {
        Paciente pas = null;
        sql = "SELECT * FROM paciente WHERE paciente_rut = '" + rut + "'";
        C.resultado = C.ejecutarSelect(sql);
        if (C.resultado.next()) {
            pas = new Paciente(
                    C.resultado.getInt(1),
                    C.resultado.getString(2),
                    C.resultado.getString(3),
                    C.resultado.getString(4),
                    C.resultado.getDate(5),
                    C.resultado.getString(6)
            );
        }
        C.sentencia.close();
        return pas;
    }
    
    public List<Paciente> getPacienteLike(String arg) throws SQLException {
        sql = "SELECT * FROM paciente WHERE "
                + "paciente_rut like '%" + arg + "%' "
                + "OR "
                + "paciente_nombre like '%" + arg + "%' "
                + "OR "
                + "paciente_apellido like '%" + arg + "%';";
        C.resultado = C.ejecutarSelect(sql);
        Paciente pa;
        List<Paciente> pacien = new ArrayList<>();
        while (C.resultado.next()) {
            pa = new Paciente();
            pa.setId(C.resultado.getInt(1));
            pa.setRut(C.resultado.getString(2));
            pa.setNombre(C.resultado.getString(3));
            pa.setApellidos(C.resultado.getString(4));
            pa.setFechaNacimiento(C.resultado.getDate(5));
            pa.setDireccion(C.resultado.getString(6));
            pacien.add(pa);
        }
        C.sentencia.close();
        return pacien;
    }
    
    public void actualizarPaciente(Paciente pa) throws SQLException {
        sql = "UPDATE paciente SET "
                + "paciente_nombre = '" + pa.getNombre() + "', "
                + "paciente_apellido = '" + pa.getApellidos()+ "', "
                + "paciente_fechaNacimiento = '" + pa.getFechaNacimiento()+ "', "
                + "paciente_direccion = '" + pa.getDireccion()+ "' "
                + "WHERE "
                + "paciente_id = '" + pa.getId() + "';";
        C.ejecutar(sql);
    }
    
    public void eliminarPaciente(int id) throws SQLException {
        sql = "DELETE FROM paciente WHERE paciente_id = '" + id + "';";
        C.ejecutar(sql);
    }

    public List<Paciente> getPacientes() throws SQLException {
        sql = "SELECT * FROM paciente;";
        C.resultado = C.ejecutarSelect(sql);
        Paciente pa;
        List<Paciente> pacien = new ArrayList<>();
        while (C.resultado.next()) {
            pa = new Paciente();
            pa.setId(C.resultado.getInt(1));
            pa.setRut(C.resultado.getString(2));
            pa.setNombre(C.resultado.getString(3));
            pa.setApellidos(C.resultado.getString(4));
            pa.setFechaNacimiento(C.resultado.getDate(5));
            pa.setDireccion(C.resultado.getString(6));
            pacien.add(pa);
        }
        C.sentencia.close();
        return pacien;
    }
    
    /*
     Fin Métodos Paciente
     */
    
    /*----------------------------------------------------------------------*/
    
    /*
     Inicio Métodos Hospitalizacion
     */
    
    public void crearHospitalizacion(Hospitalizacion ho) throws SQLException {
        sql = "INSERT INTO hospitalizacion VALUES("
                + "NULL,"
                + "'" + ho.getMotivo()+ "',"
                + "'" + ho.getEstado()+ "',"
                + "'" + ho.getDiasHospitalizacion()+ "',"
                + "'" + ho.getFecha()+ "',"
                + "'" + ho.getIdPaciente()+ "',"
                + "'" + ho.getIdUsuario()+ "'"
                + ");";
        C.ejecutar(sql);
    }
    
    public Hospitalizacion getHospitalizacionPorId(int id) throws SQLException {
        Hospitalizacion hos = null;
        sql = "SELECT * FROM hospitalizacion WHERE hospitalizacion_id = '" + id + "'";
        C.resultado = C.ejecutarSelect(sql);
        if (C.resultado.next()) {
            hos = new Hospitalizacion(
                    C.resultado.getInt(1),
                    C.resultado.getString(2),
                    C.resultado.getString(3),
                    C.resultado.getInt(4),
                    C.resultado.getDate(5),
                    C.resultado.getInt(6),
                    C.resultado.getInt(7)
            );
        }
        C.sentencia.close();
        return hos;
    }
    
    public void actualizarHospitlizacion(Hospitalizacion ho) throws SQLException {
        sql = "UPDATE hospitalizacion SET "
                + "hospitalizacion_motivo = '" + ho.getMotivo()+ "', "
                + "hospitalizacion_estado = '" + ho.getEstado()+ "' "
                + "WHERE "
                + "paciente_id = '" + ho.getId() + "';";
        C.ejecutar(sql);
    }
    
    public List<Hospitalizacion> getHospitalizaciones() throws SQLException {
        sql = "SELECT * FROM hospitalizacion;";
        C.resultado = C.ejecutarSelect(sql);
        Hospitalizacion hosp;
        List<Hospitalizacion> lisHos = new ArrayList<>();
        while (C.resultado.next()) {
            hosp = new Hospitalizacion();
            hosp.setId(C.resultado.getInt(1));
            hosp.setMotivo(C.resultado.getString(2));
            hosp.setEstado(C.resultado.getString(3));
            hosp.setDiasHospitalizacion(C.resultado.getInt(4));
            hosp.setFecha(C.resultado.getDate(5));
            hosp.setIdPaciente(C.resultado.getInt(6));
            hosp.setIdUsuario(C.resultado.getInt(6));
            lisHos.add(hosp);
        }
        C.sentencia.close();
        return lisHos;
    }
    
    /*
     Fin Métodos Hospitalizacion
     */
    
    /*----------------------------------------------------------------------*/
    
    /*
     Inicio Métodos Control
     */
    
    public void crearControl(Control con) throws SQLException {
        sql = "INSERT INTO controles VALUES("
                + "NULL,"
                + "'" + con.getDescripcion()+ "',"
                + "'" + con.getEstado()+ "',"
                + "'" + con.getFecha()+ "',"
                + "'" + con.getIdHospitalizacion()+ "',"
                + "'" + con.getIdUsuario()+ "'"
                + ");";
        C.ejecutar(sql);
    }
    
    public void actualizarDescripcionControl(Control con) throws SQLException {
        sql = "UPDATE controles SET "
                + "controles_descripcion = '" + con.getDescripcion()+ "' "
                + "WHERE "
                + "controles_id = '" + con.getId() + "';";
        C.ejecutar(sql);
    }
    
    public List<Control> getControles() throws SQLException {
        sql = "SELECT * FROM controles;";
        C.resultado = C.ejecutarSelect(sql);
        Control co;
        List<Control> lisCon = new ArrayList<>();
        while (C.resultado.next()) {
            co = new Control();
            co.setId(C.resultado.getInt(1));
            co.setDescripcion(C.resultado.getString(2));
            co.setEstado(C.resultado.getString(3));
            co.setFecha(C.resultado.getDate(4));
            co.setIdHospitalizacion(C.resultado.getInt(5));
            co.setIdUsuario(C.resultado.getInt(6));
            lisCon.add(co);
        }
        C.sentencia.close();
        return lisCon;
    }
    
    /*
     Fin Métodos Control
     */
    
    /*----------------------------------------------------------------------*/
    
    /*
     Inicio Métodos Medicamentos
     */
    
    public void crearControl(Medicamentos med) throws SQLException {
        sql = "INSERT INTO medicamentos VALUES("
                + "NULL,"
                + "'" + med.getMedicamento()+ "',"
                + "'" + med.getDescripcion()+ "',"
                + "'" + med.getIdUsuario()+ "',"
                + "'" + med.getIdHospitalizacion()+ "'"
                + ");";
        C.ejecutar(sql);
    }
    
    public void actualizarDescripcionMedicamento(Medicamentos medi) throws SQLException {
        sql = "UPDATE medicamentos SET "
                + "medicamentos_descripcion = '" + medi.getDescripcion()+ "' "
                + "WHERE "
                + "medicamentos_id = '" + medi.getId() + "';";
        C.ejecutar(sql);
    }
    
    public List<Medicamentos> getMedicamentos() throws SQLException {
        sql = "SELECT * FROM controles;";
        C.resultado = C.ejecutarSelect(sql);
        Medicamentos me;
        List<Medicamentos> lisMed = new ArrayList<>();
        while (C.resultado.next()) {
            me = new Medicamentos();
            me.setId(C.resultado.getInt(1));
            me.setMedicamento(C.resultado.getString(2));
            me.setDescripcion(C.resultado.getString(3));
            me.setIdUsuario(C.resultado.getInt(4));
            me.setIdHospitalizacion(C.resultado.getInt(5));
            lisMed.add(me);
        }
        C.sentencia.close();
        return lisMed;
    }
    
    /*
     Fin Métodos Medicamentos
     */
    
    /*----------------------------------------------------------------------*/
    
    /*
     Inicio Métodos HospitalizacionUsuarios
     */
    
    public void crearControl(HospitalizacionUsuario con) throws SQLException {
        sql = "INSERT INTO HospitalizacionUsuarios VALUES("
                + "NULL,"
                + "'" + con.getIdUsuario()+ "',"
                + "'" + con.getIdHospitalizacion()+ "'"
                + ");";
        C.ejecutar(sql);
    }
    
    public List<HospitalizacionUsuario> getEnfermeasSegunIdHospitalizacion(int id) throws SQLException {
        sql = "SELECT * FROM HospitalizacionUsuarios WHERE HospitalizacionUsuarios_idHospitalizacion = '" + id + "'";
        C.resultado = C.ejecutarSelect(sql);
        HospitalizacionUsuario hoUs;
        List<HospitalizacionUsuario> lishoUs = new ArrayList<>();
        while (C.resultado.next()) {
            hoUs = new HospitalizacionUsuario();
            hoUs.setId(C.resultado.getInt(1));
            hoUs.setIdUsuario(C.resultado.getInt(2));
            hoUs.setIdHospitalizacion(C.resultado.getInt(2));
            lishoUs.add(hoUs);
        }
        C.sentencia.close();
        return lishoUs;
    }
    
    public List<HospitalizacionUsuario> getHospitalizacionUsuarios() throws SQLException {
        sql = "SELECT * FROM HospitalizacionUsuarios;";
        C.resultado = C.ejecutarSelect(sql);
        HospitalizacionUsuario hoUs;
        List<HospitalizacionUsuario> lishoUs = new ArrayList<>();
        while (C.resultado.next()) {
            hoUs = new HospitalizacionUsuario();
            hoUs.setId(C.resultado.getInt(1));
            hoUs.setIdUsuario(C.resultado.getInt(2));
            hoUs.setIdHospitalizacion(C.resultado.getInt(2));
            lishoUs.add(hoUs);
        }
        C.sentencia.close();
        return lishoUs;
    }
    
    /*
     Fin Métodos HospitalizacionUsuarios
     */
    
    
    public void crearRespaldo(Respaldo r) throws SQLException {
        sql = "INSERT INTO respaldo VALUES(NULL, '" + r.getFecha() + "', '" + r.getHora() + "', 0)";
        C.ejecutar(sql);
    }

    public List<Respaldo> getRespaldos() throws SQLException {
        respaldos = new ArrayList<>();
        sql = "SELECT * FROM respaldo";
        C.resultado = C.ejecutarSelect(sql);

        while (C.resultado.next()) {
            Respaldo r = new Respaldo(C.resultado.getInt(1), C.resultado.getString(2), C.resultado.getString(3));
            respaldos.add(r);
        }
        C.sentencia.close();
        return respaldos;
    }

    public Respaldo getRespaldo(String id) throws SQLException {
        Respaldo r = null;
        sql = "SELECT * FROM respaldo WHERE respaldo_id = '" + id + "'";
        C.resultado = C.ejecutarSelect(sql);

        if (C.resultado.next()) {
            r = new Respaldo(C.resultado.getInt(1), C.resultado.getString(2), C.resultado.getString(3));
        }
        C.sentencia.close();
        return r;
    }

    public void insertRespaldos(List<Respaldo> res) throws SQLException {
        C.ejecutar("TRUNCATE TABLE respaldo");
        for (Respaldo r : res ) {
            C.ejecutar("INSERT INTO respaldo VALUES (NULL, '"+r.getFecha()+"', '"+r.getHora()+"', '"+r.getTipo()+"')");
        }
    }
    
    
}
