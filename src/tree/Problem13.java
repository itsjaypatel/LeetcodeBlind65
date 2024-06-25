package tree;

public class Problem13 {

    //Link - https://www.naukri.com/code360/problems/implement-trie_1387095?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos

    static class Node{
        Node[] children;
        int occurence = 0;
        int visitors = 0;

        Node(){
            this.children = new Node[26];
            this.occurence = 0;
            this.visitors = 0;
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
                cur.visitors++;
            }
           ++cur.occurence;
        }

        public int countWordsEqualTo(String word) {

            Node cur = root;
            for (char ch : word.toCharArray()) {
                int key = ch - 'a';
                if (cur.children[key] == null) {
                    return 0;
                }
                cur = cur.children[key];
            }
            return cur.occurence;
        }

        public int countWordsStartingWith(String prefix) {

            Node cur = root;
            for (char ch : prefix.toCharArray()) {
                int key = ch - 'a';
                if (cur.children[key] == null) {
                    return 0;
                }
                cur = cur.children[key];
            }
            return cur.visitors;
        }

        public void erase(String word) {

            Node cur = root;
            for (char ch : word.toCharArray()) {
                int key = ch - 'a';
                cur = cur.children[key];
                --cur.visitors;
            }
            --cur.occurence;
        }
    }
}
