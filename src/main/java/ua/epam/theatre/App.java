package ua.epam.theatre;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.epam.theatre.aop.DiscountAspect;
import ua.epam.theatre.dao.impl.TheatreDB;
import ua.epam.theatre.entity.*;
import ua.epam.theatre.services.*;
import ua.epam.theatre.services.impl.Rating;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

/**
 * Created by Daria on 07.02.2016.
 */
public class App {

    public static void main(String[] args) throws ParseException {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("<<< Start >>>");
        Event event1 = ctx.getBean(Event.class);
        event1.setName("King Lear");
        event1.setBasePrice(100.0);
        event1.setRating(Rating.HIGH);
        Schedule schedule1 = ctx.getBean(Schedule.class);
        schedule1.setEvent(event1);
        schedule1.setStartTime(Timestamp.valueOf("2016-03-01 19:00:00"));
        schedule1.setEndTime(Timestamp.valueOf("2016-03-01 22:00:00"));
        ArrayList<Schedule> schedules1 = new ArrayList<Schedule>();
        schedules1.add(schedule1);
        event1.setSchedule(schedules1);
        Event event2 = ctx.getBean(Event.class);
        event2.setName("Concert of classical music");
        event2.setBasePrice(80.0);
        event2.setRating(Rating.LOW);
        Schedule schedule2 = ctx.getBean(Schedule.class);
        schedule2.setEvent(event2);
        schedule2.setStartTime(Timestamp.valueOf("2016-03-02 19:00:00"));
        schedule2.setEndTime(Timestamp.valueOf("2016-03-02 22:00:00"));
        ArrayList<Schedule> schedules2 = new ArrayList<Schedule>();
        schedules2.add(schedule2);
        event2.setSchedule(schedules2);
        Event event3 = ctx.getBean(Event.class);
        event3.setName("Romeo and Juliet");
        event3.setBasePrice(120.0);
        event3.setRating(Rating.MID);
        Schedule schedule3 = ctx.getBean(Schedule.class);
        schedule3.setEvent(event3);
        schedule3.setStartTime(Timestamp.valueOf("2016-03-03 19:00:00"));
        schedule3.setEndTime(Timestamp.valueOf("2016-03-03 22:00:00"));
        ArrayList<Schedule> schedules3 = new ArrayList<Schedule>();
        schedules3.add(schedule3);
        event3.setSchedule(schedules3);

        EventService eventService = ctx.getBean(EventService.class);
        eventService.create(event1);
        eventService.create(event2);
        eventService.create(event3);

        AuditoriumService auditoriumService = ctx.getBean(AuditoriumService.class);
        List<Auditorium> auditoriums = auditoriumService.getAuditoriums();
        eventService.assignAuditorium(event1, auditoriums.get(0), LocalDateTime.of(2016, Month.MARCH, 1, 19, 0));
        eventService.assignAuditorium(event2, auditoriums.get(1), LocalDateTime.of(2016, Month.MARCH, 1, 19, 0));
        eventService.assignAuditorium(event3, auditoriums.get(2), LocalDateTime.of(2016, Month.MARCH, 1, 19, 0));

        User user1 = ctx.getBean(User.class);
        user1.setName("Daria Moskalenko");
        user1.setEmail("dmoskalenko@epam.com");
        user1.setBirthDay(LocalDate.of(1990, Month.MARCH, 3));
        UserService userService = ctx.getBean(UserService.class);
        userService.register(user1);

        Collection<Event> events = eventService.getAll();
        System.out.println("Get all events: ");
        for(Event e : events) {
            System.out.println(e);
        }

        System.out.println("Find event: ");
        List<Event> eventToFind = eventService.getByName("Romeo and Juliet");
        for(Event e : eventToFind) {
            System.out.println(e);
        }

        eventService.getByName("Romeo and Juliet"); // for stat

        BookingService bookingService = ctx.getBean(BookingService.class);
        TicketService ticketService = ctx.getBean(TicketService.class);
        Ticket ticket1 = ctx.getBean(Ticket.class);
        ticket1.setEvent(event1);
        ticket1.setSeatNumber(100);
        ticket1.setPrice(bookingService.getTicketPrice(event1, 100, Timestamp.valueOf("2016-03-01 19:00:00")));
        ticket1.setSchedule(schedule1);
        ticketService.save(ticket1);
        Ticket ticket2 = ctx.getBean(Ticket.class);
        ticket2.setEvent(event2);
        ticket2.setSeatNumber(100);
        ticket2.setPrice(bookingService.getTicketPrice(event2, 100, Timestamp.valueOf("2016-03-02 19:00:00")));
        ticket2.setSchedule(schedule2);
        ticketService.save(ticket2);
        Ticket ticket3 = ctx.getBean(Ticket.class);
        ticket3.setEvent(event3);
        ticket3.setSeatNumber(9);
        ticket3.setPrice(bookingService.getTicketPrice(event3, 9, Timestamp.valueOf("2016-03-03 19:00:00")));
        ticket3.setSchedule(schedule3);
        ticketService.save(ticket3);

        bookingService.bookTicket(user1, ticket3);
        bookingService.bookTicket(user1, ticket2);

        eventService.remove(event2);

        System.out.println("Booked tickets for "+ user1.getName());
        List<Order> orders = userService.getBookedTickets(user1);
        for(Order o : orders) {
            for(Ticket t : o.getTickets()) {
                System.out.println(t);
            }
        }
        System.out.println("Messages to user");
        Queue<String> mess = user1.getMessages();
        for(String s : mess) {
            System.out.println(s);
        }

        System.out.println("Find user by name: ");
        List<User> users = userService.getUserByName("Daria Moskalenko");
        for(User u : users) {
            System.out.println(u);
        }

        System.out.println("Find user by email: ");
        System.out.println(userService.getUserByEmail("dmoskalenko@epam.com"));

        System.out.println("VIP seats :");
        System.out.println(auditoriumService.getVipSeats());

        System.out.println("Seats number");
        System.out.println(auditoriumService.getSeatsNumber());

        userService.remove(user1);
        System.out.println("Find user by email: ");
        System.out.println(userService.getUserByEmail("dmoskalenko@epam.com"));

        System.out.println("Tickets for "+event1.getName());
        ArrayList<Ticket> tickets = bookingService.getTicketsForEvent(event1);
        for(Ticket t : tickets) {
            System.out.println(t);
        }

        System.out.println("Events stat:");
        for(EventStat eventStat : TheatreDB.eventStatMap.values()) {
            System.out.println(eventStat);
        }

        System.out.println("Discount stat:");
        DiscountAspect discountAspect = ctx.getBean(DiscountAspect.class);
        for(DiscontStat d : discountAspect.getDiscontStats()) {
            System.out.println(d);
        }

        for(Map.Entry<Class<?>, Integer> entry : discountAspect.getTotalCounter().entrySet()) {
            System.out.println(entry.getKey()+ " count= "+entry.getValue());
        }

    }
}
