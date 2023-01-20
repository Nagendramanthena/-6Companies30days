class Solution {
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> hm = new HashMap<>();
        return rob2(root,hm);
    }
    
    public int rob2(TreeNode root,HashMap<TreeNode,Integer> hm){
        if(root == null)return 0;
        
        //memoization
        
        if(hm.containsKey(root))return hm.get(root);
        
        int op1 = root.val;
        
        //pickroot;
        
        if(root.left!=null){
            op1 += rob2(root.left.left,hm)+rob2(root.left.right,hm);
        }
        if(root.right!=null){
            op1 += rob2(root.right.left,hm)+rob2(root.right.right,hm);
        }
        
        //dontpick
        int op2 = rob2(root.left,hm)+rob2(root.right,hm);
        
        hm.put(root,Math.max(op1,op2));
        
        return Math.max(op1,op2);
    }
}
