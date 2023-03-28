package slidingwindow;

import java.util.*;

public class FindRepeatedDnaSequencesSolution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        Integer gap = 10;
        for (int i = 0; i <= s.length() - gap; i++) {
            String str = s.substring(i, i + gap);
            map.put(str,map.getOrDefault(str,0)+1);
            if(map.get(str) == 2){
                res.add(str);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindRepeatedDnaSequencesSolution findRepeatedDnaSequencesSolution = new FindRepeatedDnaSequencesSolution();
        List<String> aaaaacccccaaaaaccccccaaaaagggttt = findRepeatedDnaSequencesSolution.findRepeatedDnaSequences("AAAAAAAAAAA");
        System.out.println(aaaaacccccaaaaaccccccaaaaagggttt);
    }
}
