package 数组Letcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组的分查找法实现。    返回命中数字的下标集合。
 * 用递归方法，进行二分查找
 */
public class ErFenChaZhao {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,7,8,9,10,234,344,344};
        List<Integer> integers = erFenChaZhao(arr, 344, 0, arr.length - 1);
        System.out.println(integers);
    }



    public static List<Integer> erFenChaZhao(int[] arr,int findVal,int left,int right) {
        if(left > right) {
            return new ArrayList<>();
        }
        int mid = (left+right)/2;  //获得中间下标
        if(arr[mid] < findVal) {
            //在mid的右边，向右递归
           return erFenChaZhao(arr,findVal,mid+1,right);
        }else if(arr[mid] > findVal) {
            //向左递归
          return   erFenChaZhao(arr,findVal,left,mid);
        }else {
            List<Integer> result = new ArrayList<>();
            result.add(mid);
            int l = mid-1;
            int r = mid+1;
                while(l >= 0 && arr[l] == arr[mid]) {
                    result.add(l);
                    l--;
                }
                while (r<arr.length && arr[r] == arr[mid]){
                    result.add(r);
                    r++;
                }


            return result;

        }





    }
}
