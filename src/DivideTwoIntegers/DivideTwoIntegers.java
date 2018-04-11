package DivideTwoIntegers;

/**
 * Created by hjy on 2018/4/10.
 *
 * @author hjy
 *         不使用乘号，除号和取模符号将两数相除。
 *         思路：
 *         任何一个整数都可以用2的n次幂相加，所以这里可以采用位运算，向左移一位等于乘2
 */
public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        int sign = 1;
        long a = dividend;
        long b = divisor;
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        if (dividend >= 0 && divisor >= 0 || dividend <= 0 && divisor <= 0) {
            sign = 1;
        } else {
            sign = -1;
        }
        a = Math.abs( (long) a );
        b = Math.abs( (long) b );
        if (a < b) {
            return 0;
        }
        int re = 0;
        while (a >= b) {
            int temp = 1;
            long bt = b;
            while (a >= bt << 1) {
                //除数和累加数都乘以2
                bt = bt << 1;
                temp = temp << 1;
            }
            re += temp;
            a -= bt;
        }

        return re * sign;
    }

    public static void main(String[] args) {
        int a = 2147483647;
        int b = 2;
        int result = DivideTwoIntegers.divide( a, b );
        System.out.println( result );
    }
}
