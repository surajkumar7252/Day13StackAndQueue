package day13linkedlist.day13linkedlistproblem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Queue<I> {
	private static final Logger log = LogManager.getLogger(Queue.class);
	LinkedList<I> linkedList = new LinkedList<I>();

	public Queue() {
		this.linkedList = new LinkedList<I>();
	}
	

	public void printingQueue() {
		linkedList.printingList();
	}

	public void enqueue(InterfaceNode<I> Node) {
		this.linkedList.appendingToList(Node);
	}
	public static void main(String[] args) {
		Queue<Integer> queuelist = new Queue<Integer>();
		Node<Integer> firstElement = new Node<Integer>(56);
		Node<Integer> secondElement  = new Node<Integer>(30);
		Node<Integer> thirdElement  = new Node<Integer>(70);
		queuelist.enqueue(firstElement);
		queuelist.enqueue(secondElement);
		queuelist.enqueue(thirdElement);
		log.debug("Queue : ");
		queuelist.printingQueue();
			}

}
