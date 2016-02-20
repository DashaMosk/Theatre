package ua.epam.theatre.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by Daria on 06.02.2016.
 */
@Component
@Scope("prototype")
@Entity
@Table(name = "TICKET")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int seatNumber;
    private double price;
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Event event;
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Orders order;
    @ManyToOne
    @PrimaryKeyJoinColumn
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

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
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
        long orderId = 0;
        if(order != null) {
            orderId = order.getId();
        }
        return "Ticket{" +
                "id=" + id +
                ", seatNumber=" + seatNumber +
                ", price=" + price +
                ", event=" + event +
                ", order=" + orderId +
                '}';
    }
}
