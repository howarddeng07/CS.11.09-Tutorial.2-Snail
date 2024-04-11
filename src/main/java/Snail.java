import java.lang.Math;
public class Snail {

    /**
     *
     * TODO 5
     *
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        if (array2d == null || array2d.length == 0 || array2d[0].length == 0 || array2d.length != array2d[0].length) {
            return new int[0];
        }

        int size = array2d.length * array2d.length;
        int[] result = new int[size];
        int top = 0;
        int bottom = array2d.length - 1;
        int left = 0;
        int right = array2d[0].length - 1;
        int index = 0;

        while (index < size) {

            for (int i = left; i <= right && index < size; i++) {
                result[index++] = array2d[top][i];
            }
            top++;


            for (int i = top; i <= bottom && index < size; i++) {
                result[index++] = array2d[i][right];
            }
            right--;


            for (int i = right; i >= left && index < size; i--) {
                result[index++] = array2d[bottom][i];
            }
            bottom--;


            for (int i = bottom; i >= top && index < size; i--) {
                result[index++] = array2d[i][left];
            }
            left++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] array2d = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };

        int[] snailFlattened = flattenSnail(array2d);
        for (int value : snailFlattened) {
            System.out.print(value + " ");
        }
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */

    public static int[][] makeSnail(int[] array1d) {

        if (array1d == null || array1d.length == 0 || !isPerfectSquare(array1d.length)) {
            return new int[0][0];
        }

        int n = (int) Math.sqrt(array1d.length);
        int[][] snailArray = new int[n][n];

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int index = 0;

        while (index < array1d.length) {

            for (int i = left; i <= right && index < array1d.length; i++) {
                snailArray[top][i] = array1d[index++];
            }
            top++;


            for (int i = top; i <= bottom && index < array1d.length; i++) {
                snailArray[i][right] = array1d[index++];
            }
            right--;


            for (int i = right; i >= left && index < array1d.length; i--) {
                snailArray[bottom][i] = array1d[index++];
            }
            bottom--;


            for (int i = bottom; i >= top && index < array1d.length; i--) {
                snailArray[i][left] = array1d[index++];
            }
            left++;
        }

        return snailArray;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for(int i = 0; i < array1d.length; i++){
            System.out.println(array1d[i]);
        }
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for(int i = 0; i<array2d.length; i++){
            for(int j = 0; j<array2d[i].length; j++){
                System.out.println(array2d[i][j]);
            }
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int length) {
        double sqrt = Math.sqrt(length);
        return sqrt % 1 == 0;
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        return (Math.sqrt(array2d.length*array2d[0].length) % 1 == 0);
    }


}
