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
    /**
     * 暴力解法，双重for循环
     * 优化： 找出第一个和第二个字符串的公共子串，然后公共子串和第三个对比，第四个，依次对比
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            prefix = commoString2(strs[i], prefix);
        }
        return prefix;
    }

    public String commoString2(String str1,String str2){
        StringBuilder sb = new StringBuilder();
        int len = str1.length() > str2.length() ? str2.length() : str1.length();
        for (int i = 0; i < len; i++) {
            if(str1.charAt(i) == str2.charAt(i)){
                sb.append(str1.charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
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
        String commonPrefix = longestCommonPrefix.longestCommonPrefix2(strings);
        System.out.println(commonPrefix);
    }
}
