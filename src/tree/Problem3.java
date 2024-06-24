package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Problem3 {

    //Link - https://leetcode.com/problems/invert-binary-tree/
    public TreeNode invertTree(TreeNode root) {

        /*
        TC - O(N)
        SC - O(N)
            if(root == null){
                return null;
            }

            TreeNode leftPart = invertTree(root.left);
            TreeNode rightPart = invertTree(root.right);

            root.left = rightPart;
            root.right = leftPart;

            return root;
         */

        //Approach - Level Order Traversal
        //TC - O(N)
        //SC - O(N)

        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();

                TreeNode temp1 = node.left;
                TreeNode temp2 = node.right;

                node.left = temp2;
                if (temp2 != null){
                    queue.add(temp2);
                }
                node.right = temp1;
                if (temp1 != null){
                    queue.add(temp1);
                }
            }
        }
        return root;
    }
}
