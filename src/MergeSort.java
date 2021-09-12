public class MergeSort {
    public int[] MergeSort(int[] arr,int left,int right){
        if(left < right){
            int center = (left + right) / 2;
            MergeSort(arr,left,center);
            MergeSort(arr,center+1,right);
            merge(arr,left,center,right);
        }
        return arr;
    }

    public int[] merge(int[]arr,int left,int center,int right){
        int i = left ;
        int j = center + 1;
        int[] temp = new int[right - left + 1];

        for(int k = 0 ; k <= temp.length-1 ; k++){
            if(i > center)
            {
                temp[k] = arr[j++];
            }
            else if(j > right)
            {
                temp[k] = arr[i++];
            }
            else if(arr[i] <= arr[j])
            {
                temp[k] = arr[i++];
            }
            else
                temp[k] = arr[j++];
        }

        for(int k = 0 ; k <= temp.length - 1 ; k++){
            arr[left++] = temp[k];
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr = {4,2,6,3,9,8};
        MergeSort ms = new MergeSort();
        ms.MergeSort(arr,0,arr.length - 1);

        for (int t:arr) {
            System.out.println(t);
        }
    }
}
