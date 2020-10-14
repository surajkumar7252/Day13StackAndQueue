package day13linkedlist.day13linkedlistproblem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdk.internal.org.jline.utils.Log;

public class Stack<I> {
	LinkedList<I> linkedList;
	private static final Logger log=LogManager.getLogger(Stack.class);

	public Stack() {
		this.linkedList = new LinkedList<I>();
	}
	public void push(InterfaceNode<I> node) {
		linkedList.addToList(node);
	}
	
	public void printingStack() {
		linkedList.printingList();
	}
	public InterfaceNode<I> peakFinder(){
		return linkedList.headPart;
	}
	
	public InterfaceNode<I> pop(){
		return linkedList.pop();
	}
	
	public static void main(String[] args) {
		Stack<Integer> stackFormation = new Stack<Integer>();
		Node<Integer> firstElement = new Node<Integer>(56);
		Node<Integer> secondElement  = new Node<Integer>(30);
		Node<Integer> thirdElement  = new Node<Integer>(70);
		stackFormation.push(thirdElement);
		stackFormation.push(secondElement);
		stackFormation.push(firstElement );
		stackFormation.printingStack();
		while(stackFormation!=null) {
			
			log.debug("Peak : " + stackFormation.peakFinder());
			log.debug("Pop : " + stackFormation.pop());	
			
		}
	}
}
