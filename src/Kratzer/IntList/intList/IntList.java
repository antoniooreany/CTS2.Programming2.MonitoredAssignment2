package Kratzer.IntList.intList;

public class IntList {

	private class ListElement {
		private int info;
		private ListElement next;
		
		public ListElement(int info, ListElement next) {
			this.info = info;
			this.next = next;
		}

		public ListElement(int info) {
			this.info = info;
			this.next = null;
		}
	}
	
	private ListElement first;
	private ListElement last;
	
	public IntList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return true; 
	}
	
	public void insertFirst(int newValue) {
	}
	
	public void insertLast(int newValue) {
	}
	
	public void deleteFirst() {
	}
	
	public void deleteLast() {
	}
	
	public int firstElement() {
		return 0;
	}
	
	public int lastElement() {
		return 0;
	}
	
	public int size() {
		return 0;
	}
	
	public String toString() {
		return null;		
	}
	
}
