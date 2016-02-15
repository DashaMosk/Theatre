package ua.epam.theatre.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.theatre.dao.EventStatDao;
import ua.epam.theatre.entity.Event;
import ua.epam.theatre.entity.EventStat;
import ua.epam.theatre.services.EventStatService;

/**
 * Created by Daria on 14.02.2016.
 */
@Service
public class EventStatServiceImpl implements EventStatService{

    @Autowired
    private EventStatDao eventStatDao;

    public void save(EventStat eventStat) {
        eventStatDao.save(eventStat);
    }

    public void remove(EventStat eventStat) {
        eventStatDao.remove(eventStat);
    }

    public EventStat findByEvent(Event event) {
        return eventStatDao.findByEvent(event);
    }
}
