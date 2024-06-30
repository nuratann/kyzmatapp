package kg.kyzmatapp.freelancerservice.services;

import kg.kyzmatapp.freelancerservice.models.Freelancer;
import kg.kyzmatapp.freelancerservice.models.dtos.FreelancerRegDto;
import kg.kyzmatapp.freelancerservice.repositories.FreelancerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Freelancer createFreelancer(FreelancerRegDto freelancerRegDto) {
        Freelancer freelancer = Freelancer.builder()
                .firstName(freelancerRegDto.getFirstName())
                .lastName(freelancerRegDto.getLastName())
                .email(freelancerRegDto.getEmail())
                .phone(freelancerRegDto.getPhone())
                .description(freelancerRegDto.getDescription())
                .teams(freelancerRegDto.getTeams())
                .rating(freelancerRegDto.getRating())
                .reviews(freelancerRegDto.getReviews())
                .categories(freelancerRegDto.getCategories())
                .build();

        return freelancerRepository.save(freelancer);
    }
}
