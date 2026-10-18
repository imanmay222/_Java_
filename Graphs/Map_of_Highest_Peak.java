class Solution {

    //concept is same as 01 Matrix. 
    class Info{
        int row,col,step;
        public Info(int row,int col,int step){
            this.row=row;
            this.col=col;
            this.step=step;
        }
    }
    public int[][] highestPeak(int[][] isWater) {
        //Question is similar to 01 matrix. 
        Queue<Info> q1=new LinkedList<>();
        for(int i=0;i<isWater.length;i++){
            for(int j=0;j<isWater[0].length;j++){
                if(isWater[i][j]==1){
                    q1.add(new Info(i,j,0));
                }
            }
        }

        boolean vis[][]=new boolean[isWater.length][isWater[0].length];
        int dist[][]=new int[isWater.length][isWater[0].length];

        //perform BFS
        while(!q1.isEmpty()){
            Info curr=q1.remove();
            if(!vis[curr.row][curr.col]){
                vis[curr.row][curr.col]=true;
                dist[curr.row][curr.col]=curr.step;
                //continue and traverse the neighbours.
                int dirR[]={-1,1,0,0};
                int dirC[]={0,0,-1,1};

                for(int i=0;i<4;i++){
                    int nrow=curr.row+dirR[i];
                    int ncol=curr.col+dirC[i];
                    //if it's a valid row and col then only add else continue to the next iteration.
                    if(nrow<0 || ncol<0 || nrow>=isWater.length || ncol>=isWater[0].length){
                        continue;
                    }
                    q1.add(new Info(nrow,ncol,curr.step+1));
                }
            }
        }return dist;
    }
}