package ss3_OOP.BaiTap.StopWatch;

import java.util.Date;

public class StopWatch {
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public StopWatch() {
        Date i= new Date();
        this.startTime =i.getTime();
    }
    public void start(){
        Date i= new Date();
        this.endTime =i.getTime();
    }

    public void stop() {
        Date i= new Date();
        this.startTime =i.getTime();
    }
    public long getElapsedTime(){
        return  this.endTime-this.startTime;
    }
}
