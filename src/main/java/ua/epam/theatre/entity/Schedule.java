package ua.epam.theatre.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by Daria_Moskalenko on 2/8/2016.
 */
@Component
@Scope("prototype")
public class Schedule {
    private long id;
    private Event event;
    private Timestamp startTime;
    private Timestamp endTime;
    private Auditorium auditorium;

    public Schedule(){}

    public Schedule(Event event){
        this.event = event;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }


    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", event=" + event +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", auditorium=" + auditorium +
                '}';
    }
}
