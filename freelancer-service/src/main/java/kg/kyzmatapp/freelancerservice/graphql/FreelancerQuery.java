package kg.kyzmatapp.freelancerservice.graphql;

import graphql.kickstart.annotations.GraphQLQueryResolver;
import kg.kyzmatapp.freelancerservice.models.Freelancer;
import kg.kyzmatapp.freelancerservice.services.FreelancerService;

import java.util.List;

@GraphQLQueryResolver
public class FreelancerQuery{
    private final FreelancerService freelancerService;

    public FreelancerQuery(FreelancerService freelancerService) {
        this.freelancerService = freelancerService;
    }

    public List<Freelancer> getFreelancers() {
        return freelancerService.getAllFreelancers();
    }

    public Freelancer getFreelancer(String freelancerId) {
        return freelancerService.getFreelancer(freelancerId);
    }
}
