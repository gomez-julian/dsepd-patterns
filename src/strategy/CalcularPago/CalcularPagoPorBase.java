package strategy.CalcularPago;

import strategy.SemanaLaboral;

public class CalcularPagoPorBase implements CalcularPagoEstrategia{

    private double salarioPorHora;

    public CalcularPagoPorBase(double salarioPorHora){
        this.salarioPorHora = salarioPorHora;
    }
    @Override
    public double calcularPago(SemanaLaboral semanaLaboral) {
        return semanaLaboral.horasTrabajadas() * salarioPorHora;
    }
}
