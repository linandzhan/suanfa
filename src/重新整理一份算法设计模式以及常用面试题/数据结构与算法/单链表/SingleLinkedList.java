package 重新整理一份算法设计模式以及常用面试题.数据结构与算法.单链表;


/**
 * 模拟一个单链表，
 * 1、首先要有Node节点
 * 2、编写插入节点，遍历链表方法
 */
public class SingleLinkedList {
    private Node head;  //头节点
    private Node temp;  //临时节点。  临时节点就是用来帮住遍历的，因为头节点的next不能改变

    public SingleLinkedList(Node head) {
        this.head = head;
    }

    public  void addNode(Node node) {
        temp = head;   //在每次添加时，都确定这个临时指针是从头指针开始指向
        //插入节点方法
        while(true) {
            if(temp.next == null) {
                break;
            }
            temp = temp.next; //这就是临时节点的威力
        }
        temp.next = node;    //现在模拟的这个方法，是每次添加一个Node节点都是添加在该链表的尾部
    }

    //遍历链表
    public void bianli() {
        temp = head;
        while(true) {
            if(temp.next == null) {
                //临时节点的下一个节点为Null则说明到达尾部
                System.out.println(temp);
                break;
            }
            System.out.println(temp);
            temp = temp.next;  //将temp后移
        }
    }


    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList(new Node(0));
        Node node  = new Node(1);
        singleLinkedList.addNode(node);
        singleLinkedList.addNode(new Node(3));
        singleLinkedList.addNode(new Node(4));
        singleLinkedList.addNode(new Node(-1));
        singleLinkedList.bianli();
    }
}

class Node {
     int no;   //节点编号
     Node next;

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}
