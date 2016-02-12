package ua.epam.theatre.dao;

import org.springframework.stereotype.Repository;
import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.Order;
import ua.epam.theatre.entity.Ticket;

import java.util.ArrayList;

/**
 * Created by Daria on 06.02.2016.
 */
@Repository
public class BookingDaoImpl implements BookingDao {

    public void saveOrder(Order order) {
        order.setId(TheatreDB.orders.size()+1);
        TheatreDB.orders.put(TheatreDB.orders.size()+1, order);
    }

    public ArrayList<Ticket> getTicketsForEvent(Event event) {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        for(Ticket t : TheatreDB.ticks.values()){
            if(t.getEvent().equals(event)) {
                tickets.add(t);
            }
        }
        return tickets;
    }
}
