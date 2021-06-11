class Queues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    //Function to push an element into stack using two queues.
    void push(int a) {
        q1.add(a);
    }

    //Function to pop an element from stack using two queues.
    int pop() {
        if (q1.size() == 0) return -1;
        int size = q1.size() - 1;
        while (size-- > 0) {
            q2.add(q1.remove());
        }
        int ans = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return ans;
    }

}
