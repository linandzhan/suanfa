package tree.教学笔记;

/**
 * 删除二叉树的节点：
 * 1、删除的是叶子节点则直接删除
 * 2、删除的是非叶子节点则删除该子树
 *
 * 思路：
 * 1、判断当前节点的左子节点和右子节点是否是需要删除的节点
 */
public class ShanChuJieDian {
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

        int value = 21;
        if(root != null) {
            if(root.val == value) {
                root = null;
            }else {
                delNode(root,value);
            }
        }else {
            System.out.println("该树为空树，无法进行删除操作");
        }


        BianLi.qianXu(root);
    }

    /**
     * 最关键的就是，判断当前节点的左右子节点是否需要删除，是，则将左子节点置为空
     * @param head
     * @param val
     */
    public static void delNode(TreeNode head,int val) {
        if(head.left !=null && head.left.val==val) {
            head.left = null;  //命中，置为空
            return;
        }

        if(head.right!=null && head.right.val == val) {
            head.right = null;
            return;
        }

        if(head.left!=null) {
            delNode(head.left,val);
        }

        if(head.right!=null) {
            delNode(head.right,val);
            return;
        }
    }
}
