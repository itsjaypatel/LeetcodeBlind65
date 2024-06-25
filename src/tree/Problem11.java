package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem11 {

    //Link - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        /*
            TC - O(H)
            SC - O(1)
            if(p.val > q.val){
                return lowestCommonAncestor(root,q,p);
            }
            if (root == null || root == p || root== q || (p.val < root.val && root.val < q.val)) return root;

            if(p.val > root.val && q.val > root.val){
                return lowestCommonAncestor(root.right, p, q);
            }
            return lowestCommonAncestor(root.left, p, q);
        */



        //TC - O(N + H)
        //SC - O(N)

        Map<TreeNode, TreeNode> parentLink = new HashMap<>();
        parentLink.put(root, null);
        populateParent(root,parentLink);
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2  = new ArrayList<>();
        while (p != null) {
            path1.add(0,p);
            p = parentLink.get(p);
        }
        while (q != null) {
            path2.add(0,q);
            q = parentLink.get(q);
        }

        int i = 0, s1 = path1.size(), s2 = path2.size();
        while( i < s1 && i < s2 && path1.get(i) == path2.get(i)){
            i++;
        }
        return path1.get(i - 1);
    }


    public void populateParent(TreeNode root, Map<TreeNode,TreeNode> parentLink){
        if(root == null) return;

        if(root.left != null){
            parentLink.put(root.left, root);
            populateParent(root.left, parentLink);
        }
        if(root.right != null){
            parentLink.put(root.right, root);
            populateParent(root.right, parentLink);
        }
    }
}
