class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
          Arrays.sort(products);

         List<List<String>> answer= new ArrayList<>();
        for(int i=0;i<searchWord.length();i++)
        {
            String s = searchWord.substring(0,i+1);
            int count = 0;
            List<String> l = new ArrayList<String>();
            for(int j=0;j<products.length;j++)
            {
                if(products[j].length()>=i+1)
            {
                if((products[j].substring(0,i+1)).equals(s))
                {
                   
                    l.add(products[j]);
                    count++;
                }
            }
                if(count==3)
                    break;
            }
           
            answer.add(l);
            
        }
        return answer;
    }
}