package FINAL;
//Estructura básica de un objeto, normal y corriente.

public class Oficina {
    private int oficina;
    private String ciudad;
    private double superficie;
    private double ventas;

    public Oficina(int oficina, String ciudad, int superficie, int ventas) {
        this.oficina = oficina;
        this.ciudad = ciudad;
        this.superficie = superficie;
        this.ventas = ventas;
    }

    public int getOficina() {
        return oficina;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getSuperficie() {
        return superficie;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        return "Oficina: Nº: " + oficina + ", ciudad: " + ciudad + ", superficie: " + superficie +", ventas: " + ventas;
    }
}
