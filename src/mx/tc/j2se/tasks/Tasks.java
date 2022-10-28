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
            //System.out.println(tasks.next().getStartTime());
            //System.out.println(tasks.next().getEndTime());
            if (temp.getStartTime().isAfter(start) && temp.getStartTime().isBefore(end)) {
                abs.add(temp);
            }
        }
        abs.display();
        /*Iterator<Task> itr=abs.iterator();
        while(itr.hasNext()){
            /*System.out.println(itr.next().getTitle()+" "+itr.next().getStartTime());
            System.out.println(itr.next().getTitle()+" "+itr.next().getEndTime());*//*
            System.out.println(itr.next().toString());

        }*/

        return abs.iterator();
    }


}
