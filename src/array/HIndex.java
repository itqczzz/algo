package array;

import java.util.Arrays;

public class HIndex {
//    给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h指数。
//
//    根据维基百科上h 指数的定义：h 代表“高引用次数”，一名科研人员的 h指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的 n - h篇论文每篇被引用次数不超过 h 次。
//
//    如果 h 有多种可能的值，h 指数 是其中最大的那个。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode.cn/problems/h-index
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    /**
     * 思路：找出中位数
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucket = new int[n + 1];

        // 统计每篇论文的引用次数
        for (int citation : citations) {
            bucket[Math.min(citation, n)]++;
        }

//        // 计算 h 指数
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += bucket[i];
            if (count >= i) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        int[] citations = new int[]{1000,1001,1002,1003,1004};
        int h = hIndex.hIndex(citations);
        System.out.println(h);
    }
}
