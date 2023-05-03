package array;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        int prefixIndex = Integer.MAX_VALUE;
        int n = strs.length;
        for (int i = 1; i < n; i++) {
            prefixIndex = commonPrefix(strs[i - 1], strs[i],prefixIndex);
            if(prefixIndex == -1){
                return "";
            }
        }
        return strs[0].substring(0,prefixIndex+1);
    }


    public int commonPrefix(String str1,String str2,int prefixIndex){
        prefixIndex = Math.min(str1.length() - 1,prefixIndex);
        prefixIndex = Math.min(str2.length() - 1,prefixIndex);
        for (int i = 0; i <= prefixIndex; i++) {
            if(str1.charAt(i) != str2.charAt(i)){
                return i - 1;
            }
        }
        return prefixIndex;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strings = {"c","c"};
        String commonPrefix = longestCommonPrefix.longestCommonPrefix(strings);
        System.out.println(commonPrefix);
    }
}
