package mx.tc.j2se.tasks;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;

public class Tasks {
    public static Iterator<Task> incoming(Iterator<Task> tasks, LocalDateTime start, LocalDateTime end) {
        AbstractTaskList abs = new ArrayTaskList() {
            @Override
            public Iterator<Task> iterator() {
                return super.iterator();
            }

            @Override
            public void add(mx.tc.j2se.tasks.Task task) {
                super.add(task);
            }
        };
        while (tasks.hasNext()) {
            //System.out.println(tasks.next().getTitle());
            Task temp=tasks.next();
            //System.out.println(temp.getTitle());
            //abs.display();
            /*System.out.println(tasks.next().getStartTime());
            System.out.println("is After:"+temp.getStartTime().isAfter(start));
            System.out.println("is Before:"+temp.getEndTime().isBefore(end));*/

            //System.out.println(temp.getEndTime()+"  "+end+"   "+temp.getEndTime().isAfter(end) );
            //System.out.println(temp.getStartTime().isBefore(start));
            /** Task Interval should be between input interval **/
            if (temp.getEndTime().isAfter(end) && temp.getStartTime().isBefore(start)) {
                abs.add(temp);
            }
        }
        return abs.iterator();
    }
    /*public static SortedMap<LocalDateTime, Set<Task>> calendar(Iterator<Task> tasks, LocalDateTime start, LocalDateTime end){
        SortedMap<LocalDateTime, Set<Task>> sMap;
        Set<Task> sTask;
        while(tasks.hasNext()){
            Task temp=tasks.next();

        }
        return sMap;
    }*/

}

