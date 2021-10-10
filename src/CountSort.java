import java.util.Arrays;

/**
 * 计数排序
 * 假设原始数组的大小为N，最大最小差值为M
 * 时间复杂度：O（N+M），空间复杂度：O（N）
 * 注意：
 * 1、计数排序适合数列元素是整数的情况
 * 2、当数列元素的最大值最小值的差值过大时，不适合计数排序，会增加空间复杂度、时间复杂度
 * @author Masker
 */
public class CountSort {
    int[] arr;
    int[] countArray;
    int[] sortedArray;
    int min;
    int max;

    CountSort(int[] arr){
        this.arr = arr;
        this.countArray = new int[arr.length];
        this.sortedArray = new int[arr.length];
    }

    public void createCountArray(){
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

        this.countArray= new int[max - min + 1];

        for(int i = 0 ; i < arr.length ; i++){
            //统计元素的个数
            this.countArray[arr[i]-min]++;
        }
    }

    /**
     * 对countArray进行改造，适用于稳定排序
     * 元素值表示的是前面的元素值+自己的值
     */
    public void changeCountArray(){
        int count = 0;
        for (int i = 0 ; i < this.countArray.length ; i++){
            count += this.countArray[i];
            this.countArray[i] = count;
        }
    }

    public void createSortedArray(){
        for (int i = arr.length - 1 ; i >= 0 ; i--){
            //获取元素在countArray的下标值
            int index = this.arr[i] - min;
            //获取元素对应的排位
            int site = this.countArray[index];
            //未排序元素少一个
            this.countArray[index]--;
            //将元素放到sortedArray对应位置
            this.sortedArray[site - 1] = this.arr[i];
        }
    }

    public void countSort(){
        createCountArray();
        changeCountArray();
        createSortedArray();
    }

    public static void main(String[] args) {
        int[] arr = {90,99,95,94,95};
        CountSort countSort = new CountSort(arr);
        countSort.countSort();
        System.out.println(Arrays.toString(countSort.sortedArray));
    }
}
