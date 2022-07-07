class Solution {
public boolean check(String s1,String s2,String s3, int i,int j,Boolean DP[][])
{
                  if(s1.length()==i && s2.length()==j)
                    {
                              return true;
                     }
               if(DP[i][j]!=null)
               {
                return DP[i][j];
                }
              if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j)){
                 boolean ans = check(s1,s2,s3,i+1,j,DP);
                           DP[i][j]=ans;
                             if(ans==true)
                             {
                               return true;
                             }
                          }
       if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j))
       {
                 boolean ans = check(s1,s2,s3,i,j+1,DP);
                                DP[i][j]=ans;
                                     if(ans==true)
                                     {
                                        return true;
                                      }
          }
                     DP[i][j]=false;
                    return false;
                 }
       public boolean isInterleave(String s1, String s2, String s3) 
        {
                int i=0,j=0;
                  if(s1.length()+s2.length()!=s3.length())
                  {
                return false;
                       }
               return check(s1,s2,s3,i,j,new Boolean[s1.length()+1][s2.length()+1] );
         }
}