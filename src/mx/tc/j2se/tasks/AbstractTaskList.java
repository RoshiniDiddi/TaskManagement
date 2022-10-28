package mx.tc.j2se.tasks;
import java.util.Iterator;
import java.util.Objects;

public abstract class AbstractTaskList {
    int size;
    private mx.tc.j2se.tasks.Task Task;

    public void add(Task task){
    }
    public void display(){
    }
    public boolean remove(Task task){
        return true;
    }
    public int size(){
        return size;
    }
    public Task getTask(int index){
        return Task;
    }

    /**
     * This method allows the program iterate over all the elements in the array or list
     *
     * @return return the iterator object which allows to iterate the list
     */
    public Iterator<Task> iterator() {
        Iterator < Task > it = new Iterator < Task > (){
            public int currentIndex=0;
            @Override
            public boolean hasNext() {
                return currentIndex < size() && getTask(currentIndex)!=null;
            }

            @Override
            public Task next() {
                return getTask(currentIndex++);
            }
        };
        return it;
    }
    /** This method returns **/
    @Override
    public boolean equals(Object o) {
        if (o instanceof AbstractTaskList){
            AbstractTaskList tempList=(AbstractTaskList) o;
            if (this.size() == 0 && tempList.size() == 0) {
                return true;
            }
            else if(this.size()== tempList.size()){
                Iterator<Task> list1=this.iterator();
                Iterator<Task> list2=(tempList.iterator());
                while(list1.hasNext()){
                    Object o1=list1.next();
                    Object o2=list2.next();
                    if(!(o1==null ? o2==null:o1.equals(o2))){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }


}
