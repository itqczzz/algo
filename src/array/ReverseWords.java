package array;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWords {

    // 方法一：使用语言特性
    public String reverseWords1(String s) {
        // 去除首尾空格，分割字符串
        String[] words = s.trim().split(" +");
        // 反转数组
        Collections.reverse(Arrays.asList(words));
        // 拼接字符串
        return String.join(" ", words);
    }
    // 方法二：双指针
    public String reverseWords2(String s){
        // 去除首尾空格
        s = s.trim();
        // 双指针
        int i = s.length() - 1;
        int j = i;
        StringBuilder sb = new StringBuilder();
        while (i >= 0){
            // 搜索首个空格
            while (i >= 0 && s.charAt(i) != ' ') i--;
            // 添加单词
            sb.append(s.substring(i + 1, j + 1) + " ");
            // 跳过单词间空格
            while (i >= 0 && s.charAt(i) == ' ') i--;
            // j 指向下个单词的尾字符
            j = i;
        }
        // 转化为字符串并返回
        return sb.toString().trim();
    }
    // 方法三：双指针（原地算法）
    public String reverseWords3(String s) {
        // 去除首尾空格
        s = s.trim();
        // 双指针
        int i = s.length() - 1;
        int j = i;
        char[] chars = s.toCharArray();
        while (i >= 0){
            // 搜索首个空格
            while (i >= 0 && chars[i] != ' ') i--;
            // 添加单词
            reverse(chars, i + 1, j);
            // 跳过单词间空格
            while (i >= 0 && chars[i] == ' ') i--;
            // j 指向下个单词的尾字符
            j = i;
        }
        // 转化为字符串并返回
        return new String(chars).trim();
    }

    //4. 双指针（原地算法优化）
    public String reverseWords4(String s) {
        // 去除首尾空格
        s = s.trim();
        // 双指针
        int i = s.length() - 1;
        int j = i;
        char[] chars = s.toCharArray();
        while (i >= 0){
            // 搜索首个空格
            while (i >= 0 && chars[i] != ' ') i--;
            // 添加单词
            reverse(chars, i + 1, j);
            // 跳过单词间空格
            while (i >= 0 && chars[i] == ' ') i--;
            // j 指向下个单词的尾字符
            j = i;
        }
        // 转化为字符串并返回
        return new String(chars, 0, j + 1);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j){
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;
        }
    }


}
