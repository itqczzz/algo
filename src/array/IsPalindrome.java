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

    public boolean isPalindrome1(String s) {
        s = removeSpec(s);
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    public String removeSpec(String s){
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if((c>='a'&&c<='z') || (c >= '0' && c <= '9')){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        boolean palindrome = isPalindrome.isPalindrome1("0P");
        System.out.println(palindrome);
    }


}
