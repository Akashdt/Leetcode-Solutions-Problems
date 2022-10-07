class MyCalendarThree {

    TreeMap<Integer, Integer> eventTimes = new TreeMap<>();

    public MyCalendarThree() {
        
    }
    
    public int book(int start, int end) {
        int maxBooking = 0;
        int sum = 0;
        if(eventTimes.containsKey(start) == false){
            eventTimes.put(start, 1);
        }
        else{
            eventTimes.put(start, eventTimes.get(start)+1);
        }

        if(eventTimes.containsKey(end) == false){
            eventTimes.put(end, -1);
        }
        else{
            eventTimes.put(end, eventTimes.get(end)-1);
        }

        for(Map.Entry<Integer, Integer> e : eventTimes.entrySet()){
            sum += e.getValue();
            maxBooking = Math.max(maxBooking, sum);
        }

        return maxBooking;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */