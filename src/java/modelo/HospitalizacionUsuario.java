package modelo;

public class HospitalizacionUsuario {
    public int id;
    public int idUsuario;
    public int idHospitalizacion;

    public HospitalizacionUsuario() {
    }

    public HospitalizacionUsuario(int id, int idUsuario, int idHospitalizacion) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idHospitalizacion = idHospitalizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdHospitalizacion() {
        return idHospitalizacion;
    }

    public void setIdHospitalizacion(int idHospitalizacion) {
        this.idHospitalizacion = idHospitalizacion;
    }
    
}
