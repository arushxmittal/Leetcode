class Solution {
    public String minRemoveToMakeValid(String s) {
        boolean[] invalid = new boolean[s.length()];
        int openCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                if (openCount > 0) {
                    openCount--;
                } else {
                    invalid[i] = true;
                }
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(' && openCount > 0) {
                invalid[i] = true;
                openCount--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!invalid[i]) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}