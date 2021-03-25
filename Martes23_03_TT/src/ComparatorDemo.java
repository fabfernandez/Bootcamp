import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {

        Comparator<Person> byDni = Comparator.comparing(Person::getDni);

    }
}
