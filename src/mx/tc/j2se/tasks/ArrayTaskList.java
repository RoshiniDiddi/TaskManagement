package mx.tc.j2se.tasks;


import java.util.Arrays;

public class ArrayTaskList<task> {
    private static final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private Task elementData[] = {};
    public ArrayTaskList(){
        elementData = new Task[INITIAL_CAPACITY];

    }
    /*
    this method adds the task to the ArrayTaskList
     */
    public void add (Task task){
        if(size == elementData.length){
            ensureCapacity();
        }
        elementData[size++]=task;
    }
    boolean remove (Task task){
        for(int i=0;i<size;i++){
            if(elementData[i].getTitle()==task.getTitle()){
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
    public int size(){
        return this.size;
    }
    public Task getTask(int index){
        return elementData[index];
    }
    public void display() {
        System.out.print("Displaying list : ");
        for (int i = 0; i < size; i++) {
            //System.out.println(elementData[i].getTitle() + " "+ elementData[i].getStartTime()+" "+elementData[i].isRepeated());
            System.out.println(elementData[i].getTitle());
        }
    }

    private void ensureCapacity() {
        int newIncreasedCapacity = elementData.length * 2;
        elementData= Arrays.copyOf(elementData,newIncreasedCapacity);
    }
    public ArrayTaskList incoming(int from, int to){
        ArrayTaskList res=new ArrayTaskList();
        for(int i=0;i<size;i++){
            if(elementData[i].getStartTime()>=from && elementData[i].getEndTime()<=to){
                res.add(elementData[i]);
            }
        }
        return res;
    }

}
