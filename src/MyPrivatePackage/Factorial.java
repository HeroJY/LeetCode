package MyPrivatePackage;

/**
 * Created by hjy on 2017/8/9.
 * 计算阶乘
 */
public class Factorial {
    public static void main(String[] args) {
        int n = 4;
        int result = 1;
        result = factorial(n, result);
        System.out.println(result);
    }

    public static int factorial(int n, int result) {
        if (n == 1) {
            return result;
        } else {
            result = result * n;
            result = factorial(n - 1, result);
            return result;
        }
    }
}
