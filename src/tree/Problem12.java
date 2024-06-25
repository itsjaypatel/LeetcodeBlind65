package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem12 {

    //Link - https://leetcode.com/problems/implement-trie-prefix-tree/description/


    static class Node{
        Node[] children;
        boolean isLeaf;

        Node(){
            this.children = new Node[26];
            this.isLeaf = false;
        }
    }

    static class Trie {

        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {

            Node cur = root;
            for (char ch : word.toCharArray()) {
                int key = ch - 'a';
                if (cur.children[key] == null) {
                    cur.children[key] = new Node();
                }
                cur = cur.children[key];
            }
            cur.isLeaf = true;

        }

        public boolean search(String word) {

            Node cur = root;
            for (char ch : word.toCharArray()) {
                int key = ch - 'a';
                if (cur.children[key] == null) {
                    return false;
                }
                cur = cur.children[key];
            }
            return cur.isLeaf;
        }

        public boolean startsWith(String prefix) {

            Node cur = root;
            for (char ch : prefix.toCharArray()) {
                int key = ch - 'a';
                if (cur.children[key] == null) {
                    return false;
                }
                cur = cur.children[key];
            }
            return true;
        }
    }
}
