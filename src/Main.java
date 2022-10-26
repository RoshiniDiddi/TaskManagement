package mx.tc.j2se.tasks;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.sql.SQLOutput;
import java.util.Iterator;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Task t1=new Task("Morning Run",3,15,2);
        Task t2=new Task("Reading Book",8,10,2);
        Task t3=new Task("Playing badminton",9);
        Task t4=new Task("Running",-1,5,2);
        //Task 1
        /** Working of methods inside Task Class**/
        /*
         if(t1.isRepeated()){
            t1.current=t1.start;
            while(t1.current< t1.getEndTime()) {
                System.out.println(t1.getTitle()+ " " + t1.getCurrentTime());
                t1.current += t1.getRepeatInterval();
                if(t1.current < t1.getEndTime()){
                    t1.setActive(true);}
                else{t1.setActive(false);}
                System.out.println(t1.isActive());
            }
        }*/
        //TASK 2
        /** Creation of ArrayTaskList object
         * Addition of task into ArrayList
         * removal of task from ArrayList
         * displaying tasks in ArrayList**/
        /*ArrayTaskList atl=new ArrayTaskList();
        atl.add(t1);
        atl.add(t2);
        atl.add(t3);
        atl.display();
        atl.remove(t2);
        atl.display();
        System.out.println(atl.size());
        atl.getTask(15); // exception occurs

        atl.incoming(5,10).display();*/
        //Task 2
         /** Creation of LinkedTaskList object
         * Addition of task into LinkedList
         * removal of task from LinkedList
         * displaying tasks in LinkedList **/
        /*
        LinkedTaskList ltl =new LinkedTaskList();
        ltl.add(t1);
        ltl.add(t2);
        ltl.add(t3);
        //ltl.display();
        ltl.remove(t2);
        ltl.display();
        ltl.incoming(3,10).display();
         */
        //Task 4
        /** ArrayTaskList using Abstract class
         * Creation of object for TaskListFactory **/
        TaskListFactory tlf=new TaskListFactory();
        AbstractTaskList at=tlf.createTaskList(ListTypes.types.ARRAY);
        at.add(t1);
        at.add(t2);
        at.add(t3);

        /** Iterator for ArrayTaskList**/
        /*Iterator<Task> it=at.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
        at.display();
        at.remove(t1);
        at.display();
        */
        /** LinkedTaskList using Abstract class **/
        /*AbstractTaskList at=tlf.createTaskList(ListTypes.types.LINKED);
        at.add(t1);
        at.add(t2);
        at.add(t3);
        */
        /** Iterator for ArrayTaskList**/
        /*
        Iterator<Task> it=at.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
        at.display();
        at.remove(t1);
        at.display();
        */
        //Task 5
        AbstractTaskList at1=tlf.createTaskList(ListTypes.types.ARRAY);
        at1.add(t1);
        at1.add(t2);
        at1.add(t3);
        System.out.println(at.hashCode());
        System.out.println(at1.hashCode());
        /*if(at==at1){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }*/
        System.out.println(at1.equals(at));
        //System.out.println(at==at1);
    }
}
