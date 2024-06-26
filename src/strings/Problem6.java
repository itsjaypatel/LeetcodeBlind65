package strings;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Problem6 {

    public boolean isValid(String expression) {
        //Approch - Stack
        //TC - O(N)
        //SC - O(N)

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of(')','(','}','{',']','[');
        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty() || map.get(c) != stack.peek()) {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
}
