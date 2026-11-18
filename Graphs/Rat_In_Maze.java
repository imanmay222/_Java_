public class Rat_In_Maze{
    static void printSolution(int sol[][]){
        for(int i=0;i<sol.length;i++){
            for(int j=0;j<sol.length;j++){
                System.out.print(sol[i][j]+" ");
            }System.out.println();
        }
    }
    public static boolean dfs(int graph[][],int n,boolean vis[][],int row,int col,int sol[][]){
        if(row<0 || col<0 || row>=n || col>=n || vis[row][col] || graph[row][col]==0){
            return false;
        }

        vis[row][col]=true;
        sol[row][col]=1;
        //check the condition for desti
        if(row==n-1 && col==n-1){
            //print the soltuion matrix and return true
            printSolution(sol);
            return true;
        }

        //visit other vertex 
        if(dfs(graph, n, vis, row+1, col, sol)){
            return true;
        } //down
        if(dfs(graph, n, vis, row, col+1, sol)){
            return true;
        } //move right
        if(dfs(graph, n, vis, row-1, col, sol)){
            return true;
        } //up
        if(dfs(graph, n, vis, row, col-1, sol)){
            return true;
        }

        vis[row][col]=false;
        sol[row][col]=0;
        return false; // no solution exists.

    }
    public static void main(String args[]){
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        int n = maze.length;

        int sol[][]={
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
        };
        System.out.println(dfs(maze,n,new boolean[n][n],0,0,sol));

    

    }
}