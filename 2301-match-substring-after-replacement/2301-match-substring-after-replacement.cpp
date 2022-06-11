class Solution { 
public: 
    bool matchReplacement(string s, string sub, vector<vector<char>>& maps) { 
        
        map<char,set<char>> mapp;  
        for(auto it : maps)    mapp[it[0]].insert(it[1]); 
         
        vector<string> ans; 
        for(int i = 0 ; i <= s.size()-sub.size(); i++)  ans.push_back(s.substr(i,sub.size())); 
         
        for(auto it : ans) { 
            bool fall = true; 
            int i = 0; 
            
            while(i<sub.size()) { 
                if(sub[i] != it[i]) 
                { 
                    if(mapp[sub[i]].find(it[i]) == mapp[sub[i]].end()) 
                    { 
                        fall = false; 
                        break; 
                    } 
                } 
                i++; 
            } 
            if(fall) return 1; 
        } 
        return false; 
    } 
};