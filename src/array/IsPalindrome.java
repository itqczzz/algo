package array;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        //处理字符串
        s = removeOtherChar(s);
        int left = 0,right = s.length()-1;
        while (left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String removeOtherChar(String s){
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if((c>='a' && c <='z')|| (c >= '0' && c <= '9')){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
