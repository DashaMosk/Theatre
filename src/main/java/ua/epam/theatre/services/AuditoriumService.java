package ua.epam.theatre.services;

import ua.epam.theatre.entity.Auditorium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daria on 06.02.2016.
 */
public interface AuditoriumService {
    List<Auditorium> getAuditoriums();
    int getSeatsNumber();
    ArrayList<Integer> getVipSeats();

}
