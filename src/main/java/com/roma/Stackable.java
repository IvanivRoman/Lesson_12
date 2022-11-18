package com.roma;

import com.roma.exceptions.EmptyStackException;
import com.roma.exceptions.StackIsFullException;

public interface Stackable {
	boolean isEmpty();

	boolean isFull();

	void push(int element) throws StackIsFullException;

	int pop() throws EmptyStackException;

	int readTop();
}
