package ua.epam.theatre.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Daria on 06.02.2016.
 */
public class Auditorium {
    private String name;
    private int numberOfSeats;
    private ArrayList<Integer> vip;

    public Auditorium() {}

    public Auditorium(String name, int numberOfSeats, String auditorStr) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        vip = new ArrayList<Integer>();
        String [] arr = auditorStr.split(",");
        for(String a : arr) {
            vip.add(Integer.parseInt(a));
        }

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public ArrayList<Integer> getVip() {
        return vip;
    }

    public void setVip(ArrayList<Integer> vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "name='" + name + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", vip=" + vip +
                '}';
    }
}
