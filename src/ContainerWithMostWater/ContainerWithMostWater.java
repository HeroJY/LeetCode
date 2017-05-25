package ContainerWithMostWater;

/**
 * Created by hjy on 2017/5/25.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        int result = 0;

        int i = 0;

        int j = height.length - 1;
        while (i != j) {
            if (height[i] > height[j]) {
                if(result <height[j] * (j - i)){
                    result = height[j] * (j - i);
                }
                j--;
            } else {
                if(result < height[i] * (j - i)){
                    result = height[i] * (j - i);;
                }
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ContainerWithMostWater cwmw = new ContainerWithMostWater();

        int[] a = {2,1,3,6};

        System.out.println(cwmw.maxArea(a));

    }
}
