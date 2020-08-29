package com.infosys.learning.collections;

public class LinkedListDS {
	Node root;

	public void add(Integer el) {
		Node node = new Node(el);
		if(root == null) {
			root = node;
			return;
		}
		
		Node temp = root;
		Node prev = null;
		while(temp != null) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = node;					
	}
	
	public void print() {
		System.out.println(root);
		Node temp = root;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;	
		}
	}

	public void remove(Integer data) throws Exception {
		if(root == null)
			throw new Exception("Linked List is empty");
		Node temp = root;
		Node prev = null;
		while(temp != null) {
			if(temp.data == data) {
				if(prev == null) {
					root = temp.next;
				}
				else {
					prev.next = temp.next;
				}
				break;
			}			
			prev = temp;
			temp = temp.next;	
		}		
	}

	public static void main(String[] args) {
		LinkedListDS lList = new LinkedListDS();
		lList.add(10);
		lList.add(20);
		lList.add(30);
		lList.print();
		try {
			lList.remove(10);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		lList.print();
	}
	
	class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			this.next = null;
		}
		
		public String toString() {
			return "[" + data +", " + next + "]";
		}
	}
}
