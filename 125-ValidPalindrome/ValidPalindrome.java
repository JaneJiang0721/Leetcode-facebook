/*version1 01/07/2018

    The problem is when a char can be letter or digit or comma, etc. You have to consider this case.
    Then come to a conclusion that the condition to check whether the loop is stopped is because of normal palindrome comparison or invalid loop through chars is that: the index is out of range. 
    */
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        char[] sArray = s.toLowerCase().toCharArray();
        int i = 0, j = sArray.length - 1;
        while (i < sArray.length && j >=0 && i < j) {
            while (i < sArray.length && !Character.isLetterOrDigit(sArray[i])) {
                i++;
            }
            while (j >= 0 && !Character.isLetterOrDigit(sArray[j])) {
                j--;
            }
            if (i < sArray.length && j >=0 && sArray[i] != sArray[j]) {
                 return false;
            }
            else {
                i++;
                j--;
            }
        }
        // if (i >= sArray.length || j < 0) {
        //     return false;
        // }
        return true;
    }