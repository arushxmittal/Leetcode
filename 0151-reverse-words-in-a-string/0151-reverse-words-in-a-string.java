class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // Skip spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) break;

            // Mark end of word
            int end = i;

            // Find start of word
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Add single space between words
            if (sb.length() > 0) {
                sb.append(" ");
            }

            // Append substring s[i+1 ... end]
            sb.append(s.substring(i + 1, end + 1));
        }

        return sb.toString();
    }
}