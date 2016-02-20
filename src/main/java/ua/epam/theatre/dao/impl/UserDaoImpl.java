package ua.epam.theatre.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.epam.theatre.dao.UserDao;
import ua.epam.theatre.entity.Orders;
import ua.epam.theatre.entity.Ticket;
import ua.epam.theatre.entity.User;

import java.util.List;

/**
 * Created by Daria on 07.02.2016.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void register(User user) {
        getSession().persist(user);
    }

    public void remove(User user) {
        getSession().delete(user);
    }

    public User getUserByEmail(String email) {
        Query query = getSession().createQuery("from User where email= :uemail");
        query.setString("uemail", email);
        User usr = (User) query.uniqueResult();
        return usr;
    }

    public List<User> getUserByName(String name) {
        Query query = getSession().createQuery("from User where name= :uname");
        query.setString("uname", name);
        List<User> usr = query.list();
        return usr;
    }

    public List<Ticket> getBookedTickets(User user) {
        Query query = getSession().createQuery("from Orders where user= :user").setEntity("user", user);
        List<Orders> orders = query.list();
        Query query1 = getSession().createQuery("from Ticket t where t.order in (:ord)");
        query1.setParameterList("ord", orders);
        List<Ticket> tickets = query1.list();
        return tickets;
    }
}
