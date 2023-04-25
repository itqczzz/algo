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
            int cur = i + 1 == n ? 0: i+1;
            while (cur != i){
                int pre = cur - 1 == -1? n-1:cur-1;
                dp[cur] = dp[pre] + gas[cur] - cost[pre];
                if(dp[cur] < cost[cur]){
                    break;
                }
                cur++;
                if(cur == n){
                    cur = 0;
                }
            }
            if(cur == i){
                return i;
            }
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = cost.length;
        int start = 0, totalGas = 0, totalCost = 0, tank = 0;
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {  // 当前位置加不上油了
                start = i + 1;  // 尝试从下一个位置出发
                tank = 0;
            }
        }
        return totalGas < totalCost ? -1 : start;  // 如果总油量小于总耗油量，则无解；否则返回起点
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        CanCompleteCircuit canCompleteCircuit = new CanCompleteCircuit();
        int i = canCompleteCircuit.canCompleteCircuit2(gas, cost);
        System.out.println(i);
    }
}
