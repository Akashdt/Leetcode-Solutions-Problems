class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        int i=0;
        for(;i<intervals.length;i++){
            int[] arr=intervals[i];
            if(arr[0]>=newInterval[0]) break;
            list.add(new ArrayList<>(Arrays.asList(arr[0],arr[1])));
        }
        list.add(new ArrayList<>(Arrays.asList(newInterval[0],newInterval[1])));
        for(;i<intervals.length;i++){
            int[] arr=intervals[i];
            list.add(new ArrayList<>(Arrays.asList(arr[0],arr[1])));
        }
        Set<Integer> notCount=new HashSet<>();
        int j=1,c=0;
        for(i=0;i<list.size()-1;i++){
            if(list.get(i).get(1)>=list.get(j).get(0)){
                list.get(j).set(0,list.get(i).get(0));
                list.get(j).set(1,Math.max(list.get(i).get(1),list.get(j).get(1)));
                notCount.add(i);c++;
            }j++;
        }
        int[][] ans=new int[list.size()-c][2];
        i=0;j=0;
        for(;i<list.size();i++){
            if(notCount.contains(i)) continue;
            ans[j++]=new int[]{list.get(i).get(0),list.get(i).get(1)};
        }
        return ans;
    }
}