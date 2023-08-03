package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
	public String minWindow(String s, String t) {
		String res = "";
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
		}
		int left = 0;
		Map<Character, Integer> currentMap = new HashMap<>();
		for (int right = 0; right < s.length(); right++) {
			if (map.containsKey(s.charAt(right))) {
				currentMap.put(s.charAt(right), currentMap.getOrDefault(s.charAt(right), 0) + 1);
			}
			while (map.equals(currentMap)) {
				String substring = s.substring(left, right + 1);
				if (!substring.equals("")) {
					res = (!res.equals("") && (res.length() > substring.length())) ? substring : res;
				}
				char leftChar = s.charAt(left);
				if (currentMap.containsKey(leftChar)) {
					if (currentMap.get(leftChar) == 1) {
						currentMap.remove(leftChar);
					} else {
						currentMap.put(leftChar, currentMap.get(leftChar) - 1);
					}
				}
				left++;
			}
		}
		return res;
	}


	public static void main(String[] args) {
		MinWindow minWindow = new MinWindow();
		String s = "ADOBECODEBANC";
		String t = "ABC";
		String res = minWindow.minWindow(s, t);
		System.out.println(res);
	}
}
