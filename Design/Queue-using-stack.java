import java.util.Stack;

class Queue {
    Stack<Integer> input = new Stack<Integer>();
    Stack<Integer> output = new Stack<Integer>();

    /*The method pop which return the element poped out of the stack*/
    int dequeue() {
        if (output.isEmpty() && input.isEmpty()) {
            return -1;
        } else if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    /* The method push to push element into the stack */
    void enqueue(int x) {
        input.push(x);
    }
}
