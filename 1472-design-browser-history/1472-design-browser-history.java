class BrowserHistory {

    DLL head;
    DLL curr;
    public BrowserHistory(String homepage) {
        head = new DLL(homepage);
        curr = head;
    }
    
    public void visit(String url) {
        DLL newNode = new DLL(url);
        newNode.next = null;
        newNode.prev = curr;
        curr.next = newNode;
        curr = curr.next;
    }
    
    public String back(int steps) {
        for (int i = 0; i < steps && curr.prev != null; i++) {
            curr = curr.prev;
        }
        return curr.val;
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps && curr.next != null; i++) {
            curr = curr.next;
        }
        return curr.val;
    }
}

class DLL {
    String val;
    DLL prev;
    DLL next;

    public DLL(String val, DLL prev, DLL next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    public DLL(String val) {
        this.val = val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */