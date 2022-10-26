package mx.tc.j2se.tasks;

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
}
