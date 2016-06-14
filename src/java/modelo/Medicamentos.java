package modelo;

public class Medicamentos {
    public int id;
    public String medicamento;
    public String descripcion;
    public int idUsuario;
    public int idHospitalizacion;

    public Medicamentos() {
    }

    public Medicamentos(int id, String medicamento, String descripcion, int idUsuario, int idHospitalizacion) {
        this.id = id;
        this.medicamento = medicamento;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
        this.idHospitalizacion = idHospitalizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
