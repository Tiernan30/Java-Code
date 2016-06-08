
public class LinkedList {
	//head
	Node head;
	//count
	int listCount;
	
	public void add(Object data){
		if (head == null){
			head = new Node(data);
			listCount++;
		}
		else{
			Node nodeTemp = new Node(data);
			Node current = head;
			if (current != null){
				while(current.getNext()!= null){
					current = current.getNext();
				}
				current.setNext(nodeTemp);
				listCount++;
			}
		}
	}
	
	public Object getHead(){
		return head.getData();
	}
	
	public boolean remove(int index){
		//if this index is out of range, exit
		if(index < 1 || index > listCount){
			return false;
		}
		
		Node current = head;
		if (head != null){
			for(int i = 0; i < index; i++){
				if(current.getNext() == null){
					return false;
				}
				current.setNext(current.getNext().getNext());
			}
				//decrement the number of elements variable
				listCount--;
				return true;
			
			
		}
		return false;
		
	}

	
	public Object get(int index){
		//returns the element at the specified position in the list.
		//index must be 1 or higher
		if(index <= 0){
			return null;
		}
		Node current = null;
		if(head != null){
			current = head.getNext();
			for (int i = 0; i < index; i++){
				if (current.getNext() == null){
					return null;
				}
				current = current.getNext();
					
				}
				return current.getData();
				
			}
		return current;
		}
}


