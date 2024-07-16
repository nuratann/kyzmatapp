package kg.kyzmatapp.freelancerservice.services;

import kg.kyzmatapp.freelancerservice.models.Freelancer;
import kg.kyzmatapp.freelancerservice.repositories.FreelancerRepository;
import kg.kyzmatapp.freelancerservice.utils.FreelancerUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class FreelancerServiceTest {
    @MockBean
    private FreelancerRepository freelancerRepository;

    @Autowired
    private FreelancerServiceImpl freelancerService;

    @Test
    void getFreelancerShouldReturnFreelancer() {
        Freelancer freelancer = FreelancerUtils.RandomFreelancer();
        when(freelancerRepository.findById(freelancer.getId())).thenReturn(Optional.of(freelancer));

        Freelancer fromService = freelancerService.getFreelancer(freelancer.getId());
        assertEquals(freelancer, fromService);
    }

    @Test
    void getAllFreelancers() {
        List<Freelancer> freelancers = FreelancerUtils.RandomFreelancers(5);
        when(freelancerRepository.findAll()).thenReturn(freelancers);

        List<Freelancer> fromService = freelancerService.getAllFreelancers();
        for(int i = 0; i < fromService.size(); i++) {
           assertEquals(freelancers.get(i), fromService.get(i));
        }
    }

    @Test
    void createFreelancer() {
        Freelancer freelancer = FreelancerUtils.RandomFreelancer();
        when(freelancerRepository.save(any(Freelancer.class))).thenReturn(freelancer);

        Freelancer fromRepo = freelancerService.createFreelancer(freelancer);
        assertEquals(freelancer, fromRepo);
    }
}