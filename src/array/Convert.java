package array;

import java.util.HashMap;
import java.util.Map;

public class Convert {

    public String convert(String s, int numRows) {
        boolean flag = false;
        int n = s.length();
        Map<Integer,StringBuilder> map = new HashMap<>();
        int level = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            StringBuilder stringBuilder = map.get(level);
            if(stringBuilder == null){
                stringBuilder = new StringBuilder();
                map.put(level,stringBuilder);
            }
            stringBuilder.append(c);
            level = flag ? level-1 : level+1;
            if(level == numRows - 1){
                flag = true;
            }
            if(level == 0){
                flag = false;
            }
        }
        StringBuilder res = new StringBuilder();
        for(Map.Entry<Integer,StringBuilder> entry : map.entrySet()){
            res.append(entry.getValue());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "A";
        Convert convert = new Convert();
        String convert1 = convert.convert(str, 3);
        System.out.println(convert1);
    }
}
