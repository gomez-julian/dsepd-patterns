package strategy;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Vector;

public class SemanaLaboral {
    private Vector<DiaLaboral> semana;
    private DiaLaboral diaActual;
    private String nombreEmpleado;
    private int diasDeTrabajo;

    public SemanaLaboral(String nombreEmpleado, int diasDeTrabajo){
        semana = new Vector<>();
        diaActual = null;
        this.nombreEmpleado = nombreEmpleado;
        this.diasDeTrabajo = diasDeTrabajo;
    }

    public int diasTrabajados(){
        return semana.size();
    }

    public long horasTrabajadas(){
        long horasTrabajadas = 0;
        for(DiaLaboral dia: semana)
            horasTrabajadas += dia.totalTrabajado();
        return horasTrabajadas;
    }

    public void registrar(LocalTime hora){
        if(semana.size() >= diasDeTrabajo)
            throw new RuntimeException(nombreEmpleado + "no puede trabajar más de " + diasDeTrabajo + " días.");
        if(diaActual == null)
            diaActual = new DiaLaboral(hora);
        else{
            diaActual.registrarSalida(hora);
            semana.add(diaActual);
            diaActual=null;
        }
    }

    public void terminarSemana(){
        if(diaActual != null)
            throw new RuntimeException("No puedes terminar la semana sin registrar la última hora de salida");
        semana = new Vector<>();
    }

    private class DiaLaboral{

        private LocalTime horaEntrada, horaSalida;
        private DiaLaboral(LocalTime horaEntrada){
            this.horaEntrada = horaEntrada;
        }
        private void registrarSalida(LocalTime horaSalida) {
            this.horaSalida = horaSalida;
        }
        private long totalTrabajado(){
            return ChronoUnit.HOURS.between(horaEntrada, horaSalida);
        }
    }

}
