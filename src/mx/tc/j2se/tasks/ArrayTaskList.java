package mx.tc.j2se.tasks;


import java.util.Arrays;
import java.util.Objects;

public class ArrayTaskList<task> extends AbstractTaskList{
    private static final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private Task elementData[] = {};
    public ArrayTaskList(){
        elementData = new Task[INITIAL_CAPACITY];

    }
    /** This method is used to display the tasks in the list**/
    @Override
    public void add (Task task){
        if(size == elementData.length){
            ensureCapacity();
        }
        elementData[size++]=task;
    }
    /** This method is used to remove a task from the list
     * @return return true if task is removed**/
    @Override
    public boolean remove (Task task) {
        for(int i=0;i<size;i++){
            if(elementData[i]==task){
                for(int j=i;j<size;j++)
                {
                    elementData[j]=elementData[j+1];
                }
                size--;
                break;
            }
        }
        return true;
    }

    /** This method returns the size of the list**/
    @Override
    public int size(){
        return this.size;
    }

    /** This method is used to get the task present at particular index**/
    @Override
    public Task getTask(int index){
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("The task of index " + index + " is not available");
        }
        else{return elementData[index];}
    }
    /** This method is used to display the tasks in the list**/
    @Override
    public void display() {
        System.out.print("Displaying list : ");
        for (int i = 0; i < size; i++) {
            //System.out.println(elementData[i].getTitle() + " "+ elementData[i].getStartTime()+" "+elementData[i].isRepeated());
            System.out.println(elementData[i].getTitle());
        }
    }
    /** This method is used to increase the size of the list dynamically**/
    private void ensureCapacity() {
        int newIncreasedCapacity = elementData.length * 2;
        elementData= Arrays.copyOf(elementData,newIncreasedCapacity);
    }
    /** This method returns a list of tasks which are present between from and to time **/
    /*public ArrayTaskList incoming(int from, int to){
        ArrayTaskList res=new ArrayTaskList();
        for(int i=0;i<size;i++){
            if(elementData[i].getStartTime()>=from && elementData[i].getEndTime()<=to){
                res.add(elementData[i]);
            }
        }
        return res;
    }*/


}
