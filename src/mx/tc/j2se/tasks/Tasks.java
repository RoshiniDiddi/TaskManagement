package mx.tc.j2se.tasks;

import java.time.LocalDateTime;
import java.util.*;

public class Tasks {
    public static Iterator<Task> incoming(Iterator<Task> tasks, LocalDateTime start, LocalDateTime end) {
        if(end.isBefore(start) || tasks == null){
            throw new IllegalArgumentException("End time should be after the start time");
        }
        if( tasks == null){
            throw new IllegalArgumentException("Iterator is empty");
        }
        AbstractTaskList abs = new ArrayTaskList() {
            @Override
            public Iterator<Task> iterator() {
                return super.iterator();
            }

            @Override
            public void add(Task task) {
                super.add(task);
            }
        };
        while (tasks.hasNext()) {
            Task temp=tasks.next();
            /*
            System.out.println("is After:"+temp.getStartTime().isAfter(start));
            System.out.println("is Before:"+temp.getEndTime().isBefore(end));

            System.out.println(temp.getEndTime()+"  "+end+"   "+temp.getEndTime().isAfter(end) );
            System.out.println(temp.getStartTime().isBefore(start));*/
            /** Task Interval should be between input interval **/
            if (temp.getEndTime().isAfter(end) && temp.getStartTime().isBefore(start)) {
                abs.add(temp);
            }
        }
        return abs.iterator();
    }
    public static SortedMap<LocalDateTime, Set<Task>> calendar(Iterator<Task> tasks, LocalDateTime start, LocalDateTime end){
        if(end.isBefore(start)){
            throw new IllegalArgumentException("End time should be after the start time");
        }
        if( tasks == null){
            throw new IllegalArgumentException("Iterator is empty");
        }
        SortedMap<LocalDateTime, Set<Task>> sMap=new TreeMap<LocalDateTime, Set<Task>>();
        Iterator<Task> taskList=Tasks.incoming(tasks,start,end);
        while(taskList.hasNext()){
            Task temp=taskList.next();
            if(temp.isRepeated()){
                for(LocalDateTime curr=temp.nextTimeAfter(start);
                    (curr.isBefore(end) || curr.isEqual(end)) &&
                    (curr.isBefore((temp.getEndTime()))|| curr.isEqual(temp.getEndTime()));
                    curr=curr.plusHours(temp.getRepeatInterval())){
                    if(sMap.containsKey(temp.getCurrentTime())) {
                        sMap.get(temp.getCurrentTime()).add(temp);
                    }
                    else{
                        Set<Task> set=new HashSet<>();
                        set.add(temp);
                        sMap.put(temp.getCurrentTime(),set);
                    }

                }
            }
            else{
                if(sMap.containsKey(temp.getTime())){
                    sMap.get(temp.getTime()).add(temp);
                }
                else{
                    Set<Task> rset=new HashSet<Task>();
                    rset.add(temp);
                    sMap.put(temp.getTime(),rset);
                }
            }
        }
        return sMap;
    }

}

