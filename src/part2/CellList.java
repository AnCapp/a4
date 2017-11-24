package part2;

import java.util.NoSuchElementException;

public class CellList {

	private CellNode head;
	private int size;
	
	// constructor
	public CellList() {
		head = null;
		size = 0;
	}
	
	// copy constructor
	public CellList(CellList cl) {
		head = cl.head;
		size = cl.size;
	}
	
	// copy
	public CellList clone() {
		CellList newCL = new CellList(this);
		return newCL;
		
	}
	
	// no getters and setters
	// I added size, because most lists do that.
	public int size() {
		return size;
	}
	
	public void addToStart(CellPhone cp) {
		if (head == null) {
			CellNode cn = new CellNode();
			cn.cellPhone = cp;
			head = cn;
		}else {
			CellNode cn = new CellNode(cp, head);
			head = cn;
		}
		size++;
	}
	
	public void deleteFromStart() {
		if (head == null) {
			throw new NoSuchElementException();
		}else if (size == 1) {
			head = null;
			size--;
		}else {
			head = head.cellNode;
			size--;
		}
	}
	
	public void insertAtIndex(CellPhone cp, int i) {
		if (i < 0 || i >= size) {
			throw new NoSuchElementException();
		}else {
			CellNode cur = head; // get to the node before the one at index i
			for (int k = 0; k < i-1; k++) {
				cur = cur.cellNode;
			}
			CellNode cn = new CellNode(cp, cur.cellNode);
			cur.cellNode = cn;
			size++;
		}
	}
	
	public void deleteAtIndex(int i) {
		if (i < 0 || i > size) {
			throw new NoSuchElementException();
		}else {
			CellNode cur = head; // get to the node before index i
			for (int k = 0; k < i-1; k++) {
				cur = cur.cellNode;
			}
			CellNode next = cur.cellNode.cellNode; 
			cur.cellNode = next; // set this node to the one 2 further
			size--;
		}
	}
	
	public void replaceAtIndex(CellPhone cp, int i) {
		if (i < 0 || i > size) {
			throw new NoSuchElementException();
		}else {
			CellNode cur = head;
			for (int k = 0; k < i; k++) {
				cur = cur.cellNode;
			}
			cur.cellPhone = cp;
		}
	}
	
	// what do they exactly want?
	// I now return a CellPhone instead of CellNode
	// There is no use in returning CellNodes, because they are private.
	public CellPhone find(long sn) {
		CellNode cur = head;
		while (cur.cellNode != null) {
			cur = cur.cellNode;
			if (cur.cellPhone.getSerialNum() == sn) {
				return cur.cellPhone;
			}
		}
		return null;
	}
	
	public boolean contains(long sn) {
		CellNode cur = head;
		while (cur != null) {
			if (cur.cellPhone.getSerialNum() == sn) {
				return true;
			}
			cur = cur.cellNode;
		}
		return false;
	}
	
	public void showContents() {
		System.out.println("The current size of list " + size + ". Here are the contents of the list:\n" 
				+ "=====================================================================");
		CellNode cur = head;
		int i = 1;
		while (cur != null) {
			System.out.println(i++ + ". " + cur.cellPhone.toString());
			cur = cur.cellNode;
		}
	}
	
	public boolean equals(CellList cl) {
		if (cl == null || getClass() != cl.getClass()) {
			return false;
		}else {
			if (size != cl.size)
				return false;
			CellNode cur1 = head;
			CellNode cur2 = cl.head;
			while (cur1 != null) {
				if (!cur1.cellPhone.equals(cur2.cellPhone))
					return false;
				cur1 = cur1.cellNode;
				cur2 = cur2.cellNode;
			}
			return true;
		}
	}
	
	// a private inner class is made here,
	// because we only use the class for the CellList.
	// Because of this, the class is better protected,
	// because apart from CellList class, nobody can access it.
	private class CellNode {
		
		private CellPhone cellPhone;
		private CellNode cellNode;
		
		private CellNode() {
			cellPhone = null;
			cellNode = null;
		}
		
		private CellNode(CellPhone cp, CellNode cn) {
			cellPhone = cp;
			cellNode = cn;
		}
		
		// copy constructor
		// do we need accessors and mutators for this?
		private CellNode(CellNode cn) {
			new CellNode(cn.cellPhone, cn.cellNode);
		}
		
		// clone
		private CellNode nodeClone() {
			CellNode newCN = new CellNode(this);
			return newCN;
		}
	}
}
