package tree;

public class Problem4 {

    //Link - https://leetcode.com/problems/binary-tree-maximum-path-sum/



    public int maxPathSum(TreeNode root) {
        int[] rootNode = maxPathSumRec(root);
        return rootNode[1];
    }

    private int[] maxPathSumRec(TreeNode root) {
        if (root == null){
            int[] pair = new int[2];
            pair[1] = Integer.MIN_VALUE;

            return pair;
        }

        int[] left = maxPathSumRec(root.left);
        int[] right = maxPathSumRec(root.right);

        int[] pair = new int[2];
        pair[0] = Math.max(0,root.val + Math.max(left[0], right[0]));
        pair[1] = Math.max(Math.max(left[1], right[1]),root.val + left[0] + right[0]);

        return pair;



    }
}
