//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    int checkCompressed(string S, string T) {
      int i = 0;
        int j = 0;
    
        while(i<S.size() and j < T.size()){
            
            if(S[i]==T[j]){
                
                i++;
                j++;
            }
            else if(T[j]>='0' and T[j]<='9'){
               
             int p = j;
             string s;
               while(T[j]>='0' and T[j]<='9'){
                   
                   s.push_back(T[j]);
                   j++;
               }
               int num = stoi(s);
               
               i = i+num;
              

                
            }
            else if(S[i]!=T[j]){
              
                return 0;
            }
            
        }
        
        if(i==S.size() and j==T.size())return 1;
        return 0;
         
         
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        string S,T;
        
        cin>>S>>T;

        Solution ob;
        cout << ob.checkCompressed(S,T) << endl;
    }
    return 0;
}
// } Driver Code Ends