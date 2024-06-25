package tree;

import java.util.HashMap;
import java.util.Map;

public class Problem8 {

    //Link - https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> findPosition = new HashMap<>();
        int n = inorder.length;

        for (int i = 0; i < n; i++) {
            findPosition.put(inorder[i], i);
        }

        return buildTree(0,n - 1,0,n - 1,inorder,postorder,findPosition);
    }

    public TreeNode buildTree(int is,int ie,int ps,int pe,int[] inorder,int[] postorder,Map<Integer, Integer> findPosition) {

        if(ie < is || pe < ps) {
            return null;
        }

        int element = postorder[pe];
        int pos = findPosition.get(element);

        TreeNode root = new TreeNode(element);
        root.left=  buildTree(is,pos - 1,ps,ps + pos - is - 1,inorder,postorder,findPosition);
        root.right = buildTree(pos + 1,ie,ps + pos -is,pe - 1,inorder,postorder,findPosition);

        return root;
    }
}
