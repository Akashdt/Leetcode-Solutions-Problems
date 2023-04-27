//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
public:
    vector<char> easyTask(int n,string s,int q,vector<vector<string>> &queries){
        // Code here
        vector<char> ans;
        
        for(auto q:queries){
            if(q.size() == 3){
               
                int ind = 0;
                for(auto c:q[1]){
                    ind = ind*10 + (c-'0');
                }
               
                s[ind] = q[2][0];
            }
            else{

              


                int ind1 = 0;
                for(auto c:q[1]){
                    ind1 = ind1*10 + (c-'0');
                }
                int ind2 = 0;
                for(auto c:q[2]){
                    ind2 = ind2*10 + (c-'0');
                }
                
                int ind3 = 0;
                for(auto c:q[3]){
                    ind3 = ind3*10 + (c-'0');
                }
                
                vector<int> freq(26, 0);
                
                for(int i = ind1; i<=ind2; i++){
                    freq[s[i]-'a']++;
                }
                
             
                
                for(int i = 25; i>=0; i--){
                    ind3 -= freq[i];
                    if(ind3<=0){
                        ans.push_back((char)('a'+i));
                        break;
                    }
                }
                
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        string s;
        cin>>s;
        int q;
        cin>>q;
        vector<vector<string>> queries(q);
        for(int i=0;i<q;i++){
            string x;
            cin>>x;
            if(x=="1"){
                string p,q;
                cin>>p>>q;
                queries[i]={"1",p,q};
            }
            else{
                string p,q,r;
                cin>>p>>q>>r;
                queries[i]={"2",p,q,r};
            }
        }
        Solution ob;
        vector<char> ans=ob.easyTask(n,s,q,queries);
        for(auto ch:ans){
            cout<<ch<<" ";
        }
        cout<<endl;
    }
}

// } Driver Code Ends