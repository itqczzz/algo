package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLenth = Integer.MIN_VALUE;
        int left = 0;
        Map<Character,Integer> map = new HashMap();
        for(int right = 0; right < s.length();right++){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left,map.get(s.charAt(right))+1);
//                left = map.get(s.charAt(right))+1;
            }
            map.put(s.charAt(right),right);
            maxLenth = Math.max(maxLenth,right-left+1);
        }
        return maxLenth == Integer.MIN_VALUE ? 0:maxLenth;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int maxLength = lengthOfLongestSubstring.lengthOfLongestSubstring("abba");
        System.out.println(maxLength);
    }
}
