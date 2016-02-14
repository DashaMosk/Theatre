package ua.epam.theatre.entity;

/**
 * Created by Daria on 14.02.2016.
 */
public class EventStat {
    private  int id;
    private int accessCount;
    private int priceQueriedCount;
    private int bookedCount;
    private Event event;

    public EventStat() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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
                "event=" + event.getName() +
                ", accessCount=" + accessCount +
                ", priceQueriedCount=" + priceQueriedCount +
                ", bookedCount=" + bookedCount +
                '}';
    }
}
