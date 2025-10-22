package utilExceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * This JUnit Testcase tests all methods of the Stack interface with exceptions
 * 
 * @author Jeroen Wauters
 * 
 */
public class StackTest {

	private StackIntfWithExceptions<String> myStringStack;
	private StackIntfWithExceptions<Integer> myIntStack;

	/**
	 * Initializes a new Stack object
	 *
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.myStringStack = new DequeStack<>();
		this.myIntStack = new DequeStack<>();
	}

	/**
	 * Test pushing elements
	 */
	@Test
	public void testPush() {
		this.myStringStack.push("element1");
		assertEquals("element1", this.myStringStack.peek(), "Unable to push first element on the stack");
		this.myStringStack.push("element2");
		assertEquals("element2", this.myStringStack.peek(), "Unable to push more then one element on the stack");

		this.myIntStack.push(5);
		assertEquals(5, this.myIntStack.peek(), "Unable to push first element on the stack");
		this.myIntStack.push(29);
		assertEquals(29, this.myIntStack.peek(), "Unable to push more then one element on the stack");
	}

	/**
	 * Test popping elements
	 */
	@Test
	public void testPop() {
		this.myStringStack.push("element1");
		this.myStringStack.push("element2");
		assertEquals("element2", this.myStringStack.pop(), "Unable to pop an element from the stack");
		assertEquals("element1", this.myStringStack.pop(), "Unable to pop last element from the stack");
		assertEquals(true, this.myStringStack.isEmpty(), "Stack is not empty after last element is popped");
		try
		{
			this.myStringStack.pop();
			fail("Popping from an empty stack should throw an EmptyStackException");
		}
		catch( EmptyStackException e )
		{
			//If the method has been correctly implemented an exception will be caught here. Nothing further needs to happen
		}
		catch( Exception e )
		{
			fail("Caught a different exception that EmptyStackException");
		}


		this.myIntStack.push(5);
		this.myIntStack.push(29);
		assertEquals(29, this.myIntStack.pop(), "Unable to pop an element from the stack");
		assertEquals(5, this.myIntStack.pop(), "Unable to pop last element from the stack");
		assertEquals(true, this.myIntStack.isEmpty(), "Stack is not empty after last element is popped");
		try
		{
			this.myIntStack.pop();
			fail("Popping from an empty stack should throw an EmptyStackException");
		}
		catch( EmptyStackException e )
		{
			//If the method has been correctly implemented an exception will be caught here. Nothing further needs to happen
		}
		catch( Exception e )
		{
			fail("Caught a different exception that EmptyStackException");
		}
	}

	/**
	 * Test peeking at first element
	 */
	@Test
	public void testPeek() {
		this.myStringStack.push("element1");
		this.myStringStack.push("element2");
		assertEquals("element2", this.myStringStack.peek(), "Unable to peek at an element on the stack");
		this.myStringStack.pop();
		assertEquals("element1", this.myStringStack.peek(), "unable to peek at the last element on the stack");
		this.myStringStack.pop();
		try
		{
			this.myStringStack.pop();
			fail("Popping from an empty stack should throw an EmptyStackException");
		}
		catch( EmptyStackException e )
		{
			//If the method has been correctly implemented an exception will be caught here. Nothing further needs to happen
		}
		catch( Exception e )
		{
			fail("Caught a different exception that EmptyStackException");
		}

		this.myIntStack.push(5);
		this.myIntStack.push(29);
		assertEquals(29, this.myIntStack.peek(), "Unable to peek at an element on the stack");
		this.myIntStack.pop();
		assertEquals(5, this.myIntStack.peek(), "unable to peek at the last element on the stack");
		this.myIntStack.pop();
		try
		{
			this.myStringStack.pop();
			fail("Popping from an empty stack should throw an EmptyStackException");
		}
		catch( EmptyStackException e )
		{
			//If the method has been correctly implemented an exception will be caught here. Nothing further needs to happen
		}
		catch( Exception e )
		{
			fail("Caught a different exception that EmptyStackException");
		}
	}

	/**
	 * Test isEmpty
	 */
	@Test
	public void testIsEmpty() {
		assertEquals(true, this.myStringStack.isEmpty(), "Stack does not start out as empty");
		this.myStringStack.push("element1");
		this.myStringStack.push("element2");
		assertEquals(false, this.myStringStack.isEmpty(), "Stack is empty after adding element");
		this.myStringStack.pop();
		assertEquals(false, this.myStringStack.isEmpty(), "Stack is empty after popping one element");
		this.myStringStack.pop();
		assertEquals(true, this.myStringStack.isEmpty(), "After clearing the stack is not empty");

		assertEquals(true, this.myIntStack.isEmpty(), "Stack does not start out as empty");
		this.myIntStack.push(5);
		this.myIntStack.push(29);
		assertEquals(false, this.myIntStack.isEmpty(), "Stack is empty after adding element");
		this.myIntStack.pop();
		assertEquals(false, this.myIntStack.isEmpty(), "Stack is empty after popping one element");
		this.myIntStack.pop();
		assertEquals(true, this.myIntStack.isEmpty(), "After clearing the stack is not empty");
	}

	/**
	 * Test clearing stack
	 */
	@Test
	public void testClear() {
		this.myStringStack.push("element1");
		this.myStringStack.push("element2");
		assertEquals(false, this.myStringStack.isEmpty(), "Stack is indicated as empty after pushing elements");
		this.myStringStack.clear();
		assertEquals(true, this.myStringStack.isEmpty(), "Clearing the stack does not make it empty");

		this.myIntStack.push(5);
		this.myIntStack.push(29);
		assertEquals(false, this.myIntStack.isEmpty(), "Stack is indicated as empty after pushing elements");
		this.myIntStack.clear();
		assertEquals(true, this.myIntStack.isEmpty(), "Clearing the stack does not make it empty");
	}
}
