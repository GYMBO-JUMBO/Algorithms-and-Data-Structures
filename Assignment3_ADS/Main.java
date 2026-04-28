public class Main {
    public static void main(String[] args) {
        int[] arr1 = ArrayGenerator.generate(20);
        int[] arr2 = ArrayGenerator.generate(20);
        int x = 22;

        System.out.println("Before sort:");
        ArrayGenerator.printArray(arr1);
        System.out.println();
        ArrayGenerator.printArray(arr2);
        System.out.println();

        Sorter.bubbleSort(arr1);
        System.out.println("After the bubble sort:");
        ArrayGenerator.printArray(arr1);
        System.out.println();

        Sorter.mergeSort(arr2, 0, arr2.length - 1);
        System.out.println("After the merge sort:");
        ArrayGenerator.printArray(arr2);
        System.out.println();

        int res = BinarySearch.binarySearch(arr2, x);
        System.out.println("After the binary search:");
        System.out.println("The element " + x + " index is: " + res);

        System.out.println("\n--- Experiment ---");
        Experiment exp = new Experiment();
        exp.runAllExperiments();
    }
}