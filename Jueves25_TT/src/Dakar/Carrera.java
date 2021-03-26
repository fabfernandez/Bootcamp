package Dakar;

import java.util.*;
import java.util.stream.Collectors;

public class Carrera {
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private ArrayList<Vehiculo> vehiculos;

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        verificarSiHayEspacio();

        Auto auto = new Auto();
        auto.setVelocidad(velocidad);
        auto.setAceleracion(aceleracion);
        auto.setAnguloDeGiro(anguloDeGiro);
        auto.setPatente(patente);

        vehiculos.add(auto);

        System.out.println("Se dio de alta auto patente " + patente + " ::::::: " + auto.toString());
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        verificarSiHayEspacio();

        Moto moto = new Moto();
        moto.setVelocidad(velocidad);
        moto.setAceleracion(aceleracion);
        moto.setAnguloDeGiro(anguloDeGiro);
        moto.setPatente(patente);

        vehiculos.add(moto);
    }

    private void verificarSiHayEspacio() {
        if (vehiculos.size() >= cantidadDeVehiculosPermitidos) {
            throw new RuntimeException("Cantidad maxima de vehiculos alcanzada para esta carrera.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (vehiculos.contains(vehiculo)) {
            vehiculos.remove(vehiculo);
            System.out.println("Se elimino auto patente " + vehiculo.getPatente() + " ::::::: " + vehiculo.toString());
        } else {
            throw new RuntimeException("El vehiculo ingresado no esta en esta carrera.");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente) {

        List<Vehiculo> vehiculosFiltrados = vehiculos
                .stream().filter(vehiculo -> vehiculo.getPatente().equals(unaPatente)).collect(Collectors.toList());

        if (vehiculosFiltrados.size() > 0) {
            eliminarVehiculo(vehiculosFiltrados.get(0));
        }
    }

    public Vehiculo ganador() {

        vehiculos.sort(Comparator.comparing(Vehiculo::calcularPuntaje));

        return vehiculos.get(vehiculos.size()-1);
    }


    public Carrera(int distancia,
                   int premioEnDolares,
                   String nombre,
                   int cantidadDeVehiculosPermitidos,
                   ArrayList<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(int premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "vehiculos=" + vehiculos +
                '}';
    }
}
