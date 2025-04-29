import java.util.ArrayList;
import java.util.List;

public class Concesionaria {
    // Hacemos que la lista de clientes sea privada
    private List<Cliente> clientes;
    private List<Vehiculo> vehiculos;
    private List<Pedido> pedidos;

    public Concesionaria() {
        clientes = new ArrayList<>();
        vehiculos = new ArrayList<>();
        pedidos = new ArrayList<>();
    }

    // Getter para acceder a la lista de clientes desde afuera de la clase Concesionaria
    public List<Cliente> getClientes() {
        return clientes;
    }
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    // Agregar cliente
    public void agregarCliente(Cliente cliente) throws Exception {
        for (Cliente c : clientes) {
            if (c.getDocumento().equals(cliente.getDocumento())) {
                throw new Exception("Cliente ya registrado");
            }
        }
        clientes.add(cliente);
    }

    // Agregar vehículo
    public void agregarVehiculo(Vehiculo vehiculo) throws Exception {
        for (Vehiculo v : vehiculos) {
            if (v.getNumeroChasis().equals(vehiculo.getNumeroChasis())) {
                throw new Exception("Vehículo ya registrado");
            }
        }
        vehiculos.add(vehiculo);
    }

    // Crear pedido de compra
    public void realizarPedido(Cliente cliente, Vehiculo vehiculo, String formaPago, double costoTotal) throws Exception {
        if (!clientes.contains(cliente)) {
            throw new Exception("Cliente no registrado");
        }
        if (!vehiculos.contains(vehiculo)) {
            throw new Exception("Vehículo no disponible");
        }

        Pedido nuevoPedido = new Pedido("P" + (pedidos.size() + 1), new java.util.Date(), cliente, vehiculo, formaPago, costoTotal, "En proceso");
        pedidos.add(nuevoPedido);
    }

    // Mostrar reportes de pedidos
    public void generarReporte() {
        for (Pedido pedido : pedidos) {
            System.out.println("Pedido: " + pedido.getNumeroPedido() + ", Cliente: " + pedido.getCliente().getNombre() + " " + pedido.getCliente().getApellido() + ", Vehículo: " + pedido.getVehiculo().getModelo() + ", Estado: " + pedido.getEstado());
        }
    }
}


