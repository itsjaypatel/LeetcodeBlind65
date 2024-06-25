package heap;

import java.util.StringJoiner;

public interface Heap {

    public int size();
    public boolean isEmpty();
    public void insert(int value);
    public int remove();
}

class Main{
    public static void main(String[] args) {
        Heap heap = new MinHeap(new int[]{0,1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17});
//        for(int i = 10; i > 0; i--){
//            heap.insert(i);
//            System.out.println(heap);
//        }

        for(int i = 10; i >= 0; i--){
            int top = heap.remove();
            System.out.println("Top element is  ::  "+ top);
            System.out.println(heap);
        }
    }
}

class MinHeap implements Heap {

    private final int DEFAULT_CAPACITY;
    private int pointer;
    private int[] arr;

    public MinHeap() {
        DEFAULT_CAPACITY = 1000;
        this.arr = new int[DEFAULT_CAPACITY + 1];
        this.pointer = 0;
    }

    public MinHeap(int[] arr) {
        DEFAULT_CAPACITY = arr.length - 1;
        this.arr = arr;
        this.pointer = arr.length - 1;
        buildHeap();
    }

    private void goToNextIndex()
    {
        ++this.pointer;
    }

    private void goToPreviousIndex()
    {
        --this.pointer;
    }
    @Override
    public int size() {
        return pointer;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void insert(int value) {
        if(size() == DEFAULT_CAPACITY) {
            throw new RuntimeException("Heap is full");
        }
        goToNextIndex();
        int curr = size();
        arr[curr] = value;

        while(curr > 1 && arr[curr/2] > arr[curr]) {
            swap(curr, curr/2);
            curr = curr/2;
        }
    }

    @Override
    public int remove() {
        if(size() == 0) {
            throw new RuntimeException("Heap is empty");
        }
        int top = arr[1];
        arr[1] = arr[pointer];
        goToPreviousIndex();

        int curr = 1;
        while(true){
            int smallest = curr;
            int leftChild = 2*curr;
            int rightChild = 2*curr+ 1;
            if(leftChild <= size() &&  arr[leftChild] < arr[smallest]) {
                smallest = leftChild;
            }
            if(rightChild <= size() &&  arr[rightChild] < arr[smallest]) {
                smallest = rightChild;
            }

            if(smallest != curr) {
                swap(smallest, curr);
                curr = smallest;
            }else{
                break;
            }
        }
        return top;
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for(int i = 1; i <= size(); i++) {
            sj.add(arr[i] + "");
        }
        return sj.toString();
    }

    public void buildHeap(){
        int nonLeafIndex = size()/2;
        for(int i = nonLeafIndex; i > 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int curr) {
        int leftChild = 2*curr;
        int rightChild = 2*curr+1;

        int smallest = curr;
        if(leftChild <= size() &&  arr[leftChild] < arr[smallest]) {
            smallest = leftChild;
        }
        if(rightChild <= size() &&  arr[rightChild] < arr[smallest]) {
            smallest = rightChild;
        }

        if(smallest != curr) {
            heapify(smallest);
        }
    }
}
