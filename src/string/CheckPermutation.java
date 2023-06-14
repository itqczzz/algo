package string;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        //思路 map
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            Character c = s1.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c) + 1;
                map.put(c,count);
            }else{
                map.put(c,1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if(map.containsKey(c)){
                Integer count = map.get(c);
                count = count - 1;
                if(count == 0){
                    map.remove(c);
                }else{
                    map.put(c,count);
                }
            }
        }
        if(map.keySet().size() == 0){
            return true;
        }
        return false;
    }
}
