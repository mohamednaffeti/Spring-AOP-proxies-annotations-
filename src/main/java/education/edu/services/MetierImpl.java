package education.edu.services;

import education.edu.Aspects.Log;
import education.edu.Aspects.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    @Override
    @Log
    @SecuredByAspect(roles={"user","admin"})
    public void process() {
        System.out.println("Business layer process");
    }

    @Override
    @SecuredByAspect(roles={"admin"})
    public double compute() {
        double data = 78;
        System.out.println("Business computing and returning");
        return data;
    }
}
