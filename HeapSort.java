package tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: DataStructure
 * @description: 堆排序
 * @author: Mr.Sun
 * @create: 2021-06-12 18:54
 **/
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9,56,-1,67,43};
        for (int i = arr.length/2-1; i >=0; i--) {
            adjust(arr,i,arr.length);
        }
        for (int j =arr.length-1;j>=0;j--){
            int temp = arr[j];//堆底的元素，与堆顶的元素进行交换
            arr[j] = arr[0];
            arr[0] = temp;
            adjust(arr,0,j);
        }

        System.out.println(Arrays.toString(arr));


    }



//1.局部调整一个节点的左右子节点，使其成为一个大顶堆
    /**
     * @Description: adjust
     * @Param: [arr待重构数组, i当前非叶子节点在数组中的索引, length要调整的数组的长度]
     * @return: void
     * @Author: Mr.Sun
     * @Date: 2021/6/12 20:38
     */
    public static void adjust(int[] arr , int i , int length){
       int k ;
       int temp = arr[i];
       for (k=2*i+1;k<length;k=2*k+1){
           if (k+1<length && arr[k]<arr[k+1]){
               k++;
           }
           if (arr[k]>temp){
               arr[i]=arr[k];
               i=k;
           }else{          //如果左右子节点的数值都小于父节点的数值，就跳出
               break;
           }
       }
        arr[i] = temp;
    }



    public static int[] getLeastMumbers(int[] arr,int k){


        Queue<Integer> queue = new PriorityQueue<>(k,(i1,i2)->Integer.compare(i2,i1));
        if (k > arr.length-1){
            System.out.println(Arrays.toString(arr));
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {

            if (queue.size()<k || queue.isEmpty() || queue.peek()>arr[i]){
                queue.offer(arr[i]);
            }
            if (queue.size()>k ){
                queue.poll();
            }
        }
         int[] res = new int[queue.size()];
        for (int i = 0;i<res.length;i++){
            res[i] = queue.poll();
        }
        System.out.println(Arrays.toString(res));
        return res;

    }

    @Test
    public void test(){
        int[] arr = {4,6,8,5,9,56,-1,67,43};
        int k = 8;
        getLeastMumbers(arr,k);

    }


}
