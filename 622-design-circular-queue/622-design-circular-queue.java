class MyCircularQueue {
    int[] queue;
    int head;
    int tail;
    int n;
    public MyCircularQueue(int k) {
        queue = new int[k];
        head = -1;
        tail = -1;
        n = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        if(head == -1) head = 0;
        tail = (tail + 1) % n;
        queue[tail] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        if(head == tail) {
            head = -1;
            tail = -1;
        }
        else head = (head + 1) % n;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : queue[head];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : queue[tail];
    }
    
    public boolean isEmpty() {
        return head == -1;
    }
    
    public boolean isFull() {
        return tail == head - 1 || (tail == n - 1 && head == 0);
    }
}