package ua.epam.theatre.entity;

import org.springframework.stereotype.Component;

/**
 * Created by Daria on 06.02.2016.
 */
@Component
public class Ticket {
    private long id;
    private int seatNumber;
    private double price;
    private Event event;
    private Order order;
    private Schedule schedule;

    public Ticket() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", seatNumber=" + seatNumber +
                ", price=" + price +
                ", event=" + event +
                ", order=" + order +
                '}';
    }
}
