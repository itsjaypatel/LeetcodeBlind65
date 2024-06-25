package tree;

public class Problem1 {


    //link - https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){}

    TreeNode(int x){
        this.val = x;
        this.left = null;
        this.right = null;
    }

    TreeNode(int x,TreeNode left,TreeNode right){
        this.val = x;
        this.left = left;
        this.right = right;
    }
}
