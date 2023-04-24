package huaweiod;

public class MaxScoreSolution {
    /**
     * 日志采集是运维系统的的核心组件。日志是按行生成，每行记做一条，由采集系统分批上报。
     *
     * 如果上报太频繁，会对服务端造成压力;如果上报太晚，会降低用户的体验;如果一次上报的条数太多，会导致超时失败。为此，项目组设计了如下的上报策略:
     *
     * 1、每成功上报一条日志，奖励1分
     *
     * 2、每条日志每延迟上报1秒，扣1分
     *
     * 3、积累日志达到100条，必须立即上报
     *
     * 给出日志序列，根据该规则，计算首次上报能获得的最多积分数
     *
     * 输入描述:
     *
     * 按时序产生的日志条数 T1,T2...Tn，其中 1<=n<=1000，0<=Ti<=100
     *
     * 输出描述:
     *
     * 首次上报最多能获得的积分数
     *
     * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
     *
     * 输入
     *
     * 1 98 1
     *
     * 输出
     *
     * 98
     *
     * 说明：
     *
     * T1 时刻上报得 1 分
     *
     * T2 时刻上报得98分，最大
     *
     * T3 时刻上报得 0 分
     *
     * 示例2 输入输出示例仅供调试，后台判题数据一般不包含示例
     *
     * 输入
     *
     * 3 7 40 10 60
     *
     * 输出
     *
     * 37
     *
     * 说明：
     *
     * T1 时刻上报得 3 分
     *
     * T2 时刻上报得 7 分
     *
     * T3 时刻上报得 37 分，最大
     *
     * T4 时刻上报得 -3 分
     *
     * T5 时刻上报，因为已经超了100条的限制，所以只能上报100条，得 -23 分
     * @param nums
     * @return
     */
    public static int maxScore(int[] nums){
        //最大分数值
        int max = Integer.MIN_VALUE;
        //累计日志条数
        int sum = 0;
        //累计需要扣除的分数
        int reduce = 0;
        //前一秒日志条数
        int sumPre = 0;
        for (int i = 0; i < nums.length; i++) {
            sumPre = sum;
            reduce += sumPre;
            sum += nums[i];
            int score = 0;
            if(sum < 100){
                score = sum - reduce;
            }else{
                score = 100 - reduce;
                break;
            }
            max = Math.max(max,score);
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] ints = {1,98,1};
        int[] ints = {3,7,40,10,60};
        int i = maxScore(ints);
        System.out.println(i);
    }
}
