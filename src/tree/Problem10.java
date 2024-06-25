package tree;

import java.util.Stack;

public class Problem10 {


    public int kthSmallest(TreeNode root, int k) {

        TreeNode cur = root;
        while(cur!=null){
            if(cur.left == null){
                if(--k == 0){
                    return cur.val;
                }
                cur = cur.right;
            }else{
                TreeNode predessor  = findPredecessor(cur);
                if(predessor.right == null){
                    //make thread link
                    predessor.right = cur;
                    cur = cur.left;
                }else {
                    predessor.right = null;
                    if(--k == 0){
                        return cur.val;
                    }
                    cur = cur.right;
                }
            }
        }

        return -1;
    }

    public TreeNode findPredecessor(TreeNode root){
        TreeNode predessor = root.left;
        while(predessor != null && predessor.right != null && predessor.right != root){
            predessor = predessor.right;
        }
        return predessor;
    }
}
