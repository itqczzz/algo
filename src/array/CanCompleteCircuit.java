package array;

/**
 * 在一条环路上有 n个加油站，其中第 i个加油站有汽油gas[i]升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanCompleteCircuit {
    /**
     *
     * 思路：假设dp[i]为到达i站点的时候剩余的汽油
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = cost.length;
        //外层循环代表从哪个站点出发
        for (int i = 0; i < cost[i]; i++) {
            int[] dp = new int[n];
            //初始油量
            dp[i] = gas[i];
            int cur = i + 1;
            while (cur != i){

            }
        }
    }
}
