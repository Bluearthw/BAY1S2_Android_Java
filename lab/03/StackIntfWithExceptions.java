package utilExceptions;

import java.util.EmptyStackException;

/**
 * This interface provides all useful methods for the implementation of a simple
 * Stack
 * 
 * @author Jeroen Van Aken
 */
public interface StackIntfWithExceptions<T> {

	/**
	 * Pushes an object onto the top of the Stack.
	 * 
	 * @param o the object to be pushed on the Stack
	 *     
	 */
	public void push(T o);

	/**
	 * Removes the top element at the top of the Stack while returning it
	 * 
	 * @return the element that was found on top of the stack or throws an EmptyStackException if the stack is empty
	 *
	 */
	public T pop() throws EmptyStackException;

	/**
	 * Gets the top element from the stack, without removing it
	 * 
	 * @return the element that was found on the top of the stack or throws an EmptyStackException if the stack is empty
	 */
	public T peek() throws EmptyStackException;

	/**
	 * Checks if the Stack is empty
	 * 
	 * @return true if the Stack is empty
	 */
	public boolean isEmpty();
	
	/**
	 * Clears the content of the Stack
	 */
	public void clear();

}
