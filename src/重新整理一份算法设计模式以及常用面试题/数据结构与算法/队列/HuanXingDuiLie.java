package 重新整理一份算法设计模式以及常用面试题.数据结构与算法.队列;

/**
 * 模拟环形队列：
 * 1、重复利用数组的空间
 *
 */
public class HuanXingDuiLie {
    private int maxSize;  //数组的长度
    private int front;  //头指针
    private int rear;  //尾指针
    private int[] arr;  //用来存放数据的数组


    //要模拟一个队列，先写出一个构造队列的函数
    public HuanXingDuiLie(int maxSize) {
        this.maxSize = maxSize+1;
        arr = new int[maxSize+1];
        this.front = 0;   //头指针指向队列的第一个元素
        this.rear = 0;   //尾指针这次指向的是最后一个元素的后面一个索引
    }

    //如何添加、如何删除、如何遍历、如何判断是否已满

    public Boolean isFull() {
        //判断队列是否已满：(rear+1)%maxSize == front;
        return (rear+1)%maxSize == front;  //尾指针的下一个位置再移动就碰上头指针了。画一个图即可知道
    }

    public void add(int data) throws Exception {
        if (isFull()) {
            throw new Exception("数组已经满了");
        }
        arr[rear] = data;
     //   this.rear++;  //尾指针指向最后一个元素的下一个索引（再次强调）
        //为什么不能直接rear++。因为一直直线似地加上去，迟早数组越界，我们要做的是环形队列
       this.rear =  (rear+1)%maxSize;   //这个取模。只要rear的大小还没有达到数组的最大长度，取模出来都是rear原本的数，一旦到达MaxSize,取模，则转为0
        //完美体现出环形队列的效果
    }

    public void bianli() {
        int size = (rear-front+maxSize)%maxSize;
        for (int i = front; i < front+size; i++) {
            System.out.println(arr[i%maxSize]);
        }
    }


    public void remove() {
        arr[front] = 0;
        front = (front+1)%maxSize;
    }

    /**
     * 取出头部数据（和remove类似）
     * @return
     */
    public int getFront() {
        int result = arr[front];
        arr[front]=0;
        front = (front+1)%maxSize;
        return result;
    }

    /**
     * 测试通过，环形队列，模拟顺利完成！
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        HuanXingDuiLie huanXingDuiLie = new HuanXingDuiLie(5);
        huanXingDuiLie.add(4);
        huanXingDuiLie.add(3);
        huanXingDuiLie.add(11);
        huanXingDuiLie.add(5);
        huanXingDuiLie.add(9);
        huanXingDuiLie.remove();
        int front = huanXingDuiLie.getFront();
        int front1 = huanXingDuiLie.getFront();
        huanXingDuiLie.add(100);
        huanXingDuiLie.add(101);
        huanXingDuiLie.add(1000);
        huanXingDuiLie.remove();
        huanXingDuiLie.add(12);
        huanXingDuiLie.bianli();
    }




}
