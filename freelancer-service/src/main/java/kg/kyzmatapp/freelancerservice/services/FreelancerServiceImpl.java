package kg.kyzmatapp.freelancerservice.services;

import kg.kyzmatapp.freelancerservice.models.Freelancer;
import kg.kyzmatapp.freelancerservice.repositories.FreelancerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreelancerServiceImpl implements FreelancerService{

    FreelancerRepository freelancerRepository;

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
        return freelancerRepository.save(freelancer);
    }
}
