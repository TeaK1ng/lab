import java.util.Scanner;

public class Hipui {

    static class MaxHeap {
        int[] heap;
        int size;

        MaxHeap(int capacity) {
            heap = new int[capacity];
            size = 0;
        }

        void insert(int value) {
            heap[size] = value;
            siftUp(size);
            size++;
        }

        int extractMax() {
            int result = heap[0];
            heap[0] = heap[size - 1];
            size--;
            siftDown(0);
            return result;
        }

        void siftUp(int i) {
            while (i > 0) {
                int parent = (i - 1) / 2;
                if (heap[i] > heap[parent]) {
                    swap(i, parent);
                    i = parent;
                } else {
                    break;
                }
            }
        }

        void siftDown(int i) {
            while (true) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int largest = i;

                if (left < size && heap[left] > heap[largest]) {
                    largest = left;
                }
                if (right < size && heap[right] > heap[largest]) {
                    largest = right;
                }

                if (largest != i) {
                    swap(i, largest);
                    i = largest;
                } else {
                    break;
                }
            }
        }

        void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        MaxHeap heap = new MaxHeap(n);

        for (int i = 0; i < n; i++) {
            int command = scanner.nextInt();
            if (command == 0) {
                int value = scanner.nextInt();
                heap.insert(value);
            } else if (command == 1) {
                System.out.println(heap.extractMax());
            }
        }
    }
}