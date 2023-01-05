link:
https://leetcode.com/problems/minimum-deletions-to-make-array-divisible/

intuition:just find the gcd of the numsdivide 
// if the smallest number in nums divided gcd of numsdivide then it will all the numbers of numsdivide
// use a priorityqueue to find min deletions
//push all the elements of nums into the priorityqueue


code:


class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
      Arrays.sort(numsDivide);
        int len = nums.length;
        int gcd = arrGCD(numsDivide,0);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:nums)pq.add(i);
        int min = 0;
        while(!pq.isEmpty()){
            int num = pq.poll();
            if(gcd%num == 0)return min;
            else{
                min++;
                while(!pq.isEmpty() && pq.peek() == num){
                    pq.poll();
                    min++;
                }
            }
        }
        return min!=len? min:-1;
    }
    
    public int GCD(int x,int y){
        return y==0? x:GCD(y,x%y);
    }
    
    public int arrGCD(int arr[],int idx){
        if(idx == arr.length-1)return arr[idx];
        
        int a = arr[idx];
        int b = arrGCD(arr,idx+1);
        
        return GCD(a,b);
    }
}


Tc-O(NlogN);



//easy code

class Solution {
       public int minOperations(int[] A, int[] numsDivide) {
        int g = numsDivide[0], tmp;
        for (int a : numsDivide) {
            g = gcd(a,g);
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length && A[i] <= g; ++i)
            if (g % A[i] == 0)
                return i;
        return -1;
    }
    
    public int gcd(int a,int b){
        
        if(b == 0)return a;
        
        return gcd(b,a%b);
    }

}
