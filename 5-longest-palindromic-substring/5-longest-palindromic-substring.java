public class Solution {
private int lo, maxLen;

public String longestPalindrome(String s) {
	int len = s.length();
	
	
    for (int i = 0; i < len; i++) {
     	Palindrome(s, i, i); 
     	Palindrome(s, i, i+1); 
    }
    return s.substring(lo, lo + maxLen);
}

private void Palindrome(String s, int j, int k) {
	while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
		j--;
		k++;
	}
	if (maxLen < k - j - 1) {
		lo = j + 1;
		maxLen = k - j - 1;
	}
}}