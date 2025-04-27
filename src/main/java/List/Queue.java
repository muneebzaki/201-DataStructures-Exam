package List;

public class Queue {

    protected Node first;
    protected Node last;

    public Queue() {
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(Node newNode) {
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
    }

    public Node dequeue(){
        Node result = first;
        if (!isEmpty()){
            first = first.getNext();
            if (isEmpty()){
                last = null;
            }
        }
        return result;
    }

    void removeAll(Queue[] list){
       for (Queue q : list){
           Node temp = q.first;
           while (temp != null){
               int value = temp.getData();

               Node prev = null;
               Node current = first;

               while (current != null) {
                   if (current.getData() == value) {
                       if (prev != null) {
                           prev.next = current.next;
                       } else {
                           first = current.next;
                       }

                       if (current == last) {
                           last = prev;
                       }
                   } else {
                       prev = current;
                   }
                   current = current.next;
               }
               temp = temp.getNext();
           }
       }
    }
}

