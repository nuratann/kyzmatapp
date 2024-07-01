package kg.kyzmatapp.freelancerservice.controllers;

import kg.kyzmatapp.freelancerservice.models.Freelancer;
import kg.kyzmatapp.freelancerservice.models.dtos.FreelancerRegDto;
import kg.kyzmatapp.freelancerservice.services.FreelancerService;
import kg.kyzmatapp.freelancerservice.utils.FreelancerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class FreelancerController {
    private final FreelancerService freelancerService;

    @QueryMapping
    public List<Freelancer> getAllFreelancers() {
        return freelancerService.getAllFreelancers();
    }

    @QueryMapping
    public Freelancer getFreelancerById(@Param("id") String id) {
        return freelancerService.getFreelancer(id);
    }

    @MutationMapping
    public Freelancer createFreelancer(@Argument FreelancerRegDto freelancer) {
        return freelancerService.createFreelancer(FreelancerUtils.ConvertToFreelancer(freelancer));
    }
}
