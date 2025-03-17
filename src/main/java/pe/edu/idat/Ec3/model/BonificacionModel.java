package pe.edu.idat.demo_web_formularios.model;

public class BonificacionModel {
    private double monto;
    private  int dias;
    private double descuento;

    public double getMonto(){
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
