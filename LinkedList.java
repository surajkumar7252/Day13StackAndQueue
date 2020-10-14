package day13linkedlist.day13linkedlistproblem;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

interface InterfaceNode<I>{
	I getKey();
	public void setKey(I key);
	InterfaceNode<I> getNext();
	public void setNext(InterfaceNode<I> next);
}

class Node<I> implements InterfaceNode<I>{
	public I key;
	public Node<I> next;
	public Node(I key) {
		
		this.key = key;
		this.next = null;
	}
	public I getKey() {
		return key;
	}
	public void setKey(I key) {
		this.key = key;
	}
	public Node<I> getNext() {
		return next;
	}
	public void setNext(InterfaceNode<I> next) {
		this.next = (Node<I>) next;
	}
	
}

public class LinkedList<I> 
{   private static final Logger log=LogManager.getLogger(LinkedList.class);
    static Scanner inputFeed=new Scanner(System.in);
    public static Integer counter=0;
    public InterfaceNode<I> headPart=null;
    public InterfaceNode<I> tailPart=null;
  
    
    public void addToList(InterfaceNode<I> tempNode) {
    	if(this.headPart==null) {
    		this.headPart=tempNode;
    	}
    	if(this.tailPart==null) {
    		this.tailPart=tempNode;
    	}else {
    		InterfaceNode<I> temp=this.headPart;
    		this.headPart=tempNode;
    		this.headPart.setNext(temp);
    	}
    	
    }
    public void printingList() {
		InterfaceNode<I> tempNode=this.headPart;
		
		if(tempNode!=null) {
			log.debug("This is the Linked List : ");
			do {
				System.out.print(tempNode.getKey()+"->");
			}while((tempNode=tempNode.getNext())!=null);
			
			
		}
		
	}
    public void appendingToList(InterfaceNode<I> tempNode) {
		if (this.headPart == null) {
			this.headPart = tempNode;
		}
		if (this.tailPart == null) {
			this.tailPart = tempNode;
		} else {
			this.tailPart.setNext(tempNode);
			this.tailPart = this.tailPart.getNext();
		}
		
	}
    public void insertionInBetween(InterfaceNode<I> node1, InterfaceNode<I> node2) {
    	InterfaceNode<I> tempNode=node1.getNext();
		node1.setNext(node2);
		node1.getNext().setNext(tempNode);
		
	}
    public InterfaceNode<I> pop() {
    	InterfaceNode<I> tempNode = this.headPart;
		this.headPart = this.headPart.getNext();
		return tempNode;
	}
    public InterfaceNode<I> popLast() {
    	InterfaceNode<I> tempNode = this.headPart;
	    while(!tempNode.getNext().equals(this.tailPart)) 
		tempNode = tempNode.getNext();
	    this.tailPart = tempNode;
	    tempNode = tempNode.getNext();
	    this.tailPart.setNext(null);
	    return tempNode;
	}
    
    public boolean searchingNode(I valueToBeSearched) {
    	InterfaceNode<I> tempNode=this.headPart;
		while(tempNode!=null) {
			if(tempNode.getKey().equals(valueToBeSearched)) 
				return true;
			tempNode=tempNode.getNext();
		}
		return false;
	}
    

    public InterfaceNode<I> deletingValue(I valueToBeDeleted) {
    	
    	InterfaceNode<I> temp = null;
    	InterfaceNode<I> presentNode =this.headPart, previousNode = null; 
		if (presentNode != null && presentNode.getKey() == valueToBeDeleted) { 
			this.headPart = presentNode.getNext();
			counter++;
			temp = presentNode;
		} 
		while (presentNode != null && presentNode.getKey() != valueToBeDeleted) { 
			previousNode = presentNode; 
			presentNode = presentNode.getNext(); 
			
		}  
		if (presentNode != null) { 
			previousNode.setNext(presentNode.getNext());  
			temp = presentNode;
		} 
		return temp;
	} 
    
  
    
    public static void main( String[] args )
    {  LinkedList<Integer> listOfValues=new LinkedList<Integer>();
        Integer choice;
        log.debug( "Linked List Creation" );
        Node<Integer> thirdNode=new Node<Integer>(70);
        Node<Integer> secondNode=new Node<Integer>(30);
        Node<Integer> firstNode=new Node<Integer>(56);
        Node<Integer> fourthNode=new Node<Integer>(40);
        listOfValues.appendingToList(firstNode);
        listOfValues.appendingToList(secondNode);
        listOfValues.appendingToList(thirdNode);
        
		//listOfValues. insertionInBetween(firstNode,secondNode);
		listOfValues. insertionInBetween(secondNode,fourthNode);
		log.debug("What do you wanna perform: ");
		log.debug("1. popping the first element");
		log.debug("2.popping the Last element");
		log.debug("3.Searching node for an element");
		log.debug("4.Deleting  element (40)");
		
		choice = inputFeed.nextInt();
		switch(choice) {
		case 1: log.debug("Original Linked List");
		        listOfValues.printingList();
		        listOfValues.pop();
		        log.debug("\n");
		        log.debug("Linked List after popping the first element");
		        listOfValues.printingList();
		        break;
		case 2: log.debug("Original Linked List");
                listOfValues.printingList();
                listOfValues.popLast();
                log.debug("\n");
                log.debug("Linked List after popping the Last element");
                listOfValues.printingList();
                 break;
		case 3:    log.debug("enter the element to be searched: ");
		           Integer Element=inputFeed.nextInt();
                   log.debug("searched element found: "+listOfValues.searchingNode(Element));
                   break;
		case 4:    log.debug("enter the element to be Deleted: ");
                   Integer delElement=inputFeed.nextInt();
                   log.debug("searched element found: "+listOfValues.deletingValue(delElement));
                   log.debug("Linked List after Deleting the element");
                   listOfValues.printingList();
                   log.debug("Number of  elements now : "+counter);
                   break;
                   
		}
		
		
		
    }
}
