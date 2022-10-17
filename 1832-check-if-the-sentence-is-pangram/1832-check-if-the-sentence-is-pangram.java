class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> seen = new HashSet<>();

	for (char currChar : sentence.toCharArray())
		seen.add(currChar);

	return seen.size() == 26;
    }
}