package suanfa.tree.教学笔记;

/**
 * 前中后序，遍历，查找
 * 找到了，返回当前节点
 */
public class SearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 10;
        TreeNode left = new TreeNode();
        left.val = 20;
        root.left = left;
        TreeNode right = new TreeNode();
        right.val = 30;
        root.right = right;

        TreeNode leftr = new TreeNode();
        leftr.val = 40;
        left.right = leftr;

        TreeNode leftl = new TreeNode(31);
        TreeNode rightl = new TreeNode(22);
        TreeNode leftll = new TreeNode(70);
        left.left = leftl;
        right.left = rightl;
        leftl.left = leftll;
        TreeNode node = qianXuSearch(31,root,0);
        System.out.println(node);
    }

    public static TreeNode qianXuSearch(int val,TreeNode head,int i) {
        if(head.val == val) {
            i++;
            System.out.println("第"+i+"命中");
            return head;
        }else {
            i++;
            System.out.println("第"+i+"次比较未命中");
        }
        TreeNode res = null;
        if(head.left != null) {
            res = qianXuSearch(val,head.left,i);
        }
        if(res != null) {
            return res;
        }
        if(head.right!=null) {
        res =  qianXuSearch(val,head.right,i);
        }
        return res;
    }



}
