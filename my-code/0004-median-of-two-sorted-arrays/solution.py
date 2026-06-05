class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        merged = nums1 + nums2
        merged.sort()
        
        n = len(merged)
        mid_id = n // 2
        
        # If even, average the two middle elements
        if n % 2 == 0:
            return (merged[mid_id - 1] + merged[mid_id]) / 2.0
        # If odd, return the single middle element
        else:
            return float(merged[mid_id])
