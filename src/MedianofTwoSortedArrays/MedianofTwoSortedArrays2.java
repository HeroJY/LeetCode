package MedianofTwoSortedArrays;

/**
 * Created by hjy on 2017/5/18.
 */
public class MedianofTwoSortedArrays2 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1 == null) {
            nums1 = new int[0];
        }
        if (nums2 == null) {
            nums2 = new int[0];
        }

        int length1 = nums1.length;

        int length2 = nums2.length;

        int oddOrEven = (length1 + length2) % 2;

        int median = (length1 + length2) / 2;

        double medianNum;

        int i = 0;

        int j = 0;

        int k = 0;

        int[] resultNum = new int[length1 + length2];

        //两个数组有序合并，可以使用归并排序
        if (length1 > length2) {
            while (j < length2 && i<length1) {
                if (nums1[i] > nums2[j]) {
                    resultNum[k++] = nums2[j++];
                } else {
                    resultNum[k++] = nums1[i++];
                }
            }
            while (i < length1) {
                resultNum[k++] = nums1[i++];
            }
            while (j < length2) {
                resultNum[k++] = nums2[j++];
            }
        } else {
            while (i < length1 && j < length2) {
                if (nums1[i] > nums2[j]) {
                    resultNum[k++] = nums2[j++];
                } else {
                    resultNum[k++] = nums1[i++];
                }
            }
            while (i < length1) {
                resultNum[k++] = nums1[i++];
            }
            while (j < length2) {
                resultNum[k++] = nums2[j++];
            }
        }

        if (oddOrEven == 0) {
            medianNum = (resultNum[median - 1] + resultNum[median]) / 2.0;
        } else {
            medianNum = resultNum[median];
        }

        return medianNum;
    }

    public static void main(String[] args) {

        int[] i = {2, 2, 2, 2};

        int[] j = {2, 2};

        MedianofTwoSortedArrays2 t = new MedianofTwoSortedArrays2();

        double result = t.findMedianSortedArrays(i, j);

        System.out.println(result);
    }
}
