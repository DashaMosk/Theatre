package ua.epam.theatre.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Daria_Moskalenko on 2/8/2016.
 */
@Component
@Scope("prototype")
@Entity
@Table(name="SCHEDULE")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "schedule")
    private Event event;
    private Timestamp startTime;
    private Timestamp endTime;
    @Transient
    private Auditorium auditorium;
    @OneToMany(mappedBy = "schedule")
    @Cascade(CascadeType.ALL)
    private List<Ticket> ticket;

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

    public List<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
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
