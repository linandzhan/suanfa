package 重新整理一份算法设计模式以及常用面试题.数据结构与算法.双向链表;

/**
 * 双向链表
 *
 * 怎么添加、怎么删除
 * 添加：先找到链表的最后一个节点
 * 删除：可以从当前节点进行删除
 */
public class ShuangXiangLinkedList {
    //先定义双向链表的节点，节点包括向下节点 和 向上节点
    private HeroNode head;  //要有一个头节点，为空
    private HeroNode temp;

    public ShuangXiangLinkedList(HeroNode head) {
        this.head = head;
    }

    /**
     * 添加数据
     * @param node
     */
    public void add(HeroNode node) {
        temp = head;
        while(true) {
            if(temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;  //这两句代码，完美展现出双向链表的特点
    }

    /**
     * 删除数据
     * @param no
     */
    public void remove(int no) {
        temp = head;
        boolean flag = false;  //这个标识判断，要删除的那个编号是否在这个链表中，如果存在就删除它！
        while(true) {
            if(temp.next == null) {
                break;
            }
            if(temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            //下面两句，完美展现双向链表
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;
        }
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


}


class HeroNode {
    public int no;
    public String name;
    public HeroNode pre;  //指向前面的指针
    public HeroNode next;  //指向后面的指针


    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
