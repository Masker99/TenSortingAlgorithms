import java.util.Arrays;

/**
 * @author Masker
 */
public class HeapSort {
    /**
     * 下沉操作
     * 应用场景：
     * 1、当给定一个无序数组时，需要通过下沉操作来构建堆
     * 2、当删除根节点时，最后一个节点需要放到根节点位置，然后进行下沉操作重新构建堆
     * @param arr
     * @param parent
     * @param length
     */
    public void downAdjust(int[] arr,int parent,int length){
        int temp = arr[parent];
        //左孩子节点
        int child = 2*parent+1;

        while(child < length){
            //孩子节点中，选取值较小的孩子节点的下标
            if(child + 1 < length && arr[child] > arr[child+1]){
                child++;
            }

            //父节点的值若都比孩子节点的值小，便终止下沉
            if (temp < arr[child]){
                break;
            }

            arr[parent] = arr[child];
            parent = child;
            child = 2 * parent +1 ;
        }

        arr[parent] = temp;
    }

    /**
     * 上浮操作
     * 使用场景：
     * 1、当插入节点后，需要进行上浮操作进行重新构建堆
     * @param arr
     * @param length
     */
    public void upAdjust(int[] arr,int length){
        //插入节点的位置
        int child = length - 1;
        //插入节点的父节点
        int parent = (child - 1)/2;
        int temp = arr[child];

//        while(child > 0 ){
//            if(arr[child] < arr[parent] ){
//                arr[child] = arr[parent];
//            }
//
//            child = parent;
//            parent = (child - 1)/2;
//        }

        while (child > 0 && temp < arr[parent]){
            arr[child] = arr[parent];

            child = parent;
            parent = (child - 1)/2;
        }

        arr[parent] = temp;
    }

    public void buildMinHeap(int[] arr){
        int length = arr.length;
        //构建堆时，需要从最后一个非叶子节点开始下沉
        for(int i = (length - 1 - 1 )/ 2 ; i > 0 ; i--){
            downAdjust(arr,i,length);
        }
    }

    public void heapSort(int[] arr){
        buildMinHeap(arr);

        int length = arr.length;
        for(int i = length - 1 ; i >= 1 ; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            downAdjust(arr,0,i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,7,8,4,6,3,2,9};
//        int[] arr = {1,2,3,4,5,6,7,8,9,0};

        HeapSort heapSort = new HeapSort();
//        heapSort.buildMinHeap(arr);
//        heapSort.upAdjust(arr,arr.length);
        heapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
