public class ShellSort {
    public int[] ShellSort(int[] arr){
        int length = arr.length;
        for(int gap = length / 2 ; gap > 0 ; gap /=2){
            for(int begin = gap ; begin < length ; begin++)
            InsertionSort(arr,gap,begin);
        }
        return arr;
    }

    public void InsertionSort(int[] arr,int gap,int begin){
        int temp = arr[begin];
        int i = begin - gap;
        for(; i >= 0 && arr[i] > temp ; i -= gap){
            arr[i+gap] = arr[i];
        }
        arr[i+gap] = temp;
    }

    public static void main(String[] args){
        int[] arr = {4,2,6,3,9,8};
        ShellSort ss = new ShellSort();
        ss.ShellSort(arr);

        for (int t:arr) {
            System.out.println(t);
        }
    }
}
