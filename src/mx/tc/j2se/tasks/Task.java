package mx.tc.j2se.tasks;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task {
    private String title;

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", status=" + status +
                ", repeat=" + repeat +
                ", time=" + time +
                ", start=" + start +
                ", end=" + end +
                ", interval=" + interval +
                ", current=" + current +
                '}';
    }

    private boolean status,repeat;
    private LocalDateTime time;
    private LocalDateTime start;
    private LocalDateTime end;
    long interval;
    private LocalDateTime current;



    /*constructor for non-repetitive task*/
    Task(String title, LocalDateTime time){
        try {
            if (time.getHour() < 0 && time.getMinute()<0) {
                throw new IllegalArgumentException("Time labels cannot be negative");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        this.title=title;
        this.time=time;
        this.repeat=false;
        this.status=true;
        this.current=time;
    }
    /*constructor for repetitive task*/
    Task (String title, LocalDateTime start, LocalDateTime end, long interval){
        try{
            if(start.getHour()<0 || end.getHour()<0 || start.getMinute()<0 || end.getMinute()<0) {
                throw new IllegalArgumentException("Time labels cannot be negative");
            }

            if (interval< 0) {
                throw new IllegalArgumentException("The interval of tasks repeating should be more than zero.");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        this.title=title;
        this.start=start;
        this.end=end;
        this.interval=interval;
        this.repeat=true;
        this.status=true;
        this.current=start;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isActive(){
        return status;
    }
    public void setActive(boolean active){
        this.status=active;
    }
    /**this method returns start time for repetitive tasks and
    time of execution for non-repetitive task
    **/
    public LocalDateTime getTime() {
        if(isRepeated()){
            return getStartTime();
        }
        return time;
    }
    /**this method sets the time of execution for non-repetitive task
    if task is repetitive then change repeat a boolean to false
     **/
    public void setTime(LocalDateTime time) {
        this.time = time;
        if(isRepeated()){
            repeat=false;
        }
    }
    /**
    this method returns time of execution for non-repetitive task
    and start time for repetitive task
     **/
    public LocalDateTime getStartTime() {
        if(!isRepeated()) {
            return time ;
        }
        return start;

    }
    /**
    this method returns time of execution for non-repetitive task
    and end time for repetitive task
     **/
    public LocalDateTime getEndTime() {
        if(!isRepeated()) {
            return time;
        }
        return end;
    }
    public LocalDateTime getCurrentTime(){

        return this.current;
    }
    public void setCurrentTime(LocalDateTime current) {
        this.current = current;
    }
    /** this method returns the interval of repetitive task
    * if task id non-repetitive then it returns 0
    **/
    public long getRepeatInterval(){
        if(!isRepeated()){
            return 0;
        }
        return interval;
    }
    /**
    this method sets start time, end time and repetition interval for repetitive task
    and if task is non-repetitive task it is changed to repetitive
     **/
    public void setTime(LocalDateTime start, LocalDateTime end, long interval){
        if(!isRepeated()){
            repeat=true;
        }
        this.start=start;
        this.end=end;
        this.interval=interval;
    }
    /** This method is used to check whether the task is repetitive or not **/
    public boolean isRepeated(){
        return repeat;
    }

    /** This method returns next startTime of the task**/
    public LocalDateTime nextTimeAfter (LocalDateTime current){
        if(current.plusHours(this.getRepeatInterval()).isBefore(end)){
            status=true;
            current=current.plusHours(this.getRepeatInterval());
            return current;
        }
        else{
            status=false;
            return LocalDateTime.MIN;
        }

    }
}
