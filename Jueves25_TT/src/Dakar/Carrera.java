package Dakar;

import java.util.List;

public class Carrera {
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente){
        verificarSiHayEspacio();

        Auto auto = new Auto();
        auto.setVelocidad(velocidad);
        auto.setAceleracion(aceleracion);
        auto.setAnguloDeGiro(anguloDeGiro);
        auto.setPatente(patente);

        vehiculos.add(auto);
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente){
        verificarSiHayEspacio();

        Moto moto = new Moto();
        moto.setVelocidad(velocidad);
        moto.setAceleracion(aceleracion);
        moto.setAnguloDeGiro(anguloDeGiro);
        moto.setPatente(patente);

        vehiculos.add(moto);
    }

    private void verificarSiHayEspacio(){
       if (vehiculos.size()  >= cantidadDeVehiculosPermitidos){
           throw new RuntimeException("Cantidad maxima de vehiculos alcanzada para esta carrera.");
       }
    }

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos) {
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

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
