//bruteforce

zzclass Solution {
    int total_Nodes = 0;
    public int Nodes(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftnodes = Nodes(root.left);
        int rightnodes = Nodes(root.right);
        return 1+leftnodes+rightnodes;
    }
    public int sum(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftchild = sum(root.left);
        int rightchild = sum(root.right);
        return root.val+leftchild+rightchild;
        
    }
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        if(sum(root)/Nodes(root) == root.val){
            total_Nodes++;
        }
        dfs(root.left);
        dfs(root.right);
         
        
    }
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return total_Nodes;
    }
}


Betterone

zclass Solution {
    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }
    
    private int[] dfs(TreeNode node) {
        if(node == null) {
            return new int[] {0,0};
        }
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        
        int currSum = left[0] + right[0] + node.val;
        int currCount = left[1] + right[1] + 1;
        
        if(currSum / currCount == node.val) {
            res++;
        }
            
        return new int[] {currSum, currCount};
    }
}
