import java.util.ArrayList;

public class StringUtils {

    // Retorna una cadena compuesta por n caracteres c
    // Ejemplo: replicate('x',5) ==> 'xxxxx'
    public static String replicate(char c, int n) {
        String string = Character.toString(c);
        return string.repeat(n);
    }

    // Retorna una cadena de longitud length, compuesta por string
    // y precedida de tantos caracteres filler como sea necesario
    // para completar la longitud mencionada
    // Ejemplo lpad("5",3,'0') ==> "005"
    public static String lpad(String string, int length, char filler) {
        int fillCount = length - string.length();

        String filling = replicate(filler, fillCount);

        return filling + string;
    }

    // Retorna un String[] conteniendo los elementos de array
    // representados como cadenas de caracteres
    public static String[] toStringArray(int[] arr) {
        int length = arr.length;

        Integer[] integerArray = new Integer[length];

        String[] stringArray = new String[length];

        for (int i = 0; i < length; i++) {
            integerArray[i] = arr[i];
            stringArray[i] = integerArray[i].toString();
        }

        return stringArray;
    }

    // Retorna un int[] conteniendo los elementos de arr
    public static int[] toIntArray(String[] arr) {
        int length = arr.length;

        int[] intArray = new int[length];

        for (int i = 0; i < length; i++) {
            intArray[i] = Integer.parseInt(arr[i]);
        }

        return intArray;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String[] arr) {
        int max = 0;

        for (String s : arr) {
            int elementSize = s.length();
            if (elementSize > max) {
                max = elementSize;
            }
        }
        return max;
    }

    // Completa los elementos del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor elemento del arr
    public static void lNormalize(String[] arr, char c) {
        int maxLength = maxLength(arr);

        int length = arr.length;

        for (int i = 0; i < length; i++) {
            arr[i] = lpad(arr[i], maxLength, c);
        }
    }


    //public static String rpad(String s,char c,int n); idem lpad, pero agregando caracteres la derecha.

    public static String rpad(String string, int length, char filler) {
        int fillCount = length - string.length();

        String filling = replicate(filler, fillCount);

        return string + filling;
    }

    //public static String ltrim(String s); Retorna una cadena idéntica a s pero sin espacios a
    //la izquierda.

    public static String ltrim(String s) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer = s.substring(i + 1);
            } else {
                i = s.length();
            }
        }
        return answer;
    }

    //public static String rtrim(String s); idem ltrim, pero sin espacios a la derecha.

    public static String rtrim(String s) {

        String answer = "";

        for (int i = s.length(); i > 0; i--) {
            if (s.charAt(i - 1) == ' ') {
                answer = s.substring(i - 1);
            }
        }
        return answer;
    }


}
