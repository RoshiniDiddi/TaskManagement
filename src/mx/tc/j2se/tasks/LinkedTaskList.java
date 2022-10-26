package mx.tc.j2se.tasks;
class Node{
    Task data;
    Node next;
    Node(Task data){
        this.data=data;
        next=null;
    }
    public Task getData() {
        return data;
    }

    public void setData(Task data) {
        this.data = data;
    }

    public Node getNextNode() {
        return next;
    }

    public void setNextNode(Node nextNode) {
        this.next = nextNode;
    }
}
public class LinkedTaskList extends AbstractTaskList {
    Node head;

    public void add(Task task) {
        Node new_node = new Node(task);

        if (this.head == null) {
            head = new_node;
        } else {
            Node currentNode = head;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(new_node);
        }
    }

    public void  display() {
        if (head != null) {
            Node currentNode = head;
            while (currentNode.getNextNode() != null) {
                System.out.println(currentNode.getData());
                currentNode = currentNode.getNextNode();
            }

            System.out.println( currentNode.getData().toString());
        }
    }
    public boolean remove(Task task){
        Node currentNode=head;
        Node prev=null;
        //if task is in first node
        if(currentNode!=null && currentNode.data==task){
            head=currentNode.next;
            return true;
        }
        //if task is in last node
        while(currentNode!=null && currentNode.data!=task){
            prev=currentNode;
            currentNode=currentNode.next;
        }
        if(currentNode!=null){
            prev.next=currentNode.next;
        }
        //if task not present
        if(currentNode==null){
            return false;
        }
        return true;
    }
    public int size(){
        Node temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }
    public Task getTask(int index){
        Node currentNode=head;
        int count=0;
        while(currentNode!=null){
            if(count==index){
                return currentNode.data;
            }
            count++;
            currentNode=currentNode.next;
        }
        return currentNode.data;
    }
    public LinkedTaskList incoming(int from ,int to){
        LinkedTaskList res=new LinkedTaskList();
        Node temp=head;
        while(temp!=null){
            if(temp.getData().getStartTime()>=from && temp.getData().getEndTime()<=to){
                res.add(temp.getData());
            }
            temp=temp.next;
        }
        return res;
    }
}
