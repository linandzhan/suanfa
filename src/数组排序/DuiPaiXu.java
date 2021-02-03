package 数组排序;

import java.util.Arrays;

/**
 * 如果是要升序，先将数组调整成一个大顶堆--》将首元素和末尾元素进行替换 --》此时最大的已经确定，将length-1个元素继续调整成大顶堆，再以此类推
 */
public class DuiPaiXu {

    public static void main(String[] args) {
        int[] arr = {4,7,84,9,23,2,3,5,1,10,22,30};
        duiPai(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void duiPai(int[] arr) {
        //关键点：确定最后一个非叶子节点，就是 n/2-1
        for (int i = arr.length/2-1; i >= 0; i--) {
            adjustDaDingDui(arr,i,arr.length);
            //第一次大顶堆就完成
        }
        int temp = 0;
        for (int i = arr.length-1; i >= 0 ; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;  //最大的和最末尾的进行交换
            adjustDaDingDui(arr,0,i);   //这个i设计的很完美，刚好可以将最大的数放到最后一个元素位置，又刚好是数字交换后，再次调整大顶堆所需要调整的长度。
        }
    }

    /**
     *
     * @param arr 待排序数组
     * @param i i索引为非叶子节点的树，进行调整成大顶堆
     * @param length  需要调整的个数
     */
    public static  void adjustDaDingDui(int[] arr,int i,int length) {
        for (int j = i*2+1; j < length; j=j*2+1) {
            int temp = arr[i];
            if(j+1 <= length-1 && arr[j] < arr[j+1]) {
                j++;
            }

            if(arr[j] > temp) {
                //孩子大于当前节点
                arr[i] = arr[j];
                i = j;  //将指针指向了孩子位置上
                arr[i] = temp;  //将temp赋值给孩子   以上三行完成交换动作。
            }else {
                //有交换就要继续循环，没有交换就可以直接退出，当前非节点的树已经是大顶堆了
                break;
            }
        }
    }
}
