package huaweiod;

import java.util.Scanner;

public class StringSplitSolution {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            int totalWidth = 8; // 字符串总宽度，包括补0后的宽度
            int preIndex = 0;
            int curIndex = 8;
            while (true) {
                if (curIndex >= str.length()) {
                    String tmp = str.substring(preIndex);
                    String paddedStr =(totalWidth - tmp.length()) == 8? tmp: String.format("%s%0" + (totalWidth - tmp.length()) + "d",tmp, 0);
                    System.out.println(paddedStr);
                    break;
                }else{
                    System.out.println(str.substring(preIndex,curIndex));
                }
                curIndex+=8;
                preIndex+=8;
            }

        }


}
