class Solution {
    public String convert(String s, int numRows) {
         String []lines=new String[numRows];
            
		for (int i=0;i<numRows;i++){
			lines[i]="";
		}
		char []a=s.toCharArray();
		int d=-1;
		int row=0;
		for (int i=0;i<a.length;i++){
			lines[row]+=a[i];
			if(row==0 || row==numRows-1)
				d*=-1;
			row+=d;
			row%=numRows;
		}
			
		String res="";
		for (String line : lines)
                        
			res+=line;
		return res;
    }
}