package education.edu.Aspects;

import education.edu.services.SecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AuthorisationAspect {

    @Around(value="@annotation(securedByAspect)",argNames="proceedingJoinPoint,securedByAspect")
    public Object secure(ProceedingJoinPoint proceedingJoinPoint,SecuredByAspect securedByAspect) throws Throwable {
           String[] roles = securedByAspect.roles();
           boolean authorized = false;
           for (String r : roles){
               if(SecurityContext.hasRole(r)){
                   authorized = true;
                   break;
               }
           }
           if(authorized){
              Object result= proceedingJoinPoint.proceed();
               return result;
           }
           throw new RuntimeException("tu n'est pas autorisé -> status 403");
    }
}
