package easy.is_palindrome;

public class Solution {
    
    public boolean isPalindrome1(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        
        return true;
    }
    
                
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) return false;
        }
        
        return true;
    }

}
