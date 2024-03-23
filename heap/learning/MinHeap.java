public class Solution {

    static class MinHeap {

        // Member variables for the class.
        int[] heap; // Array to store the heap elements
        int size;   // Current size of the heap
        int capacity; // Maximum capacity of the heap

        // Constructor for the class.
        MinHeap(int capacity){
            this.capacity = capacity;
            this.size = 0;
            this.heap = new int[this.capacity];
        }

        // Helper method to find the index of the parent node of a given node.
        int parent(int i){
            return (i-1)/2;
        }

        // Helper method to find the index of the left child of a given node.
        int leftChild(int i){
            return 2*i+1;
        }

        // Helper method to find the index of the right child of a given node.
        int rightChild(int i){
            return 2*i+2;
        }

        // Helper method to swap two elements in the heap.
        void swap(int a, int b){
            int t = heap[a];
            heap[a] = heap[b];
            heap[b] = t;
        }

        // Method to remove minimum element from the heap.
        int extractMinElement() {
            if(size <= 0){
                return -1; // If heap is empty, return -1
            }
            int val = heap[0]; // Store the minimum element

            heap[0] = heap[size-1]; // Replace the root with the last element
            size--;

            heapify(0); // Adjust the heap to maintain heap property

            return val; // Return the minimum element
        }

        // Helper method to adjust the heap from a given index downwards to maintain heap property.
        void heapify(int i){
            int n = size;
            while(i < n){
                int left = leftChild(i);
                int right = rightChild(i);
                int smallest = i;

                // Find the smallest among the current node, its left child, and its right child
                if(left < n && heap[left] < heap[smallest]){
                    smallest = left;
                }
                if(right < n && heap[right] < heap[smallest]){
                    smallest = right;
                }

                if(smallest != i){ // If the smallest element is not the current node
                    swap(smallest, i); // Swap the smallest element with the current node
                    i = smallest; // Update the index for further heapify process
                } else {
                    return; // If the current node is the smallest, stop heapify process
                }
            }
        }

        // Method to delete an element at a given index from the heap.
        void deleteElement(int ind) {
            if (ind < 0 || ind >= size || size <= 0) {
                return; // Invalid index or empty heap, return
            }

            heap[ind] = heap[size-1]; // Replace the element to delete with the last element
            size--;

            heapify(ind); // Adjust the heap to maintain heap property
        }

        // Helper method to adjust the heap from a given index upwards to maintain heap property.
        void heapifyUp(int i){
            while (i > 0) {
                // If parent is greater than the current node
                if(heap[parent(i)] > heap[i]){
                    swap(i, parent(i)); // Swap the current node with its parent
                }
                i = parent(i); // Move to the parent index for further heapifyUp process
            }
        }

        // Method to insert a value into the heap.
        void insert(int val) {
            if(size == capacity){
                return; // Heap is full, return
            }

            heap[size++] = val; // Insert the value at the end of the heap
            heapifyUp(size-1); // Adjust the heap to maintain heap property
        }
    }
};
