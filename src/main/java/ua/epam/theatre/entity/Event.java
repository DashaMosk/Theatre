package ua.epam.theatre.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.epam.theatre.services.impl.Rating;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daria on 06.02.2016.
 */
@Component
@Scope("prototype")
@Entity
@Table(name = "EVENT")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double basePrice;
    private Rating rating;
    @OneToMany(mappedBy = "event")
    @Cascade(CascadeType.ALL)
    private List<Schedule> schedule;

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

    public List<Schedule> getSchedule() {
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

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
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
