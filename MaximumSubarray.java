/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23

Constraints:

1 <= nums.length <= 3 * 104
-105 <= nums[i] <= 105

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

//Kadane's Algorithm
public class MaximumSubarray {

    public static void main(String[] args){
        int result = solution(new int[]{1});
        System.out.println(result);
    }

    private static int solution(int[] nums){
        int maxCurrent = 0,maxGlobal = nums[0];

        for (int i = 0; i < nums.length; i++){
            maxCurrent = max(nums[i], nums[i] + maxCurrent);
            maxGlobal = maxCurrent > maxGlobal ? maxCurrent : maxGlobal;
        }
        
        return maxGlobal;
    }

    private static int max(int a , int b) {
        return a > b ? a : b;
    }
}
