import java.util.Arrays;

public class ArrayStack implements Stack {
    private Object[] arr;
    private int top;

    ArrayStack() {
        top = -1;
        arr = new Object[10];
    }

    @Override
    public void push(Object item) {
        if (top == arr.length) {
            resize();
        }
        arr[++top] = item;
    }

    @Override
    public Object pop() {
        if (!empty()) {
            return arr[top--];
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Object peek() {
       if (!empty()) {
           return arr[top];
       }
       throw new IllegalArgumentException();
    }

    @Override
    public boolean empty() {
        return top == -1;
    }

    private void resize() {
        Object[] newarr = new Object[arr.length*2];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        arr = newarr;
    }
}
