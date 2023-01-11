Link:https://leetcode.com/problems/fraction-to-recurring-decimal/



code:

class Solution {
    public String fractionToDecimal(int n, int d) {
        StringBuilder sb = new StringBuilder("");
        
        HashMap<Long,Integer> hm = new HashMap<>();
        String sign = "";
        
        if((n<0 && d>0) || (n>0 && d<0)){
            sign = "-";
        }
        
        long numerator = Math.abs((long)n);
        long denominator =Math.abs((long)d);
        
        sb.append(sign);
        sb.append(numerator/denominator);
        long rem = numerator%denominator;
        
        if(rem == 0){
            return sb.toString();
        }
        
        sb.append(".");
        
        while(!hm.containsKey(rem)){
            hm.put(rem,sb.length());
            sb.append(rem*10/denominator);
            rem = 10*rem%denominator;
            if(rem == 0)return sb.toString();
        }
        int index = hm.get(rem);
        sb.insert(index,"(");
        sb.append(")");
        
        
        return sb.toString();
    }
}
