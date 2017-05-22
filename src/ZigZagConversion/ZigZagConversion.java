package ZigZagConversion;

/**
 * Created by hjy on 2017/5/22.
 * 核心可看成填字游戏
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {

        if(numRows ==1){
            return s;
        }

        int i = 0;

        int j;

        int size = 2 * numRows - 2;

        StringBuffer result = new StringBuffer();

        //按行数填字
        while (i < numRows) {
            j = i;
            while (j < s.length()) {
                result.append(s.charAt(j));
                if (i != 0 && i != numRows - 1){
                    if((j+size-2*i)<s.length()){
                        result.append(s.charAt(j+size-2*i));
                    }
                }
                    j += size;
            }
            i++;
        }

        return result.toString();

    }

    public static void main(String[] args) {

        ZigZagConversion zzc = new ZigZagConversion();

        String s = "A";

        String result;

        result = zzc.convert(s, 1);

        System.out.println(result);

    }
}
