class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] tracker = new boolean[rooms.size()];
        tracker[0] = true;

        for(int e:rooms.get(0)){
            q.offer(e);
            tracker[e] = true;
        }

        while(!q.isEmpty()){
            Integer temp = q.poll();
            for(int e:rooms.get(temp)){
                if(tracker[e] == false){
                    q.offer(e);
                    tracker[e]=true;
                } 
            }
        }
        
        for(int i =0;i<tracker.length;i++) {
        	if(tracker[i] == false) {
        		return false;
        	}
        }
        
		return true;
    }
}