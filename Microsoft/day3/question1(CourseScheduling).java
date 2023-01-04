link:https://leetcode.com/problems/course-schedule/


code:


class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int indegree[] = new int[n];
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int p[]:prerequisites){
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)q.add(i);
        }
        int cnt = 0;
        while(!q.isEmpty()){
            Integer temp = q.poll();
            cnt++;
            for(Integer it:adj.get(temp)){
                indegree[it]--;
                if(indegree[it] ==0){
                    q.add(it);
                }
            }
        }
        return (cnt==n);
    }
}


//use topological sort 
// if we can succesfully create a topo sort
// then we can complete all the courses
//we need to check whether the given grsph is dag(directed acyclic graph) or not
