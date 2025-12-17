package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (!Queue.isFull) {
			array[++tail] = element;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T result = array[0];
		
		if (!Queue.isEmpty) {

			for (int i = 0; i < tail; i++) {
				array[i] = array[i+1];
			}

			tail--;
		}

		return result;
	}

	@Override
	public T head() {
		return this.array.tail;
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
	}

	@Override
	public boolean isFull() {
		return tail == array.length - 1;
	}

}
