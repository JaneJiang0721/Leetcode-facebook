
//Date: 12/31/2017
//https://leetcode.com/problems/add-binary/description/
//Given two binary strings, return their sum (also a binary string).

//For example,
//a = "11"
//b = "1"
//Return "100".

    public String addBinary(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        int i = aChar.length -1 , j = bChar.length - 1, carry = 0, sum = 0;
        StringBuilder s = new StringBuilder();
        while (i >= 0 || j >= 0) {
            sum = carry;
            if (i >= 0) {
                sum += aChar[i--] - '0';
            }
            if (j >= 0) {
                sum += bChar[j--] - '0';
            }
            s.append(sum%2);
            carry = sum / 2;
        }
        if (carry != 0) {
            s.append(carry);
        }
        return s.reverse().toString();


