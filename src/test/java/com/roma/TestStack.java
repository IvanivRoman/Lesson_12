package com.roma;

import org.junit.jupiter.api.Test;

import com.roma.exceptions.EmptyStackException;
import com.roma.exceptions.StackIsFullException;

import static org.assertj.core.api.Assertions.*;

import java.util.NoSuchElementException;

public class TestStack {

	@Test
	void shouldThrowExceptionIfPopEmptyStack() {
		final Stack stack = new Stack(3);
		Throwable thrown = catchThrowable(() -> stack.pop());
		assertThat(thrown).isInstanceOf(EmptyStackException.class);
	}

	@Test
	void shouldThrowExceptionAddElementToFullStack() throws StackIsFullException {
		Stack stack = new Stack(3);
		stack.push(42);
		stack.push(43);
		stack.push(-51);
		Throwable thrown = catchThrowable(() -> stack.push(-50));
		assertThat(thrown).isInstanceOf(StackIsFullException.class);
	}

	@Test
	void shouldReturnElementIfPopOptionalNotEmpty() throws StackIsFullException {
		Stack stack = new Stack(3);
		stack.push(1);
		stack.push(2);
		assertThat(stack.popOptional().get()).isEqualTo(2);
	}

	@Test
	void shouldThrowExceptionIfPopOptionalIsEmpty() {
		Stack stack = new Stack(3);
		Exception ex = catchException(() -> stack.popOptional());
		assertThat(ex).isInstanceOf(ArrayIndexOutOfBoundsException.class);
	}

}
