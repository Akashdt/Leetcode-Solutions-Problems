//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
    long long int MissingNo(vector<vector<int> >& matrix) {
      map<long long int ,long long int>um;
        int n = matrix.size();
        int row_0 = 0;
        int col_0 = 0;
        for(int i=0;i<n;++i){
            long long int pre_sum = 0;
            int found = 0;
            for(int j=0;j<n;++j){
                if(matrix[i][j]==0){
                    found = 1;
                    row_0 = i;
                    col_0 = j;
                    break;
                }
                pre_sum  = pre_sum + matrix[i][j];
            }
            if(found == 0){
                ++um[pre_sum];
            }
        }
        if(um.size()>1){
            return -1;
        }
        
        long long int sum = 0;
        for(auto it:um){
            sum = it.first;
        }
        
        long long int sum_0 = 0;
        for(int i=0;i<n;++i){
            sum_0 = sum_0 + matrix[row_0][i];
        }
        
        long long int ele = sum-sum_0;
        //cout<<ele<<endl;
        if(ele <= 0){
            return -1;
        }
        matrix[row_0][col_0]=ele;
        
        for(int i=0;i<n;++i){
            long long int pre_sum = 0;
            for(int j=0;j<n;++j){
                if(j==row_0 && i==col_0){
                    pre_sum = pre_sum + ele;
                    continue;
                }
                pre_sum  = pre_sum + matrix[j][i];
            }
            ++um[pre_sum];
        }
        if(um.size()>1){
            return -1;
        }
        long long int pre_sum_d1 = 0;
        
        for(int i=0;i<n;++i){
            if(i==row_0 && i== col_0){
                pre_sum_d1 = pre_sum_d1 + ele;
                continue;
            }
            pre_sum_d1 = pre_sum_d1 + matrix[i][i];
        }
        ++um[pre_sum_d1];
        
        long long int pre_sum_d2 = 0;
        
        for(int i=0;i<n;++i){
            if(i == row_0 && n-i-1 == col_0){
                pre_sum_d2 = pre_sum_d2 + ele;
                continue;
            }
            pre_sum_d2 = pre_sum_d2 + matrix[i][n-i-1];
        }
        ++um[pre_sum_d2];
        
        if(um.size()>1){
            return -1;
        }
        return ele;
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<vector<int>> matrix(n, vector<int>(n,0));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				cin >> matrix[i][j];
			}
		}
		Solution ob;
		long long int ans = ob.MissingNo(matrix);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends