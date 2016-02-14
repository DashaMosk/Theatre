package ua.epam.theatre.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.EventStat;
import ua.epam.theatre.entity.Ticket;
import ua.epam.theatre.entity.User;
import ua.epam.theatre.services.EventStatService;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by Daria on 13.02.2016.
 */
@Aspect
@Component
public class CounterAspect {

    @Autowired
    EventStatService statService;

    @Pointcut("execution(* *.getByName(..)) && within(ua.epam.theatre.services.impl.EventServiceImpl)")
    private void getByNameMethod() {}

    @Pointcut("execution(* *.getTicketPrice(..))")
    private void getTicketPriceMethod() {}

    @Pointcut("execution(* *.bookTicket(..))")
    private void bookTicket() {}

    @AfterReturning(pointcut = "getByNameMethod()", returning = "retVal")
    public void getByNameCount(Object retVal) {
        ArrayList<Event> events = (ArrayList<Event>)retVal;
        for(Event e : events) {
            EventStat eventStat = statService.findByEvent(e);
            if(eventStat == null) {
                eventStat = new EventStat();
                eventStat.setEvent(e);
                statService.save(eventStat);
            }
            eventStat.increseAccessCount();
        }
    }

    @Before("getTicketPriceMethod() && args(event, *, *)")
    public void getPriceCount(Event event) {
        EventStat eventStat = statService.findByEvent(event);
        if(eventStat == null) {
            eventStat = new EventStat();
            eventStat.setEvent(event);
            statService.save(eventStat);
        }
        eventStat.incresePriceQueriedCount();
    }

    @After("bookTicket() && args(*, ticket)")
    public void bookTicketCount(Ticket ticket) {
        Event event = ticket.getEvent();
        EventStat eventStat = statService.findByEvent(event);
        if(eventStat == null) {
            eventStat = new EventStat();
            eventStat.setEvent(event);
            statService.save(eventStat);
        }
        eventStat.increseBookedCount();
    }
}
