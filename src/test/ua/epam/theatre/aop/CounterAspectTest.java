package ua.epam.theatre.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.EventStat;
import ua.epam.theatre.entity.Ticket;
import ua.epam.theatre.services.EventStatService;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


/**
 * Created by Daria_Moskalenko on 2/15/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CounterAspectTest {

    @Mock
    EventStatService statService;

    @Mock
    Ticket ticket;

    @InjectMocks
    CounterAspect counterAspect = new CounterAspect();

    @Test
    public void testGetByNameCount() throws Exception {
        Event event = new Event();
        ArrayList<Event> arrEvent = new ArrayList<Event>();
        arrEvent.add(event);
        when(statService.findByEvent(any(Event.class))).thenReturn(null);
        counterAspect.getByNameCount(arrEvent);
        verify(statService).save(any(EventStat.class));
    }

    @Test
    public void testGetPriceCount() throws Exception {
        when(statService.findByEvent(any(Event.class))).thenReturn(null);
        counterAspect.getPriceCount(any(Event.class));
        verify(statService).save(any(EventStat.class));
    }

    @Test
    public void testBookTicketCount() throws Exception {
        when(statService.findByEvent(any(Event.class))).thenReturn(null);
        when(ticket.getEvent()).thenReturn(new Event());
        counterAspect.bookTicketCount(ticket);
        verify(statService).save(any(EventStat.class));
    }
}