package com.roma;

import java.util.NoSuchElementException;
import java.util.Optional;

import com.roma.exceptions.EmptyStackException;
import com.roma.exceptions.StackIsFullException;

public class Stack implements Stackable {

	private int[] stack;
	private int top;
	private int capacity;

	Stack(int size) {
		stack = new int[size];
		capacity = size;
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == capacity - 1;
	}

	public void push(int element) throws StackIsFullException {
		if (isFull()) {
			System.err.println("Stack Overflow");
			throw new StackIsFullException();
		}

		stack[++top] = element;
	}

	public int pop() throws EmptyStackException {
		if (isEmpty()) {
			System.err.println("Stack is empty");
			throw new EmptyStackException();
		}

		return stack[top--];
	}

	public Optional<Integer> popOptional() {
		return Optional.ofNullable(stack[top--]);
	}

	public int readTop() {
		return stack[top];
	}

	public int getSize() {
		return top + 1;
	}

	public void printStack() {
		for (int i : stack) {
			System.out.print(i + ", ");
		}
	}
}
