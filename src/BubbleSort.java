public class BubbleSort {
    public int[] BubbleSort(int[] arr){
        int length = arr.length;
        for(int i = 0 ; i < length ; i++){
            for( int j = 0 ; j < length - i - 1 ; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
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
        BubbleSort b = new BubbleSort();
        b.BubbleSort(arr);

        for (int t:arr) {
            System.out.println(t);
        }
    }
}
