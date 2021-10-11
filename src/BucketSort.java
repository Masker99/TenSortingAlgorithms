import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序
 * 适合：
 * 1、当数列的最大值和最小值的差值过大时
 * 2、当数列元素的值不为整数时
 * 时间复杂度：，空间复杂度：
 * @author Masker
 */
public class BucketSort {
    double max ;
    double min ;
    double[] arr;
    ArrayList<LinkedList<Double>> bucketList;

    BucketSort(double[] arr){
        this.arr = arr;
    }

    /**
     * 初始化bucketList中
     */
    public void initBucketList(){
        max = arr[0];
        min = arr[0];

        for(int i = 0 ; i < arr.length ; i++){
            if(max < arr[i]){
                max = arr[i];
            }

            if(min > arr[i]){
                min = arr[i];
            }
        }

        bucketList = new ArrayList<>(arr.length);
        for(int i = 0 ; i < arr.length ; i++){
            bucketList.add(new LinkedList<>());
        }
    }

    /**
     * 将数列装载进buckList中
     */
    public void putInBucketList(){
        //获取桶可存入数列元素的区间范围
        //this.bucketList.size() - 1  因为最后一个桶只放一个元素
        double interval = (max - min)/(this.bucketList.size() - 1);

        for(double element : arr){
            //获取数列元素放入桶的位置
            int site =(int) ((element - min)/ interval);
            bucketList.get(site).add(element);
        }
    }

    /**
     * 利用Collections.sort()对桶内的元素进行排序
     */
    public void sortedElementOfBucketList(){
        for (int i = 0 ; i < bucketList.size() ; i++){
            Collections.sort(bucketList.get(i));
        }
    }

    public void printBucketList(){
        for(LinkedList<Double> list : bucketList){
            for(double element : list){
                System.out.print( element + " ");
            }
        }
    }

    public void bucketSort(){
        initBucketList();
        putInBucketList();
        sortedElementOfBucketList();
        printBucketList();
    }
    public static void main(String[] args) {
        double[] arr = {4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 10.09};
        BucketSort bucketSort = new BucketSort(arr);
        bucketSort.bucketSort();
    }
}

