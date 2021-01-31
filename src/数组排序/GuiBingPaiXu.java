package 数组排序;

import java.util.Arrays;

/**
 * 先进行分解，分解成左边一半和右边一半，再不断地往里递归分解。分解到无法分解，就进行合并。合并思路：先把小的放进临时数组，放完就将临时数组拷贝进原数组
 */
public class GuiBingPaiXu {
    public static void main(String[] args) {
        int arr[] = {2,9,7,4,6,1,3,19,12,5,8};
        int temp[] = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }



    public static void mergeSort(int[] arr,int left,int right,int[] temp) {
        if(left < right) {
            int mid = (left+right) /2;
            //向左分解
            mergeSort(arr,left,mid,temp);
            //向右分解
            mergeSort(arr,mid+1,right,temp);

            merge(arr,left,mid,right,temp);
        }
    }



    public static void merge(int arr[],int left,int mid,int right,int[] temp) {
        //先做合并操作
        int l = left;
        int r = mid+1;  //(left+right)/2就是mid,mid加1才是第二个数组的开头
        int t = 0; //临时数组的索引

        while(l <= mid && r <= right) {
            if(arr[l] < arr[r]) {
                temp[t] = arr[l];  //谁小谁先放进去
                t++;
                l++;
            }else {
                    temp[t] = arr[r];
                    t++;
                    r++;
            }
        }


        while(l<=mid) {
            //说明右边的数组已经全部都放进临时数组了
            temp[t] = arr[l];
            l++;
            t++;
        }

        while(r<=right){
            //同理
            temp[t] = arr[r];
            r++;
            t++;
        }


        //进行拷贝操作（将临时数组拷贝到原本的数组中）
        t=0;
        int tempLeft = left;
        while(tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }





        //进行拷贝操作



    }
}
