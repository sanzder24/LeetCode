class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
 int mindex = 0, nindex = 0, prevVal = 0, val = 0;

        for (int i = 0; i <= (nums1.length + nums2.length)/2 ;i++) {
            prevVal = val; //prevVal needed if merged array size is even
            if(mindex == nums1.length) // Either empty array or all elements are smaller than other array
                val = nums2[nindex++];
            else if (nindex == nums2.length) // Either empty array or all elements are smaller than other array
                val = nums1[mindex++];
            else if (nums1[mindex] <= nums2[nindex]) 
                val = nums1[mindex++];
            else
                val = nums2[nindex++];
        }
        
        if ((nums1.length + nums2.length)%2 == 1) 
            return val/1.0;
        return (val + prevVal) / 2.0;
    }
}