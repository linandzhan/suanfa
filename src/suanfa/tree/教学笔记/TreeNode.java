package suanfa.tree.教学笔记;

import java.util.Comparator;

public class TreeNode implements Comparable {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    @Override
    public int compareTo(Object o1) {
        TreeNode t1 = (TreeNode)o1;

        //升序
        return this.val-t1.val;
    }
}