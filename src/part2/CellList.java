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
		setHead(cl.getHead());
		setSize(cl.getSize());
	}
	
	// getters and setters
	public CellNode getHead() {
		return head;
	}
	public int getSize() {
		return size;
	}
	public void setHead(CellNode cn) {
		head = cn;
	}
	public void setSize(int s) {
		size = s;
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
			CellNode cur = head;
			for (int k = 0; k < i; k++) {
				cur = cur.cellNode;
			}
			CellNode newCN = new CellNode(cp, cur.getCellNode());
			cur.cellNode = newCN;
			size++;
		}
	}
	
	public void deleteAtIndex(int i) {
		if (i < 0 || i > size) {
			throw new NoSuchElementException();
		}else {
			CellNode cur = head;
			for (int k = 0; k < i; k++) {
				cur = cur.getCellNode();
			}
			CellNode next = cur.getCellNode().getCellNode();
			cur.setCellNode(next);
			size--;
		}
	}
	
	public void replaceAtIndex(CellPhone cp, int i) {
		if (i < 0 || i > size) {
			throw new NoSuchElementException();
		}else {
			CellNode cur = head;
			for (int k = 0; k < i; k++) {
				cur = cur.getCellNode();
			}
			cur.setCellPhone(cp);
		}
	}
	
	public CellNode find(long sn) {
		CellNode cur = head;
		while (cur.cellNode != null) {
			cur = cur.cellNode;
			if (cur.cellPhone.getSerialNum() == sn) {
				return cur;
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
		System.out.println("The current size of the list is " + size + ". Here are the contents of the list\n" 
				+ "=====================================================================");
		CellNode cur = head;
		int i = 1;
		while (cur != null) {
			System.out.println(i++ + ". " + cur.cellPhone.toString());
			cur = cur.getCellNode();
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
		private CellNode(CellNode cn) {
			setCellPhone(cn.getCellPhone());
			setCellNode(cn.getCellNode());
		}
		
		// clone
		private Object clone(CellNode cn) {
			CellNode newCN = new CellNode(cn);
			return newCN;
		}
		
		// getters and setters
		private CellPhone getCellPhone() {
			return cellPhone;
		}
		private CellNode getCellNode() {
			return cellNode;
		}
		private void setCellPhone(CellPhone cp) {
			cellPhone = cp;
		}
		private void setCellNode(CellNode cn) {
			cellNode = cn;
		}
		
		
	}
}
