package PalindromeNumber;

/**
 * Created by hjy on 2017/5/23.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        int reverse = 0;

        int y = x;

        if (x < 0) {
            return false;
        }

        while (y != 0) {
            reverse = reverse * 10 + y % 10;
            y = y / 10;
        }

        if (reverse == x) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();

        System.out.println(pn.isPalindrome(-2147447412
        ));

    }
}
