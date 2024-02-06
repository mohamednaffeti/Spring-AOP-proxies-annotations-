package education.edu;

import education.edu.services.IMetier;
import education.edu.services.MetierImpl;
import education.edu.services.SecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"education.edu"})
public class Application {

    public static void main(String[] args) {

        SecurityContext.authentifier("root","1234",new String[]{"user"});

      //  ApplicationContext applicationContext = new AnnotationConfigApplicationContext("education.eud");
       // IMetier metier = applicationContext.getBean(MetierImpl.class);
        /**
         * en utilisant @componantScan -> dans spring boot @SpringBootApplication pour
         *         scanner les beans qui se trouves depuis la racines
          */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
        IMetier metier = applicationContext.getBean(IMetier.class);
        System.out.println(metier.getClass().getName());
        metier.process();
        System.out.println(metier.compute());

    }
}