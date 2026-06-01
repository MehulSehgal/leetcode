class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        char_map = {}
        max_length = 0
        # 'start' marks the beginning of the current valid window
        start = 0
        
        for end in range(len(s)):
            # If the character is already in the map and within the current window
            if s[end] in char_map and char_map[s[end]] >= start:
                # Move the start pointer to the right of the previous occurrence
                start = char_map[s[end]] + 1
            
            # Update the last seen index of the character
            char_map[s[end]] = end
            
            # Calculate the window size and update max_length
            max_length = max(max_length, end - start + 1)
            
        return max_length
