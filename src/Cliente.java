public class Cliente {
    private String nombre;
    private String apellido;
    private String documento;
    private String correo;
    private String telefono;

    public Cliente(String nombre, String apellido, String documento, String correo, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", documento='" + documento + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
