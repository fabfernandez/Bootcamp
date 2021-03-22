import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RadixSort {
    public static void radixSort(int[] arr) {

        // PROGRAMAR AQUI

        //1 convertir a String[]
        String[] stringArray = StringUtils.toStringArray(arr);

        //2 completar los elementos del array, usar lNormalize
        StringUtils.lNormalize(stringArray, '0');
        int elemLength = stringArray[0].length(); //this is the same for all elements after normalizing

        //3 obtener 10 listas vacias o un map
        HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();
        int length = stringArray.length;
        ArrayList<String> emptyStringList = new ArrayList<>();

        hashMap.put(0, emptyStringList);
        hashMap.put(1, emptyStringList);
        hashMap.put(2, emptyStringList);
        hashMap.put(3, emptyStringList);
        hashMap.put(4, emptyStringList);
        hashMap.put(5, emptyStringList);
        hashMap.put(6, emptyStringList);
        hashMap.put(7, emptyStringList);
        hashMap.put(8, emptyStringList);
        hashMap.put(9, emptyStringList);

        //4 recorrer el array, en cada elemento miramos el ultimo digito y ponemos el elemento entero
        // en la lista que corresponda

        String[] newStringArray = new String[length];

        for (int lengthControl = 1; lengthControl < elemLength; lengthControl++) {

            for (int i = 0; i < length; i++) {
                String element = stringArray[i];

                Character digit = element.charAt(elemLength - lengthControl);

                Integer intDigit = Integer.parseInt(digit.toString());

                ArrayList<String> stringList = hashMap.get(intDigit);

                stringList.add(element);

                hashMap.put(intDigit, stringList);
            }

            //5 recorremos las listas en orden y generamos el array nuevamente

            int arrayIndex = 0;
            for (int mapIndex = 0; mapIndex < 10; mapIndex++) {

                if (!hashMap.get(mapIndex).isEmpty()) {
                    ArrayList<String> stringArrayList = hashMap.get(mapIndex);

                    for (int i = 0; i < stringArrayList.size(); i++) {
                        newStringArray[arrayIndex] = stringArrayList.get(i);
                        arrayIndex++;
                    }
                }
            }
        }

        int[] newIntArray = StringUtils.toIntArray(newStringArray);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = newIntArray[i];
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
                + StringUtils.trim(fabaString) +".");


        System.out.println("Testing indexOfN: 9 = " + StringUtils.indexOfN("John|Paul|George|Ringo", '|', 2));


        // Tests end ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::


        int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};

        //radixSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
    }
}
