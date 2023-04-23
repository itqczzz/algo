package huaweiod;

import java.util.Scanner;
import java.util.Stack;

public class DecompressMessage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入压缩后的报文：");
        String compressedMessage = scanner.nextLine();
        String decompressedMessage = decompress(compressedMessage);
        System.out.println("解压后的原始报文：");
        System.out.println(decompressedMessage);
        scanner.close();
    }

    public static String decompress(String compressedMessage) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int index = 0;

        while (index < compressedMessage.length()) {
            char ch = compressedMessage.charAt(index);

            if (Character.isDigit(ch)) {
                int count = 0;
                while (Character.isDigit(compressedMessage.charAt(index))) {
                    count = count * 10 + (compressedMessage.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            } else if (ch == '[') {
                strStack.push(currentStr);
                currentStr = new StringBuilder();
                index++;
            } else if (ch == ']') {
                StringBuilder temp = currentStr;
                currentStr = strStack.pop();
                int repeatCount = countStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    currentStr.append(temp);
                }
                index++;
            } else {
                currentStr.append(ch);
                index++;
            }
        }

        return currentStr.toString();
    }
}
