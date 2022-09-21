package strategy.Trabajador;

import strategy.CalcularPago.CalcularPagoEstrategia;
import strategy.SemanaLaboral;

import java.time.LocalTime;

public abstract class TrabajadorAbstract {
    private   static int                    conteoTrabajadores = 0;
    protected        int                    idTrabajador;
    protected        int                    diasDeTrabajo;
    protected        double                 salario;
    protected        String                 nombre;
    protected        SemanaLaboral          semanaLaboral;
    protected        CalcularPagoEstrategia calcularPago;

    protected TrabajadorAbstract(String nombre,
                                 double salario,
                                 int diasDeTrabajo,
                                 CalcularPagoEstrategia estrategia) {
        this.nombre = nombre;
        this.salario = salario;
        this.diasDeTrabajo = diasDeTrabajo;
        this.calcularPago = estrategia;
        this.idTrabajador = asignarID();
        this.semanaLaboral = new SemanaLaboral(nombre, diasDeTrabajo);
    }

    private int asignarID() {
        conteoTrabajadores++;
        return conteoTrabajadores;
    }

    public void pagarTrabajador() {
        double pago = this.calcularPago.calcularPago(semanaLaboral);
        System.out.println("Se le ha pagado a " + nombre + " la cantidad de: $" + pago);
        this.semanaLaboral.terminarSemana();
    }

    public void registrarChecador(LocalTime time){
        semanaLaboral.registrar(time);
    }
}
