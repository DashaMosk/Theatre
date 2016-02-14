package ua.epam.theatre.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Daria on 06.02.2016.
 */
@Component
@Scope("prototype")
public class User {
    private long id;
    private String email;
    private String name;
    private LocalDate birthDay;
    private Queue<String> messages;

    public User() {
        messages = new ArrayBlockingQueue<String>(100);
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Queue<String> getMessages() {
        return messages;
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public void clearMessagesQueue() {
        messages.clear();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}
