package modelo;

import java.sql.Date;

public class Control {
    public int id;
    public String descripcion;
    public String estado;
    public Date fecha;
    public int idHospitalizacion;
    public int idUsuario;

    public Control() {
    }

    public Control(int id, String descripcion, String estado, Date fecha, int idHospitalizacion, int idUsuario) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha = fecha;
        this.idHospitalizacion = idHospitalizacion;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdHospitalizacion() {
        return idHospitalizacion;
    }

    public void setIdHospitalizacion(int idHospitalizacion) {
        this.idHospitalizacion = idHospitalizacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
