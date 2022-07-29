class Solution {
public:
         
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        vector<string> ans;
            
        string patternCode = generateCode(pattern);
        for(auto i: words)
        {
            string res = generateCode(i);
            if(patternCode == res) 
                    
                    ans.push_back(i);
        }
        
        return ans;
 }
    
        string generateCode(string &s)
        {
        unordered_map<char,int> Map;
                
        string code = "";
                
        for(int i=0;i<s.size();i++)
        {
            if(Map.find(s[i]) == Map.end())
            {
                Map[s[i]] = i;
                code.push_back(i);
            }
                
            else code.push_back(Map[s[i]]);
        }
        
        return code;
    }
   
    
};