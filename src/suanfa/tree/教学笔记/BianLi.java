package suanfa.tree.教学笔记;

/**
 * 树的前序、中序、后序遍历
 */
public class BianLi {
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
        qianXu(root);
    }

    public static void qianXu(TreeNode head) {

        if(head != null) {
            System.out.println(head);
        }

        if(head.left !=null) {
            qianXu(head.left);
        }

        if(head.right!=null) {
            qianXu(head.right);
        }
    }


    public static void zhongXu(TreeNode head) {
        if(head.left !=null) {
            zhongXu(head.left);
        }

        if(head != null) {
            System.out.println(head.val);
        }

        if(head.right!=null) {
            zhongXu(head.right);
        }
    }


    public static void houXu(TreeNode head){
        if(head.left !=null) {
            houXu(head.left);
        }

        if(head.right!=null) {
            houXu(head.right);
        }
        if(head != null) {
            System.out.println(head.val);
        }
    }
}
