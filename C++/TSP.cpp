#include<iostream>
#include<algorithm>
#include<climits>
#include<cstring>

using namespace std;

int dp[10][1<<10];
int cost[10][10];
int visited[10];
int n;
int ans=80;
int tsp(int city,int count){
    if(count==n){
        return cost[city][0];
    }

    if(dp[city][count]!=-1){
        return dp[city][count];
    }

    int ans=INT_MAX;
    for(int next=0;next<n;next++){
        if(!visited[next]){
            visited[next]=1;
            ans=min(ans,cost[city][next]+tsp(next,count+1));
            visited[next]=0;
        }
    } return dp[city][count]=ans;
}

int main(){
    n = 4;
    int c[4][4] = {
        {0, 10, 15, 20},
        {10, 0, 35, 25},
        {15, 35, 0, 30},
        {20, 25, 30, 0}
    };
    visited[0]=1;
    // copy to cost;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            cost[i][j] = c[i][j];

    tsp(0,1);

    //init dp
    memset(dp,-1,sizeof(dp));
    cout<<ans;

}