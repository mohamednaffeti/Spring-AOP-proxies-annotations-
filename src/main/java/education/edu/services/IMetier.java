package education.edu.services;

import org.springframework.stereotype.Service;

@Service
public interface IMetier {
    void process();
    double compute();
}
