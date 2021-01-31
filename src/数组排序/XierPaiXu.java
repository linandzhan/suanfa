package 数组排序;

/**
 * 希尔排序
 * 插入排序的一种优化。   分组进行插入排序。 一层层除以2。10除2，分5组， 5除2分2组，2除1分1组进行插入排序
 */
public class XierPaiXu {

    public static void xier(int[] arr) {
        int temp = 0;
        for (int gap = arr.length/2; gap >0 ; gap/=2) {
            //gap就是分多少组。
            for (int i = gap; i < arr.length ; i++) {
                for (int j = i-gap; j >=0 ; j-=gap) {
                    //步长
                    if(arr[j] > arr[j+gap]) {
                        temp = arr[j+gap];
                        arr[j+gap] = arr[j];
                        arr[j] = temp;   //交换
                    }
                }
            }
        }
    }

    public static void xierYiDong(int[] arr) {
        int temp = 0;
        int inertIndex = 0;
        for (int gap = arr.length/2; gap >0 ; gap/=2) {
            //gap就是分多少组。
            for (int i = gap; i < arr.length ; i++) {
//                temp = arr[i];
//                inertIndex = i;
//                for (int j = i-gap; j >=0 ; j-=gap) {
//                    //步长
//                    if(arr[j] > arr[j+gap]) {
//                        arr[j+gap] = arr[j];  //往后移动
//                        inertIndex = j;
//                    }
//                }
//                arr[inertIndex] = temp;

                int j = i;
                temp = arr[j];
//                if(arr[j] < arr[j-gap]) {
                    while(j-gap >= 0 && temp<arr[j-gap]) {
                        arr[j] = arr[j-gap];
                        j-=gap;
                    }
                    arr[j] = temp;
//                }

            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {2,5,8,1,3,4,2,9,7,1};
        xierYiDong(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
