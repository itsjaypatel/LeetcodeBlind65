package tree;

public class Problem4 {

    //Link - https://leetcode.com/problems/binary-tree-maximum-path-sum/


    static record Node<X,Y,Z,W,V>(X x, Y y, Z z, W w,V v){}
    public int maxPathSum(TreeNode root) {
        int[] rootNode = maxPathSumRec(root);

        return rootNode[4];
    }

    private int[] maxPathSumRec(TreeNode root) {
        if (root == null){
            return new int[5];
        }

        int[] leftNode = maxPathSumRec(root.left);
        int[] rightNode = maxPathSumRec(root.right);

        int leftNodeMaxSum = leftNode[4];
        int rightNodeMaxSum = rightNode[4];

        int[] myNode =
                new int[5];
        myNode[0] = root.val + leftNodeMaxSum;
        myNode[1] = root.val + rightNodeMaxSum;
        myNode[2] = Math.max(leftNodeMaxSum, rightNodeMaxSum);
        myNode[3] = root.val;
        myNode[4] = Math.max(Math.max(Math.max(myNode[0],myNode[1]),Math.max(myNode[2],myNode[3])),Math.max(leftNodeMaxSum,rightNodeMaxSum));
        return myNode;
    }
}
