package tree;

public class Problem7 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return subRoot == null;
        }
        boolean subTreeFromRoot = isSame(root,subRoot);
        if(subTreeFromRoot){
            return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public boolean isSame(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return isSame(root1.left,root2.left) && isSame(root1.right,root2.right);
    }
}
