package strings;

import java.util.ArrayList;
import java.util.List;

public class Problem9 {

    static class Codec {

        // Encodes a list of strings to a single string.
        //  plain - [abc,def,ghi]
        //  encoded - 3/abc3/def3/ghi

        public String encode(List<String> strs) {
            StringBuilder ans = new StringBuilder();
            for (String s : strs) {
                ans.append(s.length()).append("/").append(s);
            }
            return ans.toString();
        }


        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> ans = new ArrayList<>();
            int i = 0, n = s.length();
            while (i < n) {
                int slash = s.indexOf('/', i);
                int size = Integer.parseInt(s.substring(i, slash));
                ans.add(s.substring(slash + 1, slash + size + 1));
                i = slash + size + 1;
            }
            return ans;
        }
    }

}
