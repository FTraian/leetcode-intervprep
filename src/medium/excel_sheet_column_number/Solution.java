/**
 * Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 */
class Solution {
    public int titleToNumber(String columnTitle) {
            int result = 0;
            for(int i = columnTitle.length() - 1; i >= 0; i--) {
                char c = columnTitle.charAt(i);
                result += (c - 'A' + 1) * Math.pow(26, columnTitle.length() - 1 - i);
            }
    
            return result;
        }
    }