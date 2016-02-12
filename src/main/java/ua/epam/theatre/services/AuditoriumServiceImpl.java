package ua.epam.theatre.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.theatre.entity.Auditorium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daria on 06.02.2016.
 */
@Service
public class AuditoriumServiceImpl implements AuditoriumService {
    @Autowired
    List<Auditorium> auditoriums;

    public List<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(List<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    public int getSeatsNumber() {
        int sNum = 0;
        for (Auditorium a : auditoriums) {
            sNum += a.getNumberOfSeats();
        }
        return sNum;
    }

    public ArrayList<Integer> getVipSeats() {
        ArrayList<Integer> vip = new ArrayList<Integer>();
        for (Auditorium a : auditoriums) {
            vip.addAll(a.getVip());
        }
        return vip;
    }
}
