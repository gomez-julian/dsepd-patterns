package strategy.Trabajador;

import strategy.CalcularPago.CalcularPagoPorConfianza;

public class TrabajadorPorConfianza extends TrabajadorAbstract{

    private double salarioBase;

    public TrabajadorPorConfianza(String nombre,
                                  double salarioDiario,
                                  double salarioBase,
                                  int diasDeTrabajo) {
        super(nombre, salarioDiario, diasDeTrabajo, new CalcularPagoPorConfianza(salarioDiario, salarioBase));
    }
}
