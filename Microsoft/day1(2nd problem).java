// this was a simple backtracking problem
//if(l.size() == k) add to the ans;
//we can add that number or we can leave it
// so we try both the ways


class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        back(n,1,ans,new ArrayList<>(),k,0);
        return ans;
    }
    public void back(int n,int index,List<List<Integer>> ans ,List<Integer> l,int k,int sum){
        if(index>10){
            return;
        }
        if(l.size() == k && sum == n){
            if(!ans.contains(new ArrayList<>(l))){
            ans.add(new ArrayList<>(l));
            }
        }
        l.add(index);
        back(n,index+1,ans,l,k,sum+index);
        l.remove(l.size()-1);
        back(n,index+1,ans,l,k,sum);
    }
}
