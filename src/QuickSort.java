import java.util.Arrays;

/**
 * 快速排序
 * @author Masker
 */
public class QuickSort {
    /**
     * 单向调整
     * 缺点：有些元素会比较多次
     * @param arr
     * @param left
     * @param right
     * @return 返回主元的小标，便于接着的递归分区
     */
    public int partition(int[] arr,int left,int right){
        int temp;
        int pivot = arr[right];
        int i = left;
        int j = left;

        for(; j < right ; j++){
            if(arr[j] < pivot){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }

        arr[right] = arr[i];
        arr[i] = pivot;

        return i;
    }

    /**
     * 双向调整
     * 优点：弥补单向调整的缺点
     * @param arr
     * @param left
     * @param right
     * @return 返回主元下标
     */
    public int partition2(int[] arr,int left ,int right){
        int pivot = arr[left];
        int i = left + 1;
        int j = right;

        while(true){
            while(i <= j && arr[i] <= pivot){
                i++;
            }

            while(j >= i && arr[j] >= pivot){
                j--;
            }

            if (i >= j){
                break;
            }

            int temp;
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        arr[left] = arr[j];
        arr[j] =pivot;

        return j;
    }

    public void quickSort1(int[] arr, int left, int right){
         int center;
         if(left < right){
             center = partition(arr,left,right);
             quickSort1(arr,left,center-1);
             quickSort1(arr,center+1,right);
         }
    }

    public void quickSort2(int[] arr,int left ,int right){
        int center;
        if (left < right){
            center = partition2(arr,left,right);
            quickSort2(arr,left,center-1);
            quickSort2(arr,center+2,right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,1,3,2,7,6,4};
        QuickSort quickSort = new QuickSort();
//        quickSort.quickSort1(arr,0,arr.length-1);
        quickSort.quickSort2(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
