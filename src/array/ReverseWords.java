package array;

import java.util.Arrays;

public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);

        // 反转整个字符串
        reverse(sb, 0, sb.length() - 1);

        // 反转每个单词
        reverseWords(sb);

        // 清理多余空格
        return cleanSpaces(sb);
    }

    private void reverseWords(StringBuilder sb) {
        int i = 0;
        int j = 0;

        while (i < sb.length()) {
            while (i < j || i < sb.length() && sb.charAt(i) == ' ') i++; // 跳过空格
            while (j < i || j < sb.length() && sb.charAt(j) != ' ') j++; // 跳过非空格

            // 反转单词
            reverse(sb, i, j - 1);
        }
    }

    private String cleanSpaces(StringBuilder sb) {
        int i = 0;
        int j = 0;

        while (j < sb.length()) {
            while (j < sb.length() && sb.charAt(j) == ' ') j++; // 跳过空格
            while (j < sb.length() && sb.charAt(j) != ' ') sb.setCharAt(i++, sb.charAt(j++)); // 保留非空格

            // 在每个单词后面添加一个空格（除了最后一个单词）
            if (j < sb.length()) sb.setCharAt(i++, ' ');
        }

        // 删除多余的字符
        sb.setLength(i - 1); // 更新长度时，需要减去 1 以去掉最后一个单词后添加的空格

        return sb.toString();
    }

    private void reverse(StringBuilder sb, int i, int j) {
        while (i < j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i++, sb.charAt(j));
            sb.setCharAt(j--, temp);
        }
    }
    
    public static void main(String[] args) {
        String str = "  hello world  ";
        ReverseWords reverseWords = new ReverseWords();
        String s = reverseWords.reverseWords(str);
        System.out.println(s);
    }
}
