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
        charu(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
