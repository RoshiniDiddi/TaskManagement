package mx.tc.j2se.tasks;

public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String s) {
        System.out.println(s);
    }
}
