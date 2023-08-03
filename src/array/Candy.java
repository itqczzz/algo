package array;

public class Candy {
    public int candy(int[] ratings) {
        //先确定哪个孩子分数最低，以这个孩子作为起点
        int minRateIndex = 0;
        for (int i = 0; i < ratings.length; i++) {
            if(ratings[i] < ratings[minRateIndex]){
                minRateIndex = i;
            }
        }
        int candySum = 1;
        int preCandyNum = 1;
        for (int i = minRateIndex-1; i >=0; i--) {
            if(ratings[i] > ratings[i+1]){
                candySum+=preCandyNum+1;
            }else{
                preCandyNum = preCandyNum-1<=1?1:preCandyNum-1;
                candySum += preCandyNum;
            }
        }
        preCandyNum = 1;
        for (int i = minRateIndex+1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]){
                preCandyNum = preCandyNum+1;
            }else{
                preCandyNum = preCandyNum-1<=1?1:preCandyNum-1;
            }
            candySum += preCandyNum;
        }
        return candySum;
    }

    public int candy1(int[] ratings) {
        int[] pre = new int[ratings.length];
        int[] post = new int[ratings.length];

        pre[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                pre[i] = pre[i - 1] + 1;
            } else {
                pre[i] = 1;
            }
        }

        post[ratings.length - 1] = 1;
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                post[i] = post[i + 1] + 1;
            } else {
                post[i] = 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(pre[i], post[i]);
        }
        return sum;
    }



    public static void main(String[] args) {
        int[] ratings = new int[]{1,0,2};
        Candy candy = new Candy();
        int candySum = candy.candy1(ratings);
        System.out.println(candySum);
    }
}
