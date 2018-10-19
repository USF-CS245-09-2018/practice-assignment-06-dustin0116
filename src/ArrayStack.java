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
        if (top == arr.length-1) {
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
        Object[] newArr = new Object[arr.length*2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }
}
