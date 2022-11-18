package com.roma.exceptions;

public class EmptyStackException extends Exception {
	public EmptyStackException() {
		super("Stack is empty");
	}
}
