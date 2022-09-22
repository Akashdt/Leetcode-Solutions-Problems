class Solution {
    public String reverseWords(String s) 
    {
        
          String[] arr = s.split(" ");
          String str = "";
          for (String string : arr)
          {
         
                  str += new StringBuilder(string).reverse() + " ";
          }
          return str.trim(); 
    }
}