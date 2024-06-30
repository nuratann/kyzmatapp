package kg.kyzmatapp.freelancerservice.graphql;

import graphql.kickstart.annotations.GraphQLMutationResolver;
import kg.kyzmatapp.freelancerservice.models.Freelancer;
import kg.kyzmatapp.freelancerservice.services.FreelancerService;

@GraphQLMutationResolver
public class FreelancerMutation {
    private final FreelancerService freelancerService;

    FreelancerMutation(final FreelancerService freelancerService) {
        this.freelancerService = freelancerService;
    }

    public Freelancer createFreelancer(Freelancer freelancer){
        return freelancerService.createFreelancer(freelancer);
    }
}
