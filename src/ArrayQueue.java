public class ArrayQueue implements Queue {
    private int head = 0;
    private int tail = 0;
    private Object[] arr = new Object[10];

    @Override
    public void enqueue(Object item) {
        if (tail+1 != head) {
            arr[tail++] = item;
            if (tail >= arr.length) {
                tail = 0;
            }
        } else {
            double_array_size(arr);
        }
    }

    @Override
    public Object dequeue() {
        if (head == tail) {
            return arr[head++];
        }
    }

    @Override
    public boolean empty() {
        return arr.length == 0;
    }

    private void double_array_size() {
        Object[] temp = new Object[2*arr.length];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
    }
}
