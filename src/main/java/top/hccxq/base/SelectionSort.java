package top.hccxq.base;

import java.util.Arrays;
import java.util.Random;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        //测试次数
        int testCount = 5_0000;
        int maxSize = 10;
        int maxValue = 200;
        boolean succeed = true;
        //测试500w次校验算法是否有误
        for (int i = 0;i<testCount;i++){
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = arrayCopy(arr1);
            selectSort(arr1);
            System.out.println(Arrays.toString(arr1));
            Arrays.sort(arr2);
            System.out.println(Arrays.toString(arr2));
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }


        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

    }

    /**
     * 排序算法
     * @param arr
     */
    public static void selectSort(int[] arr){
        if (arr == null || arr.length <= 1) return;

        for (int i = 0; i < arr.length;i++){
            //最小数的下标
            int minIndex = i;
            //查询比较获取最小数的下标
            for (int j = i+1; j < arr.length;j++){
                minIndex = arr[minIndex] < arr[j] ? minIndex :j;
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 交换数组元素
     * @param arr 数组
     * @param i 数组下标
     * @param j 数组下标
     */
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 打印数组
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 对数器
     * @param arr
     */
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    /**
     * 数组拷贝
     */
    public static int[] arrayCopy(int[] arr){
        return Arrays.copyOf(arr,arr.length);
    }

    /**
     * 随机生成数组
     * @param maxSize 数组最大长度
     * @param maxValue 数组元素最大值
     * @return
     */
    public static int[] generateRandomArray(int maxSize,int maxValue){
        int arrLength = 0;
        while (arrLength <= 2){
            arrLength = (int) ((maxSize + 1)*Math.random());
        }
        int[] arr = new int[arrLength];
        for (int i = 0;i < arr.length;i++){
            arr[i] = (int)((maxValue +1) * Math.random());
        }
        return arr;
    }


    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
