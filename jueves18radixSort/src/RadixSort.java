import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RadixSort {
    public static void radixSort(int[] arr) {

        //1 convertir a String[]
        String[] stringArray = StringUtils.toStringArray(arr);

        //2 completar los elementos del array, usar lNormalize
        StringUtils.lNormalize(stringArray, '0');
        int elemLength = stringArray[0].length();
        //El largo de los elementos es el mismo para todos los elementos, porque estan normalizados.

        //3 obtener 10 listas vacias o un map
        HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();

        hashMap.put(0, new ArrayList<>());
        hashMap.put(1, new ArrayList<>());
        hashMap.put(2, new ArrayList<>());
        hashMap.put(3, new ArrayList<>());
        hashMap.put(4, new ArrayList<>());
        hashMap.put(5, new ArrayList<>());
        hashMap.put(6, new ArrayList<>());
        hashMap.put(7, new ArrayList<>());
        hashMap.put(8, new ArrayList<>());
        hashMap.put(9, new ArrayList<>());


        //Recorrer digito por digito, empezando por el ultimo digito.
        for (int lengthControl = 1; lengthControl < elemLength + 1; lengthControl++) {

            //Recorrer el array y guardar en el hashMap
            storeInHashMap(hashMap, stringArray, lengthControl);

            //recorremos el mapa en orden y generamos el array nuevamente

            ArrayList<String> stringBuffer = new ArrayList<>();

            for (int key = 0; key < 10; key++) {

                if (!hashMap.get(key).isEmpty()) {
                    ArrayList<String> strings = hashMap.get(key);

                    for (String string : strings) {
                        stringBuffer.add(string);
                    }

                    hashMap.put(key, new ArrayList<>()); //Vaciar el hashmap
                }
            }
            //Sobreescribir el array con los numeros ordenados
            int index = 0;
            for (String string : stringBuffer) {
                stringArray[index] = string;
                index++;
            }
        }

        int[] newIntArray = StringUtils.toIntArray(stringArray);

        System.arraycopy(newIntArray, 0, arr, 0, arr.length);

    }

    private static void storeInHashMap(HashMap<Integer, ArrayList<String>> hashMap, String[] stringArray, int lengthControl) {

        int elemLength = stringArray[0].length();

        //Recorrer el array y guardar en el hashMap
        for (String element : stringArray) {
            char digit = element.charAt(elemLength - lengthControl);

            Integer intDigit = Integer.parseInt(Character.toString(digit));

            ArrayList<String> stringList = hashMap.get(intDigit);

            stringList.add(element);

            hashMap.put(intDigit, stringList);
        }
    }


    public static void main(String[] args) {

        // "Tests" ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        System.out.println("FFF = " + StringUtils.replicate('F', 3));


        System.out.println("0090 = " + StringUtils.lpad("90", 4, '0'));


        int[] intArray = new int[4];
        intArray[0] = 1;
        intArray[1] = 2;
        intArray[2] = 3;
        intArray[3] = 4;

        System.out.println("[1 ,2 ,3 ,4] = " + Arrays.toString(StringUtils.toStringArray(intArray)));


        String[] stringArray = new String[4];
        stringArray[0] = "1";
        stringArray[1] = "2";
        stringArray[2] = "3";
        stringArray[3] = "4";

        System.out.println("[1 ,2 ,3 ,4] = " + Arrays.toString(StringUtils.toIntArray(stringArray)));


        String[] stringArray1 = new String[4];
        stringArray1[0] = "A";
        stringArray1[1] = "BBBBB";
        stringArray1[2] = "CC";
        stringArray1[3] = "DD";

        System.out.println("5 = " + StringUtils.maxLength(stringArray1));


        String[] stringArray2 = new String[4];
        stringArray2[0] = "1";
        stringArray2[1] = "55555";
        stringArray2[2] = "22";
        stringArray2[3] = "333";

        StringUtils.lNormalize(stringArray2, '0');

        System.out.println("[00001, 55555, 00022, 00333] = " + Arrays.toString(stringArray2));

        String fabaString = "   faba   ";
        System.out.println("faba="
                + StringUtils.ltrim(fabaString)
                + "="
                + StringUtils.rtrim(fabaString)
                + "="
                + StringUtils.trim(fabaString) + ".");


        System.out.println("Testing indexOfN: 9 = " + StringUtils.indexOfN("John|Paul|George|Ringo", '|', 2));


        // Tests end ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::


        int[] arr = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};

        System.out.println("TESTING RADIX SORT: ");

        System.out.println(Arrays.toString(arr));

        radixSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
    }
}
