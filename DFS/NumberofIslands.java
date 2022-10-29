package DepthFirstSearch;

public class NumberofIslands {
    public int NumberofIslands(char[][] grid){
        int res = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; i++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j){

        if(i<0 || j<0 || i>grid.length -1 || j > grid[0].length - 1 || grid[i][j] == '#' || grid[i][j] == '0') return;

        grid[i][j] = '#';

        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
    }
}
