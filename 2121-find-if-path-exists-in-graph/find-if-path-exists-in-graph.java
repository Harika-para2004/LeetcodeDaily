

class Solution {
    
    
    public  void makeGraph(List<List<Integer>> adj,int n,int[][] edges) {
		for(int i=0;i<n;i++)
			adj.add(new ArrayList<Integer>());    
		for(int i=0;i<edges.length;i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}
	}
	
	
	public boolean isValid(List<List<Integer>> adj,int source,int destination,boolean[] vis) {
		if(source==destination) return true;
		vis[source]=true;
		for(int e:adj.get(source)) {
			if(!vis[e] && isValid(adj,e,destination,vis)) 
				return true;
		}
		return false;
	}
    
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
		boolean[] vis=new boolean[n];
		makeGraph(adj,n,edges);
		return isValid(adj,source,destination,vis);
    }
}
