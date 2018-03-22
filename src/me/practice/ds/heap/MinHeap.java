package me.practice.ds.heap;

public class MinHeap {

	final int capacity;
	int heapSize;
	final int[] harr; 
	
	public MinHeap(int capacity) {
		if(capacity > 10000)
			throw new IllegalArgumentException("capacity more than 10000 is not allowed.");
		this.capacity = capacity;
		harr = new int[this.capacity];
	}
	
	public boolean add(int data) {
		boolean flag = false;
		if(heapSize < capacity) {
			this.harr[heapSize-1] = data;
			heapSize++;
			flag = true;
		}
		return flag;
	}
	
	public int capacity() {
		return this.capacity;
	}
	
	public int heapSize() {
		return this.heapSize;
	}
	
	private final int parent(int index) {
		return (index-1)/2;
	}
	
	private final boolean hasParent(int index) {
		return this.parent(index) > 0;
	}
	
	private final int left(int index) {
		return (index*2) + 1;
	}
	
	private final int right(int index) {
		return (index*2) + 2;
	}
	
	private final void swap(int i, int j) {
		if (i < heapSize && j < heapSize) {
			harr[i] = harr[i] + harr[j];
			harr[i] = harr[i] - harr[j];
			harr[j] = harr[i] - harr[j];
		} else 
			throw new IllegalArgumentException("");
	}
	
	private final void minHeapifyUp(int index) {
		while(this.hasParent(index)) {
			if(this.harr[index] < this.harr[this.parent(index)]) {
				swap(index, this.parent(index));
			}
		}
	}
	
	private final void minHeapify(int index) {
		int left = left(index);
		int right = right(index);
		int smallest = index;
		if(left < heapSize && harr[left] < harr[smallest])
			smallest = left;
		if(right < heapSize && harr[right] < harr[smallest])
			smallest = left;
		
		if(smallest != index) {
			swap(harr[index], harr[smallest]);
			minHeapify(smallest);
		}
	}
}