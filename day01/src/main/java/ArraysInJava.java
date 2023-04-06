public class ArraysInJava {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        int[] evenNumbers = {2, 4, 6, 8};

        int numbersLst[] = new int[10];
        int evenNumbersLst[] = {2, 4, 6, 8};
        for (int i = 0; i < evenNumbersLst.length; i++) {
            System.out.println(evenNumbersLst[i]);
        }
        for (int num : evenNumbersLst) {
            System.out.println(num);
        }

//        int []numbersArr = new int[10];
//        int []evenNumbersArr = {2, 4, 6, 8};

        int[][] matrix = new int[10][];
        int[] matrix2[] = new int[10][];
        int matrix3[][] = new int[10][];

    }
}
