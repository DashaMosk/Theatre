package ua.epam.theatre.entity;

import javax.persistence.*;

/**
 * Created by Daria on 14.02.2016.
 */
@Entity
@Table(name = "EVENTSTAT")
public class EventStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private int accessCount;
    private int priceQueriedCount;
    private int bookedCount;
    private long eventId;

    public EventStat() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public int getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(int accessCount) {
        this.accessCount = accessCount;
    }

    public int getPriceQueriedCount() {
        return priceQueriedCount;
    }

    public void setPriceQueriedCount(int priceQueriedCount) {
        this.priceQueriedCount = priceQueriedCount;
    }

    public int getBookedCount() {
        return bookedCount;
    }

    public void setBookedCount(int bookedCount) {
        this.bookedCount = bookedCount;
    }

    public void increseAccessCount() {
        accessCount++;
    }

    public void incresePriceQueriedCount() {
        priceQueriedCount++;
    }

    public  void increseBookedCount() {
        bookedCount++;
    }

    @Override
    public String toString() {
        return "EventStat{" +
                "eventId=" + eventId +
                ", accessCount=" + accessCount +
                ", priceQueriedCount=" + priceQueriedCount +
                ", bookedCount=" + bookedCount +
                '}';
    }
}
