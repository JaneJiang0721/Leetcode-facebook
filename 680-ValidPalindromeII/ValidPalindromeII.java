/*version1 01/08/2018
Could be improved by using only one pointer
*/
    public boolean validPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isValidPalindrome(s, i+1, j) || isValidPalindrome(s, i, j-1);
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean isValidPalindrome(String s, int start, int end) {
        if (start == end) {
            return true;
        }
        int i = start, j = end;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }