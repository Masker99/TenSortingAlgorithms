public class SelectionSort {
    public int[] selectionSort(int[] arr){
        int length = arr.length;
        for(int i = 0 ; i < length ; i++){
            int min = arr[i];
            for (int j = i+1 ; j < length ; j++){
                if(min > arr[j]){
                    min = arr[j];
                    swap(arr,i,j);
                }
            }
        }
        return arr;
    }

    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] arr = {4,2,6,3,9,8};
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(arr);

        for (int t:arr) {
            System.out.println(t);
        }
    }
}
