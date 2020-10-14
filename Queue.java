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
	public InterfaceNode<I> dequeue(){
		return linkedList.pop();
	}
	public static void main(String[] args) {
		Queue<Integer> queueList = new Queue<Integer>();
		Node<Integer> firstElement = new Node<Integer>(56);
		Node<Integer> secondElement  = new Node<Integer>(30);
		Node<Integer> thirdElement  = new Node<Integer>(70);
		queueList.enqueue(firstElement);
		queueList.enqueue(secondElement);
		queueList.enqueue(thirdElement);
		log.debug("Original Queue : ");
		queueList.printingQueue();
		queueList.dequeue().getKey();
		log.debug("Queue after dequeue operation:");
		queueList.printingQueue();
			}

}
