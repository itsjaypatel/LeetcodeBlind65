package binary;

public class Problem2 {

    //Link - https://leetcode.com/problems/number-of-1-bits/description/
    public static void main(String[] args) {
        int ans = new Problem2().hammingWeight(11);
        System.out.println(ans);
    }
    public int hammingWeight(int n) {
        int count = 0;
        while(n > 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
