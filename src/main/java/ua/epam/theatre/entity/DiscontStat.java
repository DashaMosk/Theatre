package ua.epam.theatre.entity;

import ua.epam.theatre.services.DiscountStrategy;

/**
 * Created by Daria on 14.02.2016.
 */
public class DiscontStat {
    private DiscountStrategy discont;
    private User user;
    private int count;

    public DiscontStat() {};

    public DiscountStrategy getDiscont() {
        return discont;
    }

    public void setDiscont(DiscountStrategy discont) {
        this.discont = discont;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increaseCount() {
        count++;
    }

    @Override
    public String toString() {
        return "DiscontStat{" +
                "discont=" + discont.toString() +
                ", user=" + user.getName() +
                ", count=" + count +
                '}';
    }
}
