
public class Node {
	Object data;
	Node next;
	
	public Node(Object datavalue){
		
		next = null;
		this.data = datavalue;
		
	}
	
	public Node(Object datavalue, Node nextNode){
		next = nextNode;
		this.data = datavalue;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	

}
