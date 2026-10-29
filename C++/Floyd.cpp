#include<iostream>
#include<climits>
#include<vector>
#include<algorithm>

using namespace std;

const long long INF=1LL<<60;

void algo(int V,vector<vector<long long>> dist){
    for(int k=0;k<V;k++){
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(dist[i][k]==INF || dist[k][j]==INF){
                    continue;
                }

                dist[i][j]=min(dist[i][j],dist[i][k]+dist[k][j]);
            }
        }
    }
}

int main(){
    int V,E;
    cout<<"Enter V & E : ";
    cin>>V>>E;

    vector<vector<long long>> dist(V,vector<long long>(V,INF));

    for(int i=0;i<V;i++){
        dist[i][i]=0;
    }

    for(int i=0;i<E;i++){
        int u,v,w;
        cout<<"Enter values : ";
        cin>>u>>v>>w;
        dist[u][v]=min(dist[u][v],(long long)w);
    }

    algo(V,dist);

    //print the distances : 
    for(int i=0;i<V;i++){
        for(int j=0;j<V;j++){
            if(dist[i][j]==INF){
                cout<<" INF ";
            }else{
                cout<<dist[i][j];
            }
        }
        cout<<endl;
    }


}