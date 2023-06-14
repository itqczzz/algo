package string;

public class ReplaceSpaces {
    public String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        int index = 0;
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if(c == ' '){
                chars[index++] = '%';
                chars[index++] = '2';
                chars[index++] = '0';
            }else{
                chars[index++] = c;
            }
        }
        return new String(chars).trim();
    }

    public static void main(String[] args) {
//        "ds sdfs afs sdfa dfssf asdf             "
//        27
        ReplaceSpaces replaceSpaces = new ReplaceSpaces();
        String s = replaceSpaces.replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27);
        System.out.println(s);
    }
}
