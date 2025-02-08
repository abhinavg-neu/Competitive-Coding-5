class Solution {
    int n,m;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
       List<List<Integer>> res = new ArrayList<>();
      int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        n = heights.length;
        m = heights[0].length;
      for (int i = 0; i < n ;i++){
      for (int j = 0; j < m ;j++){
        if (dfsA (heights,new boolean[heights.length][heights[0].length], i, j ) && dfsP (heights,new boolean[heights.length][heights[0].length] ,i, j )){
            res.add (new ArrayList<>(Arrays.asList(i,j)));
        }
        } 
      } 
    return res;
    }

    private boolean dfsP (int [][]heights, boolean[][] visited ,int i, int j){
        // base case
        if ( i < 0 || i == n || j < 0 || j == m || visited[i][j]){
            return false;
        }
        if ( i == 0 || j ==0)
        return true;
        // logivoc
        visited[i][j] = true;
        boolean u = false,d = false,l = false,r = false;
               if(i+1 < n && heights[i+1][j] <= heights[i][j]) u = dfsP(heights, visited, i+1, j);
        if(i-1 >= 0 && heights[i-1][j] <= heights[i][j]) d = dfsP(heights, visited, i-1, j);
        if(j+1 < m && heights[i][j+1] <= heights[i][j]) l = dfsP(heights, visited, i, j+1);
        if(j-1 >= 0 && heights[i][j-1] <= heights[i][j]) r=  dfsP(heights, visited, i, j-1);
        return u || l || d || r;
    }
     private boolean dfsA (int [][]heights, boolean[][] visited ,int i, int j ){
        // base case
        if ( i < 0 || i == n || j < 0 || j == m || visited[i][j]){
            return false;
        }
        if ( i == n-1 || j ==m-1)
        return true;
        // logic
        visited[i][j] = true;
        boolean u = false,d = false,l = false,r = false;
               if(i+1 < n && heights[i+1][j] <= heights[i][j]) u = dfsA(heights, visited, i+1, j);
        if(i-1 >= 0 && heights[i-1][j] <= heights[i][j]) d = dfsA(heights, visited, i-1, j);
        if(j+1 < m && heights[i][j+1] <= heights[i][j]) l = dfsA(heights, visited, i, j+1);
        if(j-1 >= 0 && heights[i][j-1] <= heights[i][j]) r=  dfsA(heights, visited, i, j-1);
        return u || l || d || r;
    }
}
