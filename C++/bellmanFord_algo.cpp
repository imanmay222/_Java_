#include<iostream>
#include<climits>
#include<algorithm>
#include<vector>
using namespace std;

struct Edge{
    int src,dest,wt;
};



void bellman(int V,vector<Edge> &edge,int src){

    //initialize soruce distance with 0;

    
    vector<long long> dist(V,LLONG_MAX/4);
    dist[src]=0;
    for(int i=0;i<V-1;i++){
        for(int j=0;j<edge.size();j++){
            Edge e=edge[j];

            int u=e.src;
            int v=e.dest;
            int wt=e.wt;


            //check for the relaxation

            if(dist[u]!=LLONG_MAX/4 && dist[u]+wt<dist[v]){
                dist[v]=dist[u]+wt;
            }
        }
    }


    //print the distance

    for(int i=0;i<dist.size();i++){
        cout<<"Distance from src to i : "<<dist[i]<<endl;
    }
}


int main(){
    int V,E;
    cout<<"Enter V E : "<<endl;
    cin>>V>>E;

    vector<Edge> edge(E);

    for(int i=0;i<E;i++){
        cout<<"Enter the values : "<<endl;
        int u,v,wt;
        cin>>u>>v>>wt;
        edge.push_back({u,v,wt});
    }

    int src;
    cout<<"Enter the src : "<<endl;
    cin>>src;

    bellman(V,edge,src);
}