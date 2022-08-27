class Solution
{
    public:

        int maxSumSubarray(vector<int> &arr, int k)
        {
            int n = arr.size();
            set<int> st;
            st.insert(0);
            int currSum = 0, maxSum = INT_MIN;

            for (int i = 0; i < n; i++)
            {
                currSum += arr[i];
                auto it = st.lower_bound(currSum - k);
                if (it != st.end())
                {
                    maxSum = max(maxSum, currSum - *it);
                }

                st.insert(currSum);
            }

            return maxSum;
        }
    int maxSumSubmatrix(vector<vector < int>> &matrix, int k)
    {
        int n = matrix.size();
        int m = matrix[0].size();

        int maxSum = INT_MIN;
        for (int row = 0; row < n; row++)
        {
            vector<int> col(m, 0);
            for (int i = row; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    col[j] += matrix[i][j];
                }
                maxSum = max(maxSum, maxSumSubarray(col, k));
            }
        }
        return maxSum;
    }
};