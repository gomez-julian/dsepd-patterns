package tests;

import org.junit.jupiter.api.Test;
import strategy.Trabajador.TrabajadorPorBase;
import strategy.Trabajador.TrabajadorPorConfianza;

import java.time.DayOfWeek;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class StrategyTest {
    @Test
    public void testTrabajadoresDia() {
        System.out.println("Pagando a un trabajador de base");
        TrabajadorPorBase trabajadorBase =
                new TrabajadorPorBase("Julián Gómez", 200, 6);
        trabajadorBase.registrarChecador(LocalTime.of(8, 25, 0));
        trabajadorBase.registrarChecador(LocalTime.of(17, 42, 11));
        trabajadorBase.pagarTrabajador();

        /** ------------------------------------------------------------------------ **/

        System.out.println("Pagando a un trabajador de confianza");
        TrabajadorPorConfianza trabajadorConfianza =
                new TrabajadorPorConfianza("Enrique Suárez", 200, 2000, 6);
        trabajadorConfianza.registrarChecador(LocalTime.of(8, 25, 0));
        trabajadorConfianza.registrarChecador(LocalTime.of(17, 42, 11));
        trabajadorConfianza.pagarTrabajador();
    }

    @Test
    public void testTrabajadoresSemana() {
        System.out.println("Julián y Enrique viven juntos y van al mismos trabajo a la misma hora...");

        TrabajadorPorBase trabajadorBase =
                new TrabajadorPorBase("Julián Gómez", 200, 6);
        TrabajadorPorConfianza trabajadorConfianza =
                new TrabajadorPorConfianza("Enrique Suárez", 200, 2000, 6);

        for (int i = 1; i <= 6; i++) {
            LocalTime localTimeEntrada = LocalTime.of((int) (Math.random() * (3)) + 7,
                    (int) (Math.random() * 60));
            trabajadorBase.registrarChecador(localTimeEntrada);
            trabajadorConfianza.registrarChecador(localTimeEntrada);

            LocalTime localTimeSalida = LocalTime.of((int) (Math.random() * (3)) + 15,
                    (int) (Math.random() * 60));
            trabajadorBase.registrarChecador(localTimeSalida);
            trabajadorConfianza.registrarChecador(localTimeSalida);

            System.out.println(DayOfWeek.of(i).toString() + ": Julián y Enrique entraron a trabajar a las " +
                    localTimeEntrada.toString() + " y salieron a las " + localTimeSalida.toString());
        }
        trabajadorBase.pagarTrabajador();
        trabajadorConfianza.pagarTrabajador();
    }
}
