public class InsertionSort {
    public int[] InsertionSort(int[] arr){
        int length = arr.length;
        for(int i = 1 ; i < length ; i++){
            int temp = arr[i];
            int j = i - 1;
            for( ; j >= 0 && temp < arr[j] ; j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr = {4,2,6,3,9,8};
        InsertionSort is = new InsertionSort();
        is.InsertionSort(arr);

        for (int t:arr) {
            System.out.println(t);
        }
    }
}
