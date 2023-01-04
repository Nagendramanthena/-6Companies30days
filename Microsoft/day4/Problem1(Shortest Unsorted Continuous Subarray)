Link:
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/



code

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int x[] = Arrays.copyOf(nums,n);
        Arrays.sort(nums);
        int end = -1;
        int ans = 0;
        for(int i=0;i<n;i++){
            if(nums[i]!=x[i]){
                if(end!=-1){
                    ans += (i-end-1)+1;
                    end = i;
                }
                else{
                    ans++;
                    end = i;
                }
            }
        }
        return ans;
    }
}


//Method2
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        System.out.println(min);
        System.out.println(max);
        return r - l < 0 ? 0 : r - l + 1;
    }
}

Tc-O(N)
sc-O(1)

this is to find the smallest and largest element in unsorted subarray
