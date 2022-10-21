package mx.tc.j2se.tasks;
public class Main {
    public static void main(String[] args) {
        Task t1=new Task("Morning Run",3,15,2);
        Task t2=new Task("Reading Book",8,10,2);
        Task t3=new Task("Playing badminton",9);
        /***if(t1.isRepeated()){
            t1.current=t1.start;
            while(t1.current< t1.getEndTime()) {
                System.out.println(t1.getTitle()+ " " + t1.getCurrentTime());
                t1.current += t1.getRepeatInterval();
                if(t1.current < t1.getEndTime()){
                    t1.setActive(true);}
                else{t1.setActive(false);}
                System.out.println(t1.isActive());
            }
        }**/
        ArrayTaskList atl=new ArrayTaskList();
        atl.add(t1);
        atl.add(t2);
        atl.add(t3);
        atl.display();
        //atl.remove(t2);
        //atl.display();
        //System.out.println(atl.size());
        //System.out.println(atl.getTask(1).getTitle());

        atl.incoming(5,10).display();
    }
}
