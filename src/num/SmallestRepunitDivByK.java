package num;

public class SmallestRepunitDivByK {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        int remainder = 0;
        for (int n = 1; n <= k; n++) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) {
                return n;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SmallestRepunitDivByK smallestRepunitDivByK = new SmallestRepunitDivByK();
        int res = smallestRepunitDivByK.smallestRepunitDivByK(3);
        System.out.println(res);
    }
}







