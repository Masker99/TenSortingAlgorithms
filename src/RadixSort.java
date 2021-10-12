import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 基数排序
 * 时间复杂度：O（kn），空间复杂度：O（k+n）
 * @author Masker
 */
public class RadixSort {
    int[] arr;
    int[] temp;
    ArrayList<LinkedList<Integer>> radixList;
    int max;
    int length;
    int digits;

    RadixSort(int[] arr){
        this.arr = arr;
        this.temp = arr;
        length = arr.length;
        radixList = new ArrayList<>(10);

//        for(LinkedList element : radixList){
//            element.add(new LinkedList<Integer>());
//        }
        for(int i = 0 ; i < 10 ; i++){
            radixList.add(new LinkedList<Integer>());
        }

        max = arr[0];
        for(int e: arr){
            if(max < e){
                max = e;
            }
        }
    }

    /**
     * 获取最大值的位数
     */
    public void getDigits(){
        max = this.arr[0];
        for(int e: this.arr){
            if(max < e){
                max = e;
            }
        }

        int temp = max;
        while(temp > 0){
            temp /= 10;
            digits++;
        }
    }

    public void putInBucket(){
        for (int i = 0 ; i < digits ; i++){
            for (int j = 0 ; j < length ; j++){
                int num = temp[j];
                //获取对应位数的值
                int digit = (num / (int)(Math.pow(10,i)) % 10);
                radixList.get(digit).add(temp[j]);
            }

            int index = 0;
            //将桶中的数按顺序放入数组中
            for (LinkedList<Integer> linkedList : radixList){
                for (Integer element: linkedList){
                    temp[index] = element;
                    index++;
                }
                linkedList.clear();
            }
        }
    }

    public void printArray(){
        System.out.println(Arrays.toString(temp));
    }
    public void radixSort(){
        getDigits();
        putInBucket();
        printArray();
    }

    public static void main(String[] args) {
        int[] arr = {11,12,22,51,33,13,21,55,88,18};
        new RadixSort(arr).radixSort();
    }
}
