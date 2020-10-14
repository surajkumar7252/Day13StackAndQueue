package day13linkedlist.day13linkedlistproblem;

public class Stack<I> {
	LinkedList<I> linkedList;

	public Stack() {
		this.linkedList = new LinkedList<I>();
	}
	public void push(InterfaceNode<I> node) {
		linkedList.addToList(node);
	}
	
	public void printingStack() {
		linkedList.printingList();
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
	}
}
