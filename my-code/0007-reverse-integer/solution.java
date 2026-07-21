class Solution {
    public int reverse(int x) {
        int result = 0;
        
        while (x != 0) {
            // Get the last digit
            int pop = x % 10;
            x /= 10;
            
            // Check for overflow before multiplying by 10 and adding pop
            // Integer.MAX_VALUE is 2147483647
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            // Integer.MIN_VALUE is -2147483648
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            
            // Push the digit
            result = result * 10 + pop;
        }
        
        return result;
    }
}
