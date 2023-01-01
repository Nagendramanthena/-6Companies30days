// there are two cases 
// whenever we find a number push into the stack
// if you find an expression pop the first two out and do the operation according to the operation
//push back into the stack

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        int ans = 0;
        for(int i=0;i<tokens.length;i++){
            if(isExpression(tokens[i])){
                String first = st.pop();
                String second = st.pop();
                String exp = tokens[i];
                if(exp.equals("+")){
                
                    int v = Integer.parseInt(first)+Integer.parseInt(second);
                    st.push(String.valueOf(v));
                }
                else if(exp.equals("-")){
                    int v = Integer.parseInt(second)-Integer.parseInt(first);
                    
                    st.push(String.valueOf(v));
                }
               else if(exp.equals("*")){
                    int v = Integer.parseInt(second)*Integer.parseInt(first);
                    st.push(String.valueOf(v));
                }
                else{
                    int v = Integer.parseInt(second)/Integer.parseInt(first);
                    st.push(String.valueOf(v));
                }
            }
            else{
                st.push(tokens[i]);
            }
        }
        return Integer.parseInt(st.pop());
        
    }
    public boolean isExpression(String s){
        return (s.equals("+")||s.equals("-")||s.equals("/")||s.equals("*"));
    }
}
