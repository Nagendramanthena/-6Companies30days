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
