package com.infosys.learning.collections;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueDS<T> {

	Stack<T> pushStack;
	Stack<T> popStack;

	public QueueDS() {
		pushStack = new Stack<>();
		popStack = new Stack<>();
	}

	public void enqueue(T i) {
		pushStack.push(i);
	}

	public void dequeue() {
		if (popStack.isEmpty()) {
			copy();
		}
		popStack.pop();
	}

	public T peek() {
		if (popStack.isEmpty()) {
			copy();
		}
		/*
		 * if(popStack.size() == 0) throw new NoSuchElementException();
		 */
		return popStack.peek();
	}

	private void copy() {
		while (!pushStack.isEmpty()) {
			popStack.push(pushStack.pop());
		}
	}

	public String toString() {
		return popStack.toString();
	}

	public static void main(String[] args) {

		QueueDS<Integer> queue = new QueueDS<>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		System.out.println(queue.peek());
		queue.dequeue();
		System.out.println(queue.toString());

		QueueDS<String> strQueue = new QueueDS<>();
		strQueue.enqueue("A");
		strQueue.enqueue("B");
		strQueue.enqueue("C");
		strQueue.dequeue();
		System.out.println(strQueue.toString());
	}
}
