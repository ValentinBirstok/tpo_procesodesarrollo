import java.util.Date;

public class Pedido {
    private String numeroPedido;
    private Date fechaCreacion;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private String formaPago;
    private double costoTotal;
    private String estado;

    public Pedido(String numeroPedido, Date fechaCreacion, Cliente cliente, Vehiculo vehiculo, String formaPago, double costoTotal, String estado) {
        this.numeroPedido = numeroPedido;
        this.fechaCreacion = fechaCreacion;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.formaPago = formaPago;
        this.costoTotal = costoTotal;
        this.estado = estado;
    }

    // Getters y Setters
    public String getNumeroPedido() { return numeroPedido; }
    public Date getFechaCreacion() { return fechaCreacion; }
    public Cliente getCliente() { return cliente; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public String getFormaPago() { return formaPago; }
    public double getCostoTotal() { return costoTotal; }
    public String getEstado() { return estado; }

    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }
}

