package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class Problem6 {

    //Link - https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Problem6 obj = new Problem6();
        String serialize = obj.serialize(root);
        TreeNode deserialize = obj.deserialize(serialize);

        System.out.println(serialize);
        System.out.println(deserialize);
    }
    public String serialize(TreeNode root) {

        if (root == null) return "";
        StringJoiner sj = new StringJoiner(",");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur == null){
                sj.add("N");
                continue;
            }
            sj.add(cur.val+"");
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return sj.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] split = data.split(",");

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.offer(root);
        for (int i = 1; i < split.length; i+=2) {
            TreeNode parent = queue.poll();

            if(!split[i].equals("N")){
                TreeNode left = new TreeNode(Integer.parseInt(split[i]));
                parent.left = left;
                queue.offer(left);
            }

            if(!split[i + 1].equals("N")){
                TreeNode right = new TreeNode(Integer.parseInt(split[i + 1]));
                parent.right = right;
                queue.offer(right);
            }
        }

        return root;
    }
}
