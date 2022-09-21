package strategy.CalcularPago;

import strategy.SemanaLaboral;

public class CalcularPagoPorConfianza implements CalcularPagoEstrategia{
    private double salarioPorDia;
    private double salarioBase;

    public CalcularPagoPorConfianza(double salarioPorDia, double salarioBase) {
        this.salarioPorDia = salarioPorDia;
        this.salarioBase = salarioBase;
    }

    @Override
    public double calcularPago(SemanaLaboral semanaLaboral) {
        return semanaLaboral.diasTrabajados() * salarioPorDia + salarioBase;
    }
}
