#include<iostream>
#include<algorithm>

using namespace std;

int main(){
    int n=4;
     int a1[] = {4, 5, 3, 2};
    int a2[] = {2, 10, 1, 4};

    int t1[] = {0, 7, 4, 5};
    int t2[] = {0, 9, 2, 8};

    int e1 = 10, e2 = 12;
    int x1 = 18, x2 = 7;

    int dp1[n], dp2[n];

    dp1[0]=e1+a1[0];
    dp2[0]=e2+a2[0];

    for(int i=1;i<n;i++){
        dp1[i]=min(dp1[i-1]+a1[i],dp2[i-1]+t2[i-1]+a1[i]);
        dp2[i]=min(dp2[i-1]+a2[i],dp1[i-1]+t1[i-1]+a2[i]);
    }

    int ans=min(dp1[n-1]+x1,dp2[n-1]+x2);
    cout<<"Minimum time is : "<<ans<<endl;
}