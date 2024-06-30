package kg.kyzmatapp.freelancerservice.services;

import kg.kyzmatapp.freelancerservice.models.Freelancer;

import java.util.List;

public interface FreelancerService {
    Freelancer getFreelancer(String freelancerId);
    List<Freelancer> getAllFreelancers();
    Freelancer createFreelancer(Freelancer freelancer);
}
