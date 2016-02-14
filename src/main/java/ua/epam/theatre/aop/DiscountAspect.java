package ua.epam.theatre.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ua.epam.theatre.entity.DiscontStat;
import ua.epam.theatre.entity.User;
import ua.epam.theatre.services.DiscountStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daria on 14.02.2016.
 */
@Aspect
@Component
public class DiscountAspect {

    private Map<Class<?>, Integer> totalCounter;
    private ArrayList<DiscontStat> discontStats;

    public DiscountAspect () {
        totalCounter = new HashMap<Class<?>, Integer>();
        discontStats = new ArrayList<DiscontStat>();
    }

    public Map<Class<?>, Integer> getTotalCounter() {
        return totalCounter;
    }

    public ArrayList<DiscontStat> getDiscontStats() {
        return discontStats;
    }

    private DiscontStat find(User user, DiscountStrategy strategy) {
        for(DiscontStat d : discontStats ) {
            if(d.getDiscont().equals(strategy) && d.getUser().equals(user)) {
                return  d;
            }
        }
        return  null;
    }

    @Pointcut("execution(* *.getDiscount(..)) && this(ua.epam.theatre.services.DiscountStrategy)")
    private void getDiscountMethod(){}

    @AfterReturning(pointcut = "getDiscountMethod() && args(user,*,*)", returning = "retVal")
    public void discountCount(JoinPoint jp, User user, Object retVal) {
        Double disc = (Double) retVal;
        if(disc.doubleValue() > 0.0) {
            Class<?> clazz = jp.getTarget().getClass();
            if (!totalCounter.containsKey(clazz)) {
                totalCounter.put(clazz, 0);
            }
            totalCounter.put(clazz, totalCounter.get(clazz) + 1);
            DiscontStat discontStat = find(user, (DiscountStrategy) jp.getThis());
            if (discontStat == null) {
                discontStat = new DiscontStat();
                discontStat.setDiscont((DiscountStrategy) jp.getThis());
                discontStat.setUser(user);
                discontStats.add(discontStat);
            }
            discontStat.increaseCount();
        }
    }

}
