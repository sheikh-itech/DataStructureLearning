package ds.arrays.other;

public class CircularArray {

	private int[] data;
	private int head, tail, size, capacity;
	
	public CircularArray(int k) {
        capacity = k;
        data = new int[k];
        head = -1;
        tail = -1;
        size = 0;
    }
	
	
	public static void main(String[] args) {

		CircularArray array = new CircularArray(10);
		
		array.enqueue(5);
		array.enqueue(7);
		array.enqueue(9);
		array.enqueue(2);
		array.enqueue(1);
		array.enqueue(8);
		array.enqueue(5);
		array.enqueue(3);
		
		array.print();
		
		System.out.println();
		
		array.dequeue();
		array.dequeue();
		array.dequeue();
		
		array.print();
	}
	
	private void print() {
		
		for(int o:data)
			System.out.print(o+", ");
	}
	
	public boolean enqueue(int value) {
		
        if (size == capacity) return false; // Array/Queue full
        if (size == 0) head = 0;
        tail = (tail + 1) % capacity; // Wrap around
        data[tail] = value;
        size++;
        return true;
    }

    public int dequeue() {
    	
        if (size == 0) return -1; // Array/Queue empty
        int result = data[head];
        head = (head + 1) % capacity; // Move head forward
        size--;
        return result;
    }
}
