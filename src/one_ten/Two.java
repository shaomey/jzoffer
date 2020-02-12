package one_ten;

/**
  第一种方法 复杂度过高
 */
public class Two {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int len = matrix.length;
        int colLen = matrix[0].length;
        for (int i = 0; i < len; i++) {
            if (matrix[i][colLen - 1] >= target && matrix[i][0]<=target) {
                if (findInArray(matrix[i], target)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findInArray(int[] arr, int target) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * 这种方法的核心是  如果
     * matrix[row][col]>target
     * 那么row和大于row所在列的值均大于target
     * @param matrix
     * @param target
     * @return
     */

    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while(row < m && col >= 0) {
            if(matrix[row][col] > target) {
                col--;
            }else if(matrix[row][col] < target) {
                row++;
            }else {
                return true;
            }
        }
        return false;
    }
}
