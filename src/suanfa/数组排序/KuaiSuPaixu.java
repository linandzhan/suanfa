package suanfa.数组排序;

import java.util.Arrays;

/**
 * 快速排序 （以一个数作为中轴，右边比中轴小的放左边，左边比中轴大的放右边）
 *
 * 以此类推，递归中轴两边
 */
public class KuaiSuPaixu {

    public static void kuaipai(int[] arr,int left,int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left+right)/2];   //找到中间数
        int temp = 0;
        while(l < r) {
            //只要出现l>=r就退出循环了
            while(arr[l] < pivot) {
                //只要arr[l]小于pivot左指针就继续往前移动
                l++;
            }

            while(arr[r] > pivot) {
                r--;
            }

            if(arr[l] == pivot) {
                r--;
            }
            if(arr[r] == pivot) {
                l++;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;  //l和r两个数交换
        }
    }


    public static void main(String[] args) {
        int[] arr = {9,7,8,6,4,5,3,2,1,-1,100,20,-2,-23,90};
//        quickSort(arr,0,arr.length-1);
        kuaisuSort(0,arr.length-1,arr);
       System.out.println(Arrays.toString(arr));
    }




    public static void quickSort(int[] arr,int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0; //临时变量，作为交换时使用
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while (l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }


    /**
     * 快速排序回顾。  以一个点为中心，两个指针进行移动，符合就移动靠近中心，不符合就替换。保证左边的比中心小，右边的比中心大。
     * mid中心，left左边起点， right右边终点，确定范围。arr确定要快排的数组
     */
    public static void kuaisuSort(int left,int right,int[] arr) {
       int l = left; //左指针
       int r = right; //右指针
       int mid = (left+right)/2;
       int temp = 0;
       while(l<r) {
           while(arr[l] < arr[mid]) {
               //符合要求
               l++;
           }

           while(arr[r] > arr[mid]) {
               r--;
           }
           if(l>=r) {
               break;
           }
           temp = arr[l];
           arr[l] = arr[r];
           arr[r] = temp;   //进行交换



           if(arr[l] == arr[mid]) {
               l++;  //交换之后和temp相等，就要往前移一位，因为上面的while是进不去的，这样l就一直不会往前移
           }
           if(arr[r] == arr[mid]) {
               r--;  //同理
           }


       }
        if(l==r) {
            l++;
            r--;
        }


       if(left < r) {
           kuaisuSort(left,r,arr);
       }
       if (right > l) {
            kuaisuSort(l,right,arr);
       }
    }
}
