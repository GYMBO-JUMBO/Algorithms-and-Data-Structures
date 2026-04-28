public class Experiment {

    long measureSortTime(int[] arr, String type) {
        long startTime = System.nanoTime();
        if (type.equals("bubble")) {
            Sorter.bubbleSort(arr);
        }
        if (type.equals("merge")) {
            Sorter.mergeSort(arr, 0, arr.length - 1);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    long measureSearchTime(int[] arr, int x) {
        long startTime = System.nanoTime();
        BinarySearch.binarySearch(arr, x);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    void runAllExperiments() {
        int[] sizes = {100, 1000, 10000};

        for (int size : sizes) {
            int[] arrBubble = ArrayGenerator.generate(size);
            int[] arrMerge  = ArrayGenerator.generate(size);

            long bubbleTime = measureSortTime(arrBubble, "bubble");
            long mergeTime  = measureSortTime(arrMerge,  "merge");

            
            int x = arrMerge[arrMerge.length / 2];
            long searchTime = measureSearchTime(arrMerge, x);

            System.out.println("Size: " + size);
            System.out.println("  Bubble sort time: " + bubbleTime + " ns");
            System.out.println("  Merge sort time:  " + mergeTime  + " ns");
            System.out.println("  Binary search time: " + searchTime + " ns");
            System.out.println();
        }
    }
}