package strategy.Trabajador;

import strategy.CalcularPago.CalcularPagoPorBase;

import java.time.LocalTime;

public class TrabajadorPorBase extends TrabajadorAbstract{

    public TrabajadorPorBase(String nombre,
                                double salario,
                                int diasDeTrabajo) {
        super(nombre, salario, diasDeTrabajo, new CalcularPagoPorBase(salario/8));
    }
}
