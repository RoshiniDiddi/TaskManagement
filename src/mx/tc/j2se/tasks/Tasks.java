package mx.tc.j2se.tasks;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;

public class Tasks {
    public static Iterator<Task> incoming(Iterator<Task> tasks, LocalDateTime start, LocalDateTime end) {
        AbstractTaskList abs = new AbstractTaskList() {
            public Iterator<Task> iterator() {
                return super.iterator();
            }
        };
        while (tasks.hasNext()) {
            System.out.println(tasks.next().getTitle());
            if (tasks.next().getStartTime().isAfter(start) && tasks.next().getEndTime().isBefore(end)) {
                System.out.println("added");
                abs.add(tasks.next());
            }
        }
        return abs.iterator();
    }


}
