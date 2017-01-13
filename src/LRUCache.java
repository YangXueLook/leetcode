import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
	
	private int capacity = 0;
	private HashMap<Integer, Integer> keyValueMap = new HashMap<Integer, Integer>();
	private HashMap<Integer, Node> keyAndDummyKeyNodeMap = new HashMap<Integer, Node>();
	private Node head = null;
	private Node tail = null;
	

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if(keyValueMap.containsKey(key))
		{
			Node node  = keyAndDummyKeyNodeMap.get(key);
			if(head == tail)
			{
				//only 1 element
			}
			else if(node == tail)
			{
				//already there
			}
			else if(node == head)
			{
				head = head.next;
				head.pre = null;
				tail.next = node;
				node.next = null;
				node.pre = tail;
				tail = tail.next;
			}
			else//in the middle
			{
				node.pre.next = node.next;
//				System.out.println(temp==null);
				node.next.pre = node.pre;
				node.next = null;
				node.pre = tail;
				tail.next = node;
				tail = tail.next;
			}
			
			return keyValueMap.get(key);
		}

		return -1;
	}

	public void set(int key, int value) {
		if(keyValueMap.containsKey(key))
		{
			keyValueMap.put(key, value);
			if(head != tail)//more than 1 nodes
			{
				Node temp = keyAndDummyKeyNodeMap.get(key);
				
				if(temp == head)
				{
					head = head.next;
					head.pre = null;
					tail.next = temp;
					temp.pre = tail;
					temp.next = null;
					tail = tail.next;
				}
				else if(temp == tail)
				{}
				else 
				{
					
					temp.pre.next = temp.next;
					temp.next.pre = temp.pre;
					temp.next = null;
					temp.pre = tail;
					tail.next = temp;
					tail = tail.next;
				}
			}
		}
		else
		{
			if(keyValueMap.size() < capacity)
			{
				keyValueMap.put(key, value);
				Node newNode = new Node(key);
				if(head == null)//empty now
				{
					head = newNode;
					tail = newNode;
					keyAndDummyKeyNodeMap.put(key, newNode);	
				}
				else
				{
					tail.next = newNode;
					newNode.pre = tail;
					tail = newNode;
					keyAndDummyKeyNodeMap.put(key, newNode);
				}
			}
			else
			{
				if(head == tail)//capability is only 1
				{
					keyValueMap.clear();
					keyAndDummyKeyNodeMap.clear();
					Node newNode = new Node(key);
					head = newNode;
					tail = newNode;
					keyValueMap.put(key, value);
					keyAndDummyKeyNodeMap.put(key, newNode);
				}
				else// remove head and add a new tail
				{
					
					int whichKeyWeWantToRemove = head.val;
					keyValueMap.remove(whichKeyWeWantToRemove);
					keyAndDummyKeyNodeMap.remove(whichKeyWeWantToRemove);
					Node newNode = new Node(key);
					keyValueMap.put(key, value);
					keyAndDummyKeyNodeMap.put(key, newNode);
					//remove head
					head = head.next;
					head.pre.next = null;
					head.pre = null;
					
					//add a new tail
					tail.next = newNode;
					newNode.pre = tail;
					tail = newNode;
					
				}
			}
		}
		
		

	}
	
	class Node
	{
		int val = 0;
		Node pre = null;
		Node next = null;
		Node(int val)
		{
			this.val = val;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache t = new LRUCache(10);
//		System.out.print(1);
//		t.set(2, 6);
//		System.out.print(2);
//		t.get(1);
//		System.out.print(3);
//		t.set(1,5);
//		System.out.print(4);
//		t.set(1,2);
//		System.out.print(5);
//		t.get(1);
//		System.out.print(6);
//		t.get(2);
		
		t.set(7,28);
		t.set(7,1);
		t.set(8,15);
		t.get(6);
		t.set(10,27);
		t.set(8,10);
		t.get(8);
		t.set(6,29);
		t.set(1,9);
		t.get(6);
		t.set(10,7);
		t.get(1);
		t.get(2);
		t.get(13);
		t.set(8,30);
		t.set(1,5);
		t.get(1);
		t.set(13,2);
		t.get(12);

	}

}
