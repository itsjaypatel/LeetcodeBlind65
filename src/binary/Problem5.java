package binary;

public class Problem5 {

    //Link - https://leetcode.com/problems/missing-number/description/
    public static void main(String[] args) {
        int ans = new Problem5().reverseBits(11);
        System.out.println(ans);
    }

    public int reverseBits(int n) {

        //Approch - Using xor (Intuition - xor of same elements are zero)
        //TC - O(n)
        //SC - O(1)

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 32; i++) {
            sb.append(n & (1 << i));
        }

        return Integer.parseInt(sb.toString(),2);
    }
}
