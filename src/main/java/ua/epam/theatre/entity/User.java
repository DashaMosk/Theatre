package ua.epam.theatre.entity;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by Daria on 06.02.2016.
 */
@Component
public class User {
    private long id;
    private String email;
    private String name;
    private LocalDate birthDay;

    public User() {}
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
