package ua.epam.theatre.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.epam.theatre.services.impl.Rating;

import java.util.ArrayList;

/**
 * Created by Daria on 06.02.2016.
 */
@Component
@Scope("prototype")
public class Event {
    private long id;
    private String name;
    private double basePrice;
    private ArrayList<Schedule> schedule;
    private Rating rating;

    public Event() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public ArrayList<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<Schedule> schedule) {
        this.schedule = schedule;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name +
                ", basePrice=" + basePrice +
                ", rating=" + rating +
                '}';
    }
}
