class MyCalendar 
{
TreeSet<int[]> ts = new TreeSet<>((a, b) -> Integer.compare(a[0], b[0]));
    
    public boolean book(int start, int end) 
    {
        int[] i = new int[]{start, end - 1};
        int[] f = ts.floor(i);
        int[] c = ts.ceiling(i);
            
        if (f != null && f[1] >= start) 
                
                return false;
            
        if (c != null && c[0] <= end - 1) 
                
                return false;
       
            ts.add(i);
        return true;
}
}
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */