import Model.Prenda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuardaRopa {

    private Integer contador;

    private final HashMap<Integer, List<Prenda>> deposito;

    public Integer guardarPrendas(List<Prenda> prendas){
        contador++;
        deposito.put(contador, prendas);
        return contador;
    }

    public GuardaRopa() {
        contador = 0;
        deposito = new HashMap<>();
    }

    public void mostrarPrendas(){
        deposito.forEach((key, value)-> {
            System.out.println("En el locker " + key + " hay ");
            for (Prenda prenda: value) {
                System.out.println(prenda.toString());
            }
        });
    }

    public List<Prenda> retirarPrendas(Integer numero){
        List<Prenda> prendas = deposito.get(numero);
        deposito.remove(numero);
        return prendas;
    }

    public static void main(String[] args) {
        GuardaRopa guardaRopa1 = new GuardaRopa();

        Prenda campera = new Prenda("Columbia", "campera piola");

        Prenda bufanda = new Prenda("Bufanda", "rayada");

        ArrayList<Prenda> prendas = new ArrayList<>();
        prendas.add(campera);
        prendas.add(bufanda);

        guardaRopa1.guardarPrendas(prendas);

        guardaRopa1.guardarPrendas(prendas);

        guardaRopa1.mostrarPrendas();

        guardaRopa1.retirarPrendas(1);
        System.out.println("Prendas retiradas.");

        guardaRopa1.mostrarPrendas();
    }

}
