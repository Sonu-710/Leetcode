//K Radius Subarray Averages
//Link - https://leetcode.com/problems/k-radius-subarray-averages/


class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] arr=new int[nums.length]; 
        int start=0;
        long[] sum=new long[nums.length];
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            sum[i]=sum[i-1]+nums[i];
        }
        for(int end=0;end<nums.length;end++)
        {
            if(k+1==end-start+1 && end+k<nums.length)
            {
                long s=0;
                if(start-1!=-1)
                s=sum[end+k]-sum[start-1];
                else
                s=sum[end+k];
                start++;
                arr[end]=(int)(s/(long)(2*k+1));
            }
            else
            {
                arr[end]=-1;
            }
        }
        return arr;
    }
}


// Time Complexity - O(n)
//Space Complexity - O(1)