package array;

public class StrStr {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()){
            return -1;
        }
        //最朴素的解法，遍历，控制好边界
        for (int i = 0; i < haystack.length()-needle.length(); i++) {
            int index = i;
            for (int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(index) != needle.charAt(j)){
                    break;
                }
                if(j == needle.length()-1){
                    return i;
                }
                index++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        int i = strStr.strStr("a", "a");
        System.out.println(i);
    }
}
