package Dakar;

import java.util.ArrayList;
import java.util.List;

public class DemoCarrera {
    public static void main(String[] args) {

        Auto autoRapido = Auto.buildAuto(400, 100, 30, "FAST");

        Auto autoLentisimo = Auto.buildAuto(1, 1, 1, "SLOW");

        Auto autoMedio = Auto.buildAuto(120, 68, 15, "MIDDLE");

        ArrayList<Vehiculo> autos = new ArrayList<>(List.of(autoMedio, autoLentisimo, autoRapido));

        Carrera carrera = new Carrera(10,
                5000,
                "Carrera de la muerte",
                10,
                autos);

        carrera.darDeAltaAuto(2, 2, 2, "NEW_SLOWW");

        carrera.eliminarVehiculo(autoLentisimo);

        carrera.darDeAltaAuto(420, 420, 420, "420");

        carrera.eliminarVehiculoConPatente("420");

        System.out.println("AND THE WINNER IS:         " + carrera.ganador().toString());

    }
}
