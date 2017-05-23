package ReverseInteger;

/**
 * Created by hjy on 2017/5/23.
 */
public class ReverseInteger {

    public int reverse(int x) {

        double tempResult = 0;

        int i = 0;

        String resultTem;

        if(x>=0){
            resultTem = String.valueOf(x);
            while (i < resultTem.length()) {

                tempResult = tempResult * 10 + x % 10;

                if(tempResult>= Integer.MAX_VALUE){
                    return 0;
                }

                x = x / 10;

                i++;
            }
        }else{
            resultTem = String.valueOf(Math.abs(x));

            while (i < resultTem.length()) {

                tempResult = tempResult * 10 + x % 10;

                if(tempResult<=Integer.MIN_VALUE){
                    return 0;
                }

                x = x / 10;

                i++;
            }
        }
        return (int)tempResult;
    }

    public static void main(String[] args) {

        ReverseInteger ri = new ReverseInteger();

        int result;

        result = ri.reverse(-1534236469);

        System.out.println(result);
    }
}
