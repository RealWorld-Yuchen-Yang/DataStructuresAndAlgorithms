package main.singlylinkedlist;

import java.util.HashMap;

/**
 * Problem: 
 * 	Design and implement a data structure for LRU
 * 	Least Recently Used cache. 
 * 	It should support the following operations: get and set.
 * 	
 * 	get(key), Get the value(will always be positive) of the key, if the key exists in the cache
 * 			  ,otherwise return -1
 * 	set(key, value), Set or insert the value if the key is not already present. 
 * 					 When the cache reached its capacity, 
 * 					 It should invalidate the least recently used item beofore inserting the new item. 
 * 
 * Analysis:
 *  1) In order to increase search efficiency, we use a HashMap to store keys
 *     this can make search complexity O(1)
 *  2) In order to increase Insert/Delete efficiency, we use a DoublyLinkedList to store value nodes
 *  
 *  Implementation details: 
 *  1) In the DoublyLinkedList,
 *     front represents the most recently visited value, 
 *     end represents the least recently visited value	
 *  2) When visiting the nodes, if the node exist
 *     move such node to the front of the DoublyLinkedList
 *     also we need to update the address value of this new node in the HashMap.
 *  3) When doing insertion, 
 *     if size of the capacity(predefined value, number of nodes in the DoublyLinkedList) is reached,  		
 *     we need to remove the last node(which represents the least visited) from the DoublyLinkedList. 
 *     Then we insert the new node at the front of the DoublyLinkedList
 *     
 * @author yuchenyang
 *
 */
public class LeastRecentlyUsedCache
{
	private int capacity;
	
	/*
	 * helper map, used as index,
	 * this map's <key, value> pair:
	 * 	key: input cache's key
	 * 	value: the corresponding node in the DoublyLinkedList 
	 * the actual value storage is the DoublyLinkedList
	 */
	private final HashMap<Integer, Node> map;
	//head and end pointers pointing to the DoublyLinkedList's head and end respectively
	private Node head;	
	private Node end;
	
	public LeastRecentlyUsedCache(int capacity)
	{
		this.capacity = capacity;
		this.map = new HashMap();
	}
	
	//required method
	public int get(int key)
	{
		if(map.containsKey(key))
		{
			//found the key's value
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		//not found
		return -1;
	}
	
	//required method
	public void set(int key, int value)
	{
		if(map.containsKey(key))
		{
			//found the old node that the key is pointing to, and update its value
			Node old = map.get(key);
			old.value = value;
			//update the rank of the currently visited node
			remove(old);
			setHead(old);
		}
		else
		{
			//not found, add new node into the cache
			Node created = new Node(key, value);
			if(map.size()>= capacity)
			{
				//if cache is full
				map.remove(end.key);//update HashMap
				remove(end);//udpate DoublyLinkedList
				setHead(created);
			}
			else
			{
				//cache still has vacancy
				setHead(created);
			}
			
			map.put(key, created);
		}
	}
	
	
	private void setHead(Node n)
	{
		//update the inserted node's pointer
		n.next = head;
		n.prev = null;
		
		//update the DoublyLinkedList's head and end node's pointers
		if(head != null)
		{
			head.prev = n;
		}
		head = n;
		
		if(end == null)
		{
			end = head;
		}
	}
	
	/**
	 * This method is always used with setHead, who also updates the HashMap
	 * so this method do not need to update the map
	 * @param n
	 */
	private void remove(Node n)
	{
		if(n.prev != null)
		{
			//n is not head
			n.prev.next = n.next;
		}
		else
		{
			//n is head
			head = n.next;
		}
		
		if(n.next != null)
		{
			//n is not end
			n.next.prev = n.prev;
		}
		else
		{
			//n is end
			end = n.prev;
		}
	}
	
	/**
	 * DoublyLinkedList's node
	 * contains properties: 	
	 * 	prev & next pointers, which are used to construct the DoubluLinkedList
	 * 	key, value pairs, key stores the corresponding key in the HashMap, value is the real value cache need to store
	 * @author yuchenyang
	 *
	 */
	private static class Node
	{
		int key;
		int value;
		Node prev;
		Node next;
		
		public Node(int key, int value)
		{
			this.key = key;
			this.value = value;
		}
	}
}
