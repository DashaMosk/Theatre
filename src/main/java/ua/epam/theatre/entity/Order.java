package ua.epam.theatre.entity;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by Daria on 06.02.2016.
 */
public class Order {
    private long id;
    private Timestamp orderDate;
    private ArrayList<Ticket> tickets;
    private User user;

    public Order() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", tickets=" + tickets +
                ", user=" + user +
                '}';
    }
}
