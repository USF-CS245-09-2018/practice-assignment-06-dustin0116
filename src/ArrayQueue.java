public class ArrayQueue implements Queue {
    private int head;
    private int tail;
    private Object[] arr;

    ArrayQueue() {
        head = 0;
        tail = 0;
        arr = new Object[10];
    }

    @Override
    public void enqueue(Object item) {
        try{
            not_false(tail+1 != head);
        } catch (Exception e) {
            resize();
        }
        arr[tail++] = item;
        tail = tail%arr.length;
    }

    @Override
    public Object dequeue() {
        Object item = arr[head++];
        if (head == arr.length) {
            head = 0;
        }
        return item;
    }

    @Override
    public boolean empty() {
        return head == tail;
    }

    private void resize() {
        int size = arr.length;
        Object[] newArr = new Object[arr.length*2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[head++%arr.length];
        }
        arr = newArr;
        head = 1;
        tail = size;
    }

    private static void not_false(boolean expression) {
        if(!expression) {
            throw new IllegalArgumentException();
        }
    }
}