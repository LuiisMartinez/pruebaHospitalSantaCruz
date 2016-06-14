package modelo;

import java.sql.Date;

public class Hospitalizacion {
    public int id;
    public String motivo;
    public String estado;
    public int diasHospitalizacion;
    public Date fecha;
    public int idPaciente;
    public int idUsuario;

    public Hospitalizacion() {
    }

    public Hospitalizacion(int id, String motivo, String estado, int diasHospitalizacion, Date fecha, int idPaciente, int idUsuario) {
        this.id = id;
        this.motivo = motivo;
        this.estado = estado;
        this.diasHospitalizacion = diasHospitalizacion;
        this.fecha = fecha;
        this.idPaciente = idPaciente;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getDiasHospitalizacion() {
        return diasHospitalizacion;
    }

    public void setDiasHospitalizacion(int diasHospitalizacion) {
        this.diasHospitalizacion = diasHospitalizacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
