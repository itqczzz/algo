package array;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int count = 0;
        for (int i = n-1;i>=0; i--) {
            if(count == 0 && s.charAt(i) !=' '){
                count++;
                end = i;
            }else if(count==1&&s.charAt(i) == ' '){
                start = i;
                return end-start;
            }
        }
        return end-start+1;
    }

    public int lengthOfLastWord2(String s) {
        int count = 0;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ' && count == 0){
                continue;
            }
            if(s.charAt(i) != ' '){
                count++;
            }
            if(s.charAt(i) == ' ' && count > 0){
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        int hello_world = lengthOfLastWord.lengthOfLastWord2(" a 123");
        System.out.println(hello_world);
    }
}
