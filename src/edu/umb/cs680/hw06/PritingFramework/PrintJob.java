package edu.umb.cs680.hw06.PritingFramework;

import java.time.LocalDateTime;

public class PrintJob {
    private LocalDateTime jobTime;
    private String data; //Should be replaced with real data object


    public PrintJob(String data) {
        this.jobTime = LocalDateTime.now();
        this.data = data;
    }


    public LocalDateTime getJobTime() {
        return this.jobTime;
    }

    public String getData() {
        return this.data;
    }
    
}
