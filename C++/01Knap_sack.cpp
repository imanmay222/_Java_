#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main(){
    int val[] = {1, 4, 5, 7};
    int wt[] = {1, 3, 4, 5};
    int W = 7;

    int n=4;

    vector<vector<int>> dp(n+1,vector<int>(W+1,-1));

    //fill the row and col by 0.
    for(int i=0;i<n+1;i++){
        dp[i][0]=0;
    }

    for(int i=0;i<n+1;i++){
        dp[0][i]=0;
    }

    for(int i=1;i<=n;i++){
        for(int j=1;j<=W;j++){
            int v=val[i-1];
            int w=wt[i-1];
            if(w<=j){
                int inc=v+dp[i-1][j-w];
                int exc=dp[i-1][j];

                dp[i][j]=max(inc,exc);
            }else{
                dp[i][j]=dp[i-1][j];
            }
        }
    }

    cout<<"Maximum profit is : "<<dp[n][W]<<endl;

    cout<<""<<endl;

}