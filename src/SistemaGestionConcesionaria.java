import java.util.Scanner;

public class SistemaGestionConcesionaria {

    private static Concesionaria concesionaria = new Concesionaria();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = obtenerOpcion();
            ejecutarOpcion(opcion);
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú de Opciones ---");
        System.out.println("1. Agregar Cliente");
        System.out.println("2. Agregar Vehículo");
        System.out.println("3. Realizar Pedido");
        System.out.println("4. Generar Reporte");
        System.out.println("5. Salir");
    }

    private static int obtenerOpcion() {
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                agregarCliente();
                break;
            case 2:
                agregarVehiculo();
                break;
            case 3:
                realizarPedido();
                break;
            case 4:
                generarReporte();
                break;
            case 5:
                System.out.println("Saliendo del sistema...");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida, intente nuevamente.");
        }
    }

    // Validación simple para correo electrónico (contiene un '@')
    private static boolean esValidoCorreo(String correo) {
        return correo.contains("@");  // Verifica que tenga el carácter '@'
    }

    private static void agregarCliente() {
        System.out.print("Ingrese nombre del cliente: ");
        String nombre = scanner.next();
        
        System.out.print("Ingrese apellido del cliente: ");
        String apellido = scanner.next();

        System.out.print("Ingrese documento (DNI) del cliente: ");
        String documento = scanner.next();

        System.out.print("Ingrese correo del cliente: ");
        String correo = scanner.next();
        
        // Validar el correo
        while (!esValidoCorreo(correo)) {
            System.out.print("Correo inválido. Ingrese un correo válido (ejemplo@dominio.com): ");
            correo = scanner.next();
        }

        System.out.print("Ingrese teléfono del cliente: ");
        String telefono = scanner.next();

        try {
            Cliente cliente = new Cliente(nombre, apellido, documento, correo, telefono);
            concesionaria.agregarCliente(cliente);  // Llamamos a la función de concesionaria
            System.out.println("Cliente agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void agregarVehiculo() {
        System.out.print("Ingrese marca del vehículo: ");
        String marca = scanner.next();

        System.out.print("Ingrese modelo del vehículo: ");
        String modelo = scanner.next();

        System.out.print("Ingrese color del vehículo: ");
        String color = scanner.next();

        System.out.print("Ingrese número de chasis del vehículo: ");
        String numeroChasis = scanner.next();
        while (numeroChasis.isEmpty()) {
            System.out.print("Número de chasis inválido. Ingrese nuevamente: ");
            numeroChasis = scanner.next();
        }

        System.out.print("Ingrese número de motor del vehículo: ");
        String numeroMotor = scanner.next();
        while (numeroMotor.isEmpty()) {
            System.out.print("Número de motor inválido. Ingrese nuevamente: ");
            numeroMotor = scanner.next();
        }

        try {
            Vehiculo vehiculo = new Vehiculo(marca, modelo, color, numeroChasis, numeroMotor);
            concesionaria.agregarVehiculo(vehiculo);  // Llamamos a la función de concesionaria
            System.out.println("Vehículo agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void realizarPedido() {
        // Pedir el documento del cliente y verificar que exista
        System.out.print("Ingrese documento del cliente: ");
        String documentoCliente = scanner.next();

        // Buscar al cliente por documento
        Cliente cliente = null;
        for (Cliente c : concesionaria.getClientes()) {  // Usamos el getter para obtener la lista de clientes
            if (c.getDocumento().equals(documentoCliente)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Error: Cliente no encontrado.");
            return;
        }

        // Pedir el número de chasis del vehículo y verificar que exista
        System.out.print("Ingrese número de chasis del vehículo: ");
        String numeroChasisVehiculo = scanner.next();

        Vehiculo vehiculo = null;
        for (Vehiculo v : concesionaria.getVehiculos()) {
            if (v.getNumeroChasis().equals(numeroChasisVehiculo)) {
                vehiculo = v;
                break;
            }
        }

        if (vehiculo == null) {
            System.out.println("Error: Vehículo no encontrado.");
            return;
        }

        // Pedir la forma de pago y el costo total
        System.out.print("Ingrese forma de pago (contado, transferencia, tarjeta): ");
        String formaPago = scanner.next();
        System.out.print("Ingrese costo total: ");
        double costoTotal = scanner.nextDouble();

        try {
            // Realizar el pedido
            concesionaria.realizarPedido(cliente, vehiculo, formaPago, costoTotal);  // Llamamos a la función de concesionaria
            System.out.println("Pedido realizado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void generarReporte() {
        System.out.println("\n--- Reporte de Pedidos ---");
        concesionaria.generarReporte();  // Llamamos al reporte de concesionaria
    }
}




