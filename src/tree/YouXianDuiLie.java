package tree;

/**
 * 实现优先队列
 * 优先队列规律：（遵循当前节点比左右子节点小）
 * 1、插入元素时，进行上浮操作，移动到合适的位置
 * 2、删除元素时，进行下沉操作。
 */
public class YouXianDuiLie {
    private Object[] arr;  //用数组实现
    private int size;   //实际插入了多少个元素

    public YouXianDuiLie(int arrSize) {
        arr = new Object[arrSize];
        this.size = 0;   //初始化，插入的元素为0个
    }


    public int add(Object obj) {
        if(size == 0) {
            arr[0] = obj;
            size++;
            return size;
        }else {
            int index = up(size, obj);
            size++;
            return index;
        }
    }


    public int up(int k,Object obj){
        while(k>0) {
            //当k=0时，就是不需要再进行下沉操作了，直接赋值就好了

            int parentIndex = (k-1)/2;
            if((int)arr[parentIndex] >= (int)obj){
                break;
            }
            arr[k] = arr[parentIndex];
            k = parentIndex;  //父元素占领了子元素这个坑位，k值要往上移动
        }
        arr[k] = obj;
        return k;
    }



    public int remove(Object obj) {
        return 0;
    }






}
