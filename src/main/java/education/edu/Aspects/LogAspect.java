package education.edu.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LogAspect {
    /**
     * un code advice
     */

    @Around("@annotation(education.edu.Aspects.Log)")
    /**
     * toutes les méthodes qui ont l'annotation @Log le code
     * advice ci dessous doit etre greffé par le proxy crée par Spring Aop
     */
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long t1 = System.currentTimeMillis();
        System.out.println("From Logging Aspect ... Before "+proceedingJoinPoint.getSignature());
        Object o = proceedingJoinPoint.proceed();
        System.out.println("From Logging Aspect ... After "+proceedingJoinPoint.getSignature());
        System.out.println("Duration"+ (System.currentTimeMillis()-t1));
        return o;

    }
}
