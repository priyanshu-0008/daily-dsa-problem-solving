class Solution {
    public int numberOfSubstrings(String s) {
        // Convert the input string to a character array for easy access
        char[] c = s.toCharArray();
        
        // Store the length of the string
        int n = s.length();
        
        // Array to store the cumulative count of '1's at each position
        int[] one = new int[n + 1];
        
        // Counter to keep track of the total number of '1's encountered
        int count = 0;

        // Loop through each character in the string
        for (int i = 0; i < n; i++) {
            
            // If the character is '1', increment the count
            if (c[i] == '1')
                count++;
            
            // Store the cumulative count of '1's up to the current position
            one[i + 1] = count;
        }

        // Initialize the answer to store the total count of valid substrings
        int ans = 0;

        // Loop over each starting point of substrings
        for (int left = 0; left < n; left++) {
            
            // Loop over each endpoint for substrings starting at 'left'
            for (int right = left; right < n; right++) {
                
                // Calculate the number of '1's in the current substring
                int c1 = one[right + 1] - one[left];
                
                // Calculate the number of '0's in the current substring
                int c0 = right - left + 1 - c1;

                // Check if the condition for the valid substring is met
                if (c0 * c0 <= c1) {
                    
                    // If valid, increment the answer count
                    ans++;
                    
                    // Calculate an optimization value for skipping unnecessary checks
                    int val = Math.min(Math.max((int) Math.sqrt(c1) - c0 - 1, 0), n - 1 - right);
                    
                    // Skip unnecessary checks by moving 'right' forward
                    right += val;
                    
                    // Add skipped values to the answer count
                    ans += val;
                } else {
                    // If not valid, adjust 'right' to skip based on 'c0' and 'c1'
                    right += c0 * c0 - c1 - 1;
                }
            }
        }

        // Return the total count of valid substrings
        return ans;
    }
}