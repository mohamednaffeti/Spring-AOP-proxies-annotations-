package education.edu.services;

import java.util.Arrays;
import java.util.Optional;

public class SecurityContext {
    public static String username ="";
    public static String password ="";
    private static String[] roles={};

    public static void authentifier(String u,String p,String[] r){
        if(u.equals("root") && p.equals("1234")){
            username=u;
            password=p;
            roles=r;

        }else{
            throw new RuntimeException("user n'est pas valide");
        }
    }

    public static boolean hasRole(String r){
       Optional<String> test= Arrays.stream(roles).filter(e->e.equals(r)).findAny();
        return (test.isPresent()) ? true : false;
    }
}
