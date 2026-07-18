class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Handle edge cases
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int left = 0;
        int right = m * n - 1;
        
        while (left <= right) {
            // Prevent integer overflow for large indices
            int mid = left + (right - left) / 2;
            
            // Map the 1D index back to 2D row and column indices
            int midValue = matrix[mid / n][mid % n];
            
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }
        
        return false;
    }
}
