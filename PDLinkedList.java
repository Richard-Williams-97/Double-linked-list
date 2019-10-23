/**
 * 
 * @author Rick Williams
 *10/29/2018
 *
 *Data structures
 *
 *PDLinkedList is a object used to create two way iterable linked list.
 *The head of the list is the first and the tail is the last Node. Current node is set after
 *certain methods. if the methods changes the current node it will be mentioned
 */
public class PDLinkedList //Informational cohesion
{
	private Node head; //possibly temporal cohesion
	private Node tail;
	private Node current;
	private int size;
	
	private static final Exception exListEmpty = new Exception("List empty"); 
	private static final Exception exListNoNextItem = new Exception("No next item -- at tail");
	private static final Exception exListNoPrevItem = new Exception("No prev item -- at head");
	private static final Exception exListItemNotFound = new Exception ("List item not found");

	/**
	 * 
	 * Node is the object inside PDLinkedList that allows us to store information
	 * in this case the information is an integer value
	 * 
	 */
private static class Node
{
		int value;
		Node prev;
		Node next;
	
	
	public Node(int val, Node p, Node n)
	{
		value=val;
		prev=p;
		next=n;
	}
	
	public Node(int val)
	{
		this(val, null, null);
	}
}
	/**
	 * lilst constructor
	 */
	public PDLinkedList()
	{
		head=tail=current=null;
		size=0;
	}
	
	/**
	 * isEmpty compares size to zero
	 * @return T/F depending on size
	 * if size is zero isEmpty will be true 
	 */
	public boolean isEmpty() //Functional cohesion
	{
		return size==0;
	}
	
	/**
	 * size returns the variable "size" to command
	 * @return size, integer value directly related to the number
	 * of nodes in LinkedList
	 */
	public int size()
	{
		return size;
	}
	
	/**
	 * contains is a sequential search that returns true or false
	 * @param item, an int to be searched for in the list
	 * @return boolean stat, true if list contains item. false otherwise
	 * 
	 */
	public boolean contains(int item) //communication cohesion ...or possibly procedural
	{
		if(size==0)
		{
			return false;
		}
		
		boolean stat=false;
		Node search;
		
		if(size==1)
		{
			search =head;
			
			if(search.value==item)
			{
				return true;
			}
		}else
		{search=head;
		
		while(search!=null &&search.value!=item && search!=tail)
			{
				
				
				search=search.next;
			}
		}
		if(search.value==item)
			stat=true;
		
		return stat;
	}
	
	/**
	 * append adds item to end of list. makes current node tail
	 * @param item integer, makes node and places it at end of list
	 * 
	 */
	public void append(int item)
	{
		Node newNode=new Node(item);
		if(size==0)
		{
			head=newNode;
		}else
		{
			newNode.prev=tail;
			tail.next=newNode;
		}
		tail=newNode;
		current=newNode;
		size++;
	}
	
	/**
	 * adds node to beginning of list. makes current node head
	 * @param item
	 */
	public void prepend(int item)
	{
		Node newNode=new Node(item);
		if(size==0)
		{
			tail=newNode;
		}else
		{
			newNode.next=head;
			head.prev=newNode;
		}
		current=newNode;
		head=newNode;
		size++;
	}
	
	/**
	 * finds next occurrence of item in list
	 * @param item integer to be searched for starting from current node
	 * @throws exListEmpty if list is empty
	 * @throws exListItemNotFound if item is not in list
	 * 
	 * affects current node it item is found
	 */
	public void findNext(int item) throws Exception
	{
	Node search=null;	
	if(size==0)
	{
		throw exListEmpty;
	}else if(size==1)
	{
		throw exListItemNotFound;
	}else
	{
		if(current.next!=null)
		{
			search=current.next;
			
			boolean key=false;
		do
		{
	
			
			if(search.value==item)
				{current=search; key=true;}
			else
			search=search.next;
			if(search==null && key==false)
				throw exListItemNotFound;
			
		}while(search!=null && key!=true);
		
		
		}else
			throw exListItemNotFound;
	}
	}
	
	/**
	 * finds previous occurrence of int in list
	 * sets current to node of item if found
	 * @param item int to be searched for
	 * @throws exListEmpty thrown if size ==0
	 * @throws exListItemNotFound if search ==  null, or just the same, the item
	 * is not found.
	 */
	public void findPrev(int item) throws Exception
	{
	Node search=null;	
	if(size==0)
	{
		throw exListEmpty;
	}else if(size==1)
	{
		throw exListItemNotFound;
	}else
	{
		if(current.prev!=null)
		{
			search=current.prev;
			
			boolean key=false;
		do
		{
	
			
			if(search.value==item)
				{current=search; key=true;}
			else
			search=search.prev;
			if(search==null && key==false)
				throw exListItemNotFound;
			
		}while(search!=null && key!=true);
		
		
		}else
			throw exListItemNotFound;
	}
	}
	
	/**
	 * gets the integer value pointed to be the current node
	 * @return integer value from current node
	 * @throws exListEmpty if size of list ==0
	 */
	public int get() throws Exception
	{
		if(size>0)
		{
		return current.value;
		}else
			throw exListEmpty;
	}
	
	/**
	 * returns integer value pointed to by head
	 * sets current to head
	 * @return int in head pointer
	 * @throws exListEmpty if list is empty
	 */
	public int getHead() throws Exception
	{
		if(size>0)
		{
			current=head;
			return head.value;
		}else
			throw exListEmpty;
	}
	
	/**
	 * returns integer value pointed to by tail
	 * sets current to tail
	 * @return integer stored at tail pointer
	 * @throws exListEmpty if list is empty
	 */
	public int getTail() throws Exception
	{
		if(size>0)
		{
			current=tail;
			return tail.value;
		}else
			throw exListEmpty;
	}
	
	/**
	 * returns the value of the next node on the list
	 * sets current to next node
	 * @return int value from next node
	 * @throws exListEmpty if list is empty
	 * @throws ExlistNoNextItem if the list has no next item
	 */
	public int getNext() throws Exception
	{
		if(size==0)
			throw exListEmpty;
			
			if(current!=tail && size>0)
			{
				current=current.next;
				return current.value;
			}
			else
		{throw exListNoNextItem;}
	}
	
	/**
	 * gets previous value from node in list
	 * sets current node to node in position one before
	 * @return int of node in front of previous node
	 * @throws exList empty if list is empty
	 * @trhows exListNoPrevItem if there is no node before the current node
	 */
	public int getPrev() throws Exception
	{
			if(size==0)
				throw exListEmpty;
			
			if(current!=head&&size>0)
			{
				current=current.prev;
				return current.value;
			}
			else
			{throw exListNoPrevItem;}
	}
	
	/**
	 * inserts item before current node
	 * sets current node to one inserted
	 * @param item int to be turned to node and inserted
	 */
	public void insert(int item)
	{
		Node newNode=new Node(item);
		
		if(size==0)
		{
			current=newNode;
			head=newNode;
			tail=newNode;
		}
		if(size>0)
		{
			newNode.next=current;
		
			if(current!=head)
			{
				newNode.prev=current.prev;
				current.prev.next=newNode;
				current.prev=newNode;
			}else
			{
				head=newNode;
			}
			current.prev=newNode;
			current=newNode;
		}
		size++;
	}
	
	/**
	 * adds node after the current node
	 * current becomes new node
	 * @param item int to be turned to node and added into the list
	 */
	public void add(int item)
	{
	
		Node newNode=new Node(item);
		
		if(size==0)
		{
			head=newNode;
			current=newNode;
			tail=newNode;
		}else
		{
			newNode.prev=current;
			
			if(current!=tail)
			{
				newNode.next=current.next;
				
				current.next.prev=newNode;
			}else
			{
				tail=newNode;
			}
			current.next=newNode;
		}
		current=newNode;
		size++;
		
	}
	
	/**
	 * removes item from list. current is set to previous item or if not possible
	 * then curretn is set to node after item removed. if list becomes empty all pointers are set to null
	 * @return int of item removed
	 * @throws exListEmpty if list is empty
	 */
	public int remove() throws Exception
	{
	
		if(size==0)
			throw exListEmpty;
	
		int is=current.value;
		
		if(size==1)
		{
			current=head=tail=null;
			size=0;
			return is;
		}	
		
		if(size>1)
		{
			if(current==head)
			{
				current=current.next;
				current.prev=null;
				head=current;
				
			}else
			if(current==tail)
			{
				current=current.prev;
				current.next=null;
				tail=current;
				
			}else
			if(current!=head &&current !=tail)
			{
				current.prev.next=current.next;
				current.next.prev=current.prev;
				
			if(current.next!=null)
				{
					current=current.next;
				}else 
					current=current.prev;
				
			}
		size--;	
		}
	
		return is;
	}
	
	/**
	 * removes searched item from list
	 * current is set to one before item removed if possible or one after otherwise
	 * if list becomes empty all pointers are set to null
	 * @param item int to be removed
	 * @throws exListItemNotFound if item is not in list
	 * @throws exListEmpty if list is empty
	 */
	public void remove(int item) throws Exception
	{
		if(size>0)
		{
		Node search=head;
		
		while(search!=null && search.value!=item)
		{
			search=search.next;
		}
		if(search.value==item)
		{
			current=search;
			remove();
		}else
		{
			search=null;
			throw exListItemNotFound;
		}
			
		}else
			throw exListEmpty;
	}
}
