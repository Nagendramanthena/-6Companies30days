//link:
https://leetcode.com/problems/airplane-seat-assignment-probability/


// formula for n>2
  
//   f(n) = 1/n                       // 1st person picks his own seat, probability = 1/n
//     + 1/n * 0                    // 1st person picks last one's seat, probability = 1/n
// 	+ (n-2)/n *                  // 1st person picks one of seat from 2nd to (n-1)th, probability = (n-2)/n
//     (
// 	    1/(n-2) * f(n-1)         // 1st person pick 2nd's seat, 2nd person becomes the new "careless" person, and there are n-1 seats left. it becomes subproblem of n-1.
//         1/(n-2) * f(n-2)         // 1st person pick 3rd's seat, 2nd person will pick his own seat, 3nd person becomes the new "careless" person, and there are n-2 seats left. it becomes subproblem of n-2.
//         ......
//         1/(n-2) * f(2)           // 1st person pick (n-1)th's seat, (n-1)th person becomes the new "careless" person, there are 2 seats left.
// 	)
	
// => f(n) = 1/n                                                      {when n <= 2}
//    f(n) = 1/n + 1/n * ( f(n-1) + f(n-2) + f(n-3) + ... + f(2) )    {when n > 2}

//  f(n) = 1/n + 1/n * ( f(n-1) + f(n-2) + f(n-3) + ... + f(2) )    
// =>n * f(n) = 1 + f(n-1) + f(n-2) + f(n-3) + ... + f(2)
//   (n + 1) * f(n+1) = 1 + f(n) + f(n-1) + f(n-2) + f(n-3) + ... + f(2)
// =>(n + 1) * f(n+1) - n * f(n) = f(n) 
// =>(n + 1) * f(n+1) = (n + 1) * f(n) 
// =>f(n+1) = f(n)  

//   f(n) = 1/n + 1/n * ( f(n-1) + f(n-2) + f(n-3) + ... + f(2) )
// =>f(n) = 1/n + 1/n * ( f(n) + f(n) + f(n) + ... + f(n) )
// =>f(n) = 1/n + (n-2)/n * f(n)  
// =>n * f(n) = 1 + (n-2) * f(n)
// =>2 * f(n) = 1 
// =>f(n) = 1/2


code:
class Solution {
    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1.0d : .5d;
    }
}
