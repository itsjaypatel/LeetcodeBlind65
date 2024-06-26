package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Problem7 {

    public boolean isPalindrome(int x) {
        //return isPalindrome(String.valueOf(x));
        if(x<0) return false;
        if(x < 10)  return true;

        List<Integer> digits = new ArrayList<>();
        while(x > 0){
            int digit = x % 10;
            digits.add(digit);
            x /= 10;
        }
        return isPalindrome(digits);
    }
    private boolean isPalindrome(List<Integer> digits) {
        int left = 0, n = digits.size();
        while(left < n/2){
            if(!Objects.equals(digits.get(left), digits.get(n - left - 1))){
                return false;
            }
            ++left;
        }
        return true;
    }
}
