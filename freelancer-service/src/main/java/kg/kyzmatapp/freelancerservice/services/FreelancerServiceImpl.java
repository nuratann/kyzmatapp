package kg.kyzmatapp.freelancerservice.services;

import kg.kyzmatapp.freelancerservice.models.Freelancer;
import kg.kyzmatapp.freelancerservice.models.dtos.FreelancerRegDto;
import kg.kyzmatapp.freelancerservice.repositories.FreelancerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FreelancerServiceImpl implements FreelancerService{

    private final FreelancerRepository freelancerRepository;

    FreelancerServiceImpl(FreelancerRepository freelancerRepository) {
        this.freelancerRepository = freelancerRepository;
    }

    @Override
    public Freelancer getFreelancer(String freelancerId) {
        return freelancerRepository.findById(freelancerId).orElse(null);
    }

    @Override
    public List<Freelancer> getAllFreelancers() {
        return freelancerRepository.findAll();
    }

    @Override
    public Freelancer createFreelancer(Freelancer freelancer) {
        log.info("Creating freelancer {}", freelancer);
        return freelancerRepository.save(freelancer);
    }
}
