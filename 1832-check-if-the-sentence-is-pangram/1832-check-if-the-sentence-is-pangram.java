class Solution {
    public boolean checkIfPangram(String sentence) {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}; 
		

        for(int i = 0; i < letters.length; i++) if(!sentence.contains(letters[i])) 
                return false; 
		
        return true;
    }
}