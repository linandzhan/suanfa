package 数组排序;

/**
 * 插入排序（将数组分为两组，一组为有序，一组为无序。无序的数组一个个插入到有序的数组中来
 */
public class ChaRuPaiXu {
    public static void charu(int[] arr) {
        //将第一个元素视为有序数组，从第二个元素开始往有序数组插入
        for (int i = 0; i < arr.length-1; i++) {
            int insertValue = arr[i+1];
            int insertIndex = i;
            while(insertIndex>=0 && insertValue < arr[insertIndex]) {
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertValue;
        }
    }

    public static void main(String[] args) {
        int[] arr = {7,6,8,5,9,3,2,6};
        charu2(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }











        public static void charu2(int[] arr) {
            for (int i = 0; i < arr.length-1; i++) {
                int insertVal = arr[i+1];   //待插入值
                int insertIndex = i;   //待插入的位置
                while(insertIndex>=0 && insertVal < arr[insertIndex]) {
                    //只要待插入值小的话，就给insertIndex+1赋值
                    arr[insertIndex+1] = arr[insertIndex];
                    insertIndex--;  //继续往前插入
                }
                insertIndex++;
                arr[insertIndex] = insertVal;


            }
        }















}
