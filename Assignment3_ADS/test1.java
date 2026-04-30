public class test1 {
    public static void main(String[] args){
        int[] arr = {5, 2, 8, 1, 9, 3};
        int[] sorted = mergeSort(arr);
        for(int i:sorted){
            System.out.print(i + " ");
        }
    }
    public static int[] mergeSort(int[]arr){
        if(arr.length == 0 || arr.length == 1){
            return arr;
        }
        int[]left = new int[arr.length/2];
        int[]right = new int[arr.length - arr.length/2];
        for(int i = 0; i < left.length; i++){
            left[i] = arr[i];
        }
        for(int i = left.length; i < arr.length; i++){
            right[i - left.length] = arr[i];
        }
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }
    public static int[] merge(int[]left, int[]right){
        int result[] = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resIndex = 0;
        while(leftIndex < left.length && rightIndex < right.length){
            if(left[leftIndex] <= right[rightIndex]){
                result[resIndex] = left[leftIndex];
                ++leftIndex;
                ++resIndex;
            }
            else{
                result[resIndex] = right[rightIndex];
                ++rightIndex;
                ++resIndex;
            }
        }
        while(leftIndex < left.length){
            result[resIndex] = left[leftIndex];
            ++leftIndex;
            ++resIndex;
        }
        while(rightIndex < right.length){
            result[resIndex] = right[rightIndex];
            ++rightIndex;
            ++resIndex;
        }
        return result;
    }
}