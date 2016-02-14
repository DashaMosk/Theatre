package ua.epam.theatre.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.theatre.entity.Ticket;
import ua.epam.theatre.entity.User;
import ua.epam.theatre.services.BookingService;

import java.util.Date;
import java.util.Random;

/**
 * Created by Daria on 14.02.2016.
 */
@Aspect
@Component
public class LuckyWinnerAspect {

    @Autowired
    BookingService bookingService;

    @Pointcut("execution(* *.bookTicket(..))")
    private void bookTicket() {}

    @Around("bookTicket() && args(user, ticket)")
    public void luckyTicket(ProceedingJoinPoint pjp, User user, Ticket ticket) throws Throwable {
        Date date = new Date();
        Random numb = new Random(date.getTime());
        if(numb.nextInt(10) != 0) {
            pjp.proceed();
        } else {
            bookingService.bookLuckyTicket(user, ticket);
        }
    }

}
