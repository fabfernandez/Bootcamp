package Dakar;

public class Auto extends Vehiculo{
    public Auto() {
        setPeso(1000);
        setCantidadRuedas(4);
    }

    public static Auto buildAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente){
       Auto autoNuevo = new Auto();
       autoNuevo.setVelocidad(velocidad);
       autoNuevo.setAceleracion(aceleracion);
       autoNuevo.setAnguloDeGiro(anguloDeGiro);
       autoNuevo.setPatente(patente);
       return autoNuevo;
    }

}
