package mx.tc.j2se.tasks;

public class Task {
    String title;

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

    boolean status,repeat;
    int time;
    int start;
    int end;
    int interval;
    int current;
    /*constructor for non-repetitive task*/
    Task(String title, int time){
        try {
            if (time < 0) {
                throw new IllegalArgumentException("Time labels cannot be negative");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        this.title=title;
        this.time=time;
        this.repeat=false;
        this.status=true;
    }
    /*constructor for repetitive task*/
    Task (String title, int start, int end, int interval){
        try{
            if(start<0 || end<0) {
                throw new IllegalArgumentException("Time labels cannot be negative");
            }

            if (interval < 0) {
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
    public int getTime() {
        if(isRepeated()){
            return getStartTime();
        }
        return time;
    }
    /**this method sets the time of execution for non-repetitive task
    if task is repetitive then change repeat a boolean to false
     **/
    public void setTime(int time) {
        this.time = time;
        if(isRepeated()){
            repeat=false;
        }
    }
    /**
    this method returns time of execution for non-repetitive task
    and start time for repetitive task
     **/
    public int getStartTime() {
        if(!isRepeated()) {
            return time ;
        }
        return start;

    }
    /**
    this method returns time of execution for non-repetitive task
    and end time for repetitive task
     **/
    public int getEndTime() {
        if(!isRepeated()) {
            return time;
        }
        return end;
    }
    public int getCurrentTime(){
        return this.current;
    }
    /** this method returns the interval of repetitive task
    * if task id non repetitive then it returns 0
    **/
    public int getRepeatInterval(){
        if(!isRepeated()){
            return 0;
        }
        return interval;
    }
    /**
    this method sets start time, end time and repetition interval for repetitive task
    and if task is non-repetitive task it is changed to repetitive
     **/
    public void setTime(int start, int end, int interval){
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
    public int nextTimeAfter (int current){
        if(current < end) {
            status=true;
            current += interval;
            return current;
        }
        else{
            status=false;
            return -1;
        }
    }
}
