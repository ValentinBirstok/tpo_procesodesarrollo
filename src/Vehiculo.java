public class Vehiculo {
    private String marca;
    private String modelo;
    private String color;
    private String numeroChasis;
    private String numeroMotor;

    public Vehiculo(String marca, String modelo, String color, String numeroChasis, String numeroMotor) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.numeroChasis = numeroChasis;
        this.numeroMotor = numeroMotor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", número de chasis='" + numeroChasis + '\'' +
                ", número de motor ='" + numeroMotor + '\'' +
                '}';
    }
}


