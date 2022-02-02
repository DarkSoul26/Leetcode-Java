class Solution {
public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		if (p.length() > s.length()) {
			return list;
		}
        int[] freq = new int[26];
		for (int i = 0; i < p.length(); i++) {
			freq[p.charAt(i) - 'a'] += 1;
			freq[s.charAt(i) - 'a'] -= 1;
		}
		int i = 0;
		for (; i < s.length() - p.length(); i++) {
			if (checkAnagram(freq)) {
				list.add(i);
			}
			freq[s.charAt(i) - 'a'] += 1;
			freq[s.charAt(i + p.length()) - 'a'] -= 1;
		}
	   if (checkAnagram(freq)) {
			list.add(i);
		}
		return list;
	}
	
	private boolean checkAnagram(int[] freq) {
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] != 0) {
				return false;
			}
		}
		return true;
	}    
}