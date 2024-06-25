package tree;

import java.util.Stack;

public class Problem9 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root.left,Integer.MIN_VALUE,root.val)
                && isValidBST(root.right,root.val,Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null) return true;
        if(root.val < min || root.val > max) return false;

        return isValidBST(root.left,min,root.val)
                && isValidBST(root.right,root.val,max);
    }

    public boolean isValidIterative(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        long preValue = Long.MIN_VALUE;
        while(cur!=null ||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(preValue >= cur.val){
                return false;
            }
            preValue = cur.val;
            cur = cur.right;
        }

        return true;
    }

    public boolean isValidIterativeWithMorisTravarsal(TreeNode root){

        TreeNode cur = root;
        long preValue = Long.MIN_VALUE;
        while(cur!=null){
            if(cur.left == null){
                if(preValue >= cur.val){
                    return false;
                }
                preValue = cur.val;
                cur = cur.right;
            }else{
                TreeNode predessor  = findPredecessor(cur);
                if(predessor.right == null){
                    //make thread link
                    predessor.right = cur;
                    cur = cur.left;
                }else {
                    predessor.right = null;
                    if(preValue >= cur.val){
                        return false;
                    }
                    preValue = cur.val;
                    cur = cur.right;
                }
            }
        }

        return true;
    }

    public TreeNode findPredecessor(TreeNode root){
        TreeNode predessor = root.left;
        while(predessor != null && predessor.right != null && predessor.right != root){
            predessor = predessor.right;
        }
        return predessor;
    }
}
