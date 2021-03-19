import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Fecha {

    private GregorianCalendar calendar;

    public Fecha() {
        this.calendar = new GregorianCalendar();
    }

    public Fecha(int anio, int mes, int dia) {
        this.calendar = new GregorianCalendar(anio, mes, dia);
    }

    public GregorianCalendar getCalendar() {
        return calendar;
    }

    public void setCalendar(GregorianCalendar calendar) {
        this.calendar = calendar;
    }

    public void sumarUnDia() {
        this.calendar.add(GregorianCalendar.DAY_OF_MONTH, 1);
    }

    public static boolean esCorrecta(int anio, int mes, int dia) {
        try {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(anio, mes, dia);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "calendar=" + calendar +
                '}';
    }

}
