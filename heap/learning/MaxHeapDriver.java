
class MaxHeap{
    int[] heap;
    int size;
    int capacity;

    MaxHeap(int capacity){
        this.capacity=capacity;
        this.size=0;
        this.heap=new int[this.capacity];
    }

    int parent(int i){
        return (i-1)/2;
    }
    int leftChild(int i){
        return 2*i+1;
    }
    int rightChild(int i){
        return 2*i+2;
    }
    void swap(int a, int b){
        int t=heap[a];
        heap[a]=heap[b];
        heap[b]=t;
    }

    void heapifyUp(int i){
        while (i > 0) {
            //if parent is smaller than child
            //swap child with parent to match heap property
            if(heap[parent(i)] < heap[i]){
                swap(i, parent(i));
            }
            i = parent(i);
        }
    }
    void heapifyDown(int i) {
        while (i < this.size) {
            int left = leftChild(i);
            int right = rightChild(i);
            int max = i;
    
            if (left < this.size && this.heap[left] > this.heap[max]) {
                max = left;
            }
    
            if (right < this.size && this.heap[right] > this.heap[max]) {
                max = right;
            }
    
            if (max != i) {
                swap(i, max);
                i = max;
            } else {
                return;
            }
        }
    }    

    void insert(int val){
        if(this.size==this.capacity){
            System.out.println("Full");
            return;
        }
        this.heap[this.size++]=val;
        heapifyUp(this.size-1);

    }

    int getMax(){
        if(this.size==0){
            System.out.println("Empty!");
            return Integer.MAX_VALUE;
        }

        int val=this.heap[0];

        //step 1: put last element in first element
        this.heap[0]=this.heap[this.size-1];
        //step 2: delete last node
        this.size--;
        //step 3: heapify down(place root at its correct position)
        heapifyDown(0);

        return val;
    }

    void display(){
        for(int i=0; i<this.size; i++){
            System.out.print(this.heap[i]+" ");
        }
    }
}

public class MaxHeapDriver{
    public static void main(String[] args) {
        MaxHeap mh=new MaxHeap(5);

        mh.insert(50);
        mh.insert(55);
        mh.insert(53);
        mh.insert(52);
        mh.insert(54);

        mh.display();

        System.out.println("\nMax: "+mh.getMax());
        System.out.println("Max: "+mh.getMax());
        System.out.println("Max: "+mh.getMax());
        System.out.println("Max: "+mh.getMax());
        System.out.println("Max: "+mh.getMax());
        System.out.println("Max: "+mh.getMax());

    }
}