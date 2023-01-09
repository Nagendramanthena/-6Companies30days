link:https://leetcode.com/problems/all-elements-in-two-binary-search-trees/


code:
class Solution {
    List<Integer> l = new ArrayList<Integer>();
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        l.add(root.val);
        dfs(root.right);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        dfs(root1);dfs(root2);
        Collections.sort(l);
        return l;
    }
}
