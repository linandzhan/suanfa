package suanfa.tree.教学笔记;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 哈夫曼树的创建：哈夫曼树权值wpl最小
 */
public class HuffManTree {

    public static void main(String[] args) {
        int[] arr = {2,4,6,3,2,1,5,9};
        TreeNode root = goujian(arr);
        qianXu(root);
    }

    /**
     * 排序数组
     * 将数组的前两个最小的数组成树，以此类推
     * @param arr
     * @return
     */
    public static TreeNode goujian(int[] arr) {
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nodes.add(new TreeNode(arr[i]));
        }
        while(nodes.size() > 1) {
            Collections.sort(nodes);
            TreeNode parent = new TreeNode(nodes.get(0).val + nodes.get(1).val);
            parent.left = nodes.get(0);
            parent.right = nodes.get(1);
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(parent);
        }
        return nodes.get(0);
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
}
