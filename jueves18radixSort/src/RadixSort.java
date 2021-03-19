import java.util.Arrays;

public class RadixSort {
    public static void radixSort(int[] arr) {

        // PROGRAMAR AQUI

    }

    public static void main(String[] args) {

        // "Tests" ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        System.out.println("Here are ten F:  "+StringUtils.replicate('F', 10));


        System.out.println("0090 = "+StringUtils.lpad("90", 4, '0'));


        int[] intArray = new int[4];
        intArray[0]=1;
        intArray[1]=2;
        intArray[2]=3;
        intArray[3]=4;

        System.out.println("[1 ,2 ,3 ,4] = "+ Arrays.toString(StringUtils.toStringArray(intArray)));


        String[] stringArray = new String[4];
        stringArray[0]="1";
        stringArray[1]="2";
        stringArray[2]="3";
        stringArray[3]="4";

        System.out.println("[1 ,2 ,3 ,4] = "+ Arrays.toString(StringUtils.toIntArray(stringArray)));


        String[] stringArray1 = new String[4];
        stringArray1[0]="A";
        stringArray1[1]="BBBBB";
        stringArray1[2]="CC";
        stringArray1[3]="DD";

        System.out.println("5 = " + StringUtils.maxLength(stringArray1));


        String[] stringArray2 = new String[4];
        stringArray2[0]="1";
        stringArray2[1]="55555";
        stringArray2[2]="22";
        stringArray2[3]="333";

        StringUtils.lNormalize(stringArray2, '0');

        System.out.println("[00001, 55555, 00022, 00333] = " + Arrays.toString(stringArray2));


        
        // Tests end ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::



        int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};

        radixSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
    }
}
