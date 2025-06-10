class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        
        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        int maxOdd = -1, minEven = Integer.MAX_VALUE;
        
        // Find max odd frequency and min even frequency
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                if (freq[i] % 2 == 1) { // Odd frequency
                    maxOdd = Math.max(maxOdd, freq[i]);
                } else { // Even frequency
                    minEven = Math.min(minEven, freq[i]);
                }
            }
        }
        
        // Ensure both even and odd frequencies exist
        if (maxOdd != -1 && minEven != Integer.MAX_VALUE) {
            return maxOdd - minEven;
        }
        
        return 0; // Default case (shouldn't occur due to constraints)
    }
}
