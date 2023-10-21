package programmers;

import java.util.*;

public class P02 {

    public int solution(int [] priorities,int location) {
        //1. Queue를 만든다.
        List<PrintJob> printer = new ArrayList<PrintJob>();

        for (int i = 0; i < priorities.length; i++) {

            printer.add(new PrintJob(priorities[i], i));
        }

        int turn = 0;

        while (!printer.isEmpty()) {

            PrintJob job = printer.remove(0);

            if (printer.stream().anyMatch(anyJob -> job.priority < anyJob.priority)) {
                printer.add(job);
            } else{
                turn++;
                if (location == job.location) {
                    break;
                }
            }
        }


        return turn;
    }


}


class PrintJob{
    int priority;
    int location;

    public PrintJob(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
}