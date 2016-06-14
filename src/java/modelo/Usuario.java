package modelo;

import java.sql.Date;

public class Usuario {
    public int id;
    public String rut;
    public String nombre;
    public String apellidos;
    public Date fechaNacimiento;
    public String email;
    public String clave;
    public int idTipoUsuario;
    public int idTipoTurno;

    public Usuario() {
    }

    public Usuario(int id, String rut, String nombre, String apellidos, Date fechaNacimiento, String email, String clave, int idTipoUsuario, int idTipoTurno) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.clave = clave;
        this.idTipoUsuario = idTipoUsuario;
        this.idTipoTurno = idTipoTurno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public int getIdTipoTurno() {
        return idTipoTurno;
    }

    public void setIdTipoTurno(int idTipoTurno) {
        this.idTipoTurno = idTipoTurno;
    }
    
}
