package array;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()){
            return false;
        }
        boolean isSubsequence = false;
        for (int i = 0; i <= t.length()-s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if(t.charAt(i+j) != s.charAt(j)){
                    break;
                }
                if(j == s.length()-1){
                    isSubsequence = true;
                }
            }
        }
        return isSubsequence;
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        String s = "abc";
        String t = "ahbgdc";
        boolean subsequence = isSubsequence.isSubsequence(s, t);
        System.out.println(subsequence);
    }
}
