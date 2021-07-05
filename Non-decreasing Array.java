class Solution {
    public boolean checkPossibility(int[] nums) {
          int count = 0;
        for (int i = 0; i < nums.length - 1; i++)
            if (!(nums[i] <= nums[i + 1])) {
                if (count > 0)
                    return false;
                if (i - 1 >= 0 && i + 2 < nums.length && (nums[i] > nums[i + 2] && nums[i + 1] < nums[i - 1])){ //see Note
                    System.out.println(i);
                    return false;

                }
                count++;
            }
        return true;
    }
}
/*
Note: [3,4,2,3]
Here n-1 is bigger than n-2

line 8 condition checks for "if we can find numbers to insert between those two values, i and i+2"


/*