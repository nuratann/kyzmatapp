package kg.kyzmatapp.freelancerservice.controllers;

import kg.kyzmatapp.freelancerservice.models.Freelancer;
import kg.kyzmatapp.freelancerservice.models.dtos.FreelancerRegDto;
import kg.kyzmatapp.freelancerservice.services.FreelancerService;
import kg.kyzmatapp.freelancerservice.utils.FreelancerUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FreelancerControllerTest {
    @Mock
    private FreelancerService freelancerService;

    @InjectMocks
    private FreelancerController freelancerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllFreelancers() {
        //Setup
        List<Freelancer> freelancers = FreelancerUtils.RandomFreelancers(5);
        when(freelancerService.getAllFreelancers()).thenReturn(freelancers);

        // Execute
        List<Freelancer> result = freelancerController.getAllFreelancers();

        // Verify
        assertEquals(5, result.size());
        assertEquals(freelancers.get(0), result.get(0));
        assertEquals(freelancers.get(1), result.get(1));
        assertEquals(freelancers.get(2), result.get(2));
        assertEquals(freelancers.get(3), result.get(3));
        assertEquals(freelancers.get(4), result.get(4));
        verify(freelancerService).getAllFreelancers();
    }

    @Test
    void testGetFreelancerById() {
        // Setup
        Freelancer freelancer = FreelancerUtils.RandomFreelancer();
        String id = freelancer.getId();
        when(freelancerService.getFreelancer(id)).thenReturn(freelancer);

        // Execute
        Freelancer result = freelancerController.getFreelancerById(id);

        // Verify
        assertEquals(freelancer, result);
        verify(freelancerService).getFreelancer(id);
    }

    @Test
    void testCreateFreelancer() {
        // Setup
        FreelancerRegDto freelancerRegDto = FreelancerUtils.RandomFreelancerRegDto();
        Freelancer freelancer = FreelancerUtils.ConvertToFreelancer(freelancerRegDto);
        when(freelancerService.createFreelancer(freelancer)).thenReturn(freelancer);

        // Execute
        Freelancer result = freelancerController.createFreelancer(freelancerRegDto);

        // Verify
        assertEquals(freelancer, result);
        verify(freelancerService).createFreelancer(freelancer);
    }
}
