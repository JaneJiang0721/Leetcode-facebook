/*Version 1: 01/08/2018

(1) The key logic: still traverse through the each character in the string. KEY POINT is: 
List all the situations to make the traverse keep going. So you have to list all the situations firstly.
(2) Using flag to keep track of character have been shown before.
When encounter:
(1) num: flag numSeen = true numAfterE = true
(2) dot: flag dotSeen = true      false: dotSeen || !numSeen  || eSeen
(3) e: flag eSeen = true numAfterE = false         false: eSeen || !numSeen
(4) - +:  true: (i != 0 && i-1 == e) || i == 0 -> i != 0 && i-1 != e  


"46.e3" true
'56.' true*/

class Solution {
    public boolean isNumber(String s) {
        // key point was to learn the basic logic idea
        if (s.length() == 0) {
            return false;
        }
        s = s.trim();
        boolean numSe = false, dotSe = false, eSe = false, numAfdot = false, numAfE = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                numSe = true;
                numAfdot = true;
                numAfE = true;
            }
            else if(s.charAt(i) == '.') {
                if (dotSe || eSe) {
                    return false;
                }
                dotSe = true;
                numAfdot = false;
            }
            else if (s.charAt(i) == 'e') {
                if (!numSe || eSe) {
                    return false;
                }
                eSe = true;
                numAfE = false;
            }
            else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return numSe  && numAfE;

        
    }
}