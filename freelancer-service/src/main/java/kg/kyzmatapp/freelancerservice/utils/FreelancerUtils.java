package kg.kyzmatapp.freelancerservice.utils;

import kg.kyzmatapp.freelancerservice.models.Freelancer;
import kg.kyzmatapp.freelancerservice.models.dtos.FreelancerRegDto;

import java.util.*;

public class FreelancerUtils {
    public static Freelancer RandomFreelancer() {
        return Freelancer.builder()
                .id(UUID.randomUUID().toString())
                .firstName(RandomStringGenerator.generateRandomString(10))
                .lastName(RandomStringGenerator.generateRandomString(10))
                .email(RandomStringGenerator.generateRandomEmail())
                .phone(RandomStringGenerator.generateRandomPhone(9))
                .teams(new HashSet<>())
                .categories(new HashSet<>())
                .description(RandomStringGenerator.generateRandomString(50))
                .reviews(new HashSet<>())
                .rating(new Random().nextFloat(1,5))
                .build();
    }

    public static List<Freelancer> RandomFreelancers(int length) {
        List<Freelancer> freelancers = new ArrayList<Freelancer>();
        for (int i = 0; i < length; i++) {
            freelancers.add(RandomFreelancer());
        }
        return freelancers;
    }

    public static FreelancerRegDto RandomFreelancerRegDto() {
        return ConvertToFreelancerRegDto(RandomFreelancer());
    }

    public static Freelancer ConvertToFreelancer(FreelancerRegDto freelancerRegDto) {
        return Freelancer.builder()
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
    }

    public static FreelancerRegDto ConvertToFreelancerRegDto(Freelancer freelancer) {
        return FreelancerRegDto.builder()
                .firstName(freelancer.getFirstName())
                .lastName(freelancer.getLastName())
                .email(freelancer.getEmail())
                .phone(freelancer.getPhone())
                .description(freelancer.getDescription())
                .teams(freelancer.getTeams())
                .rating(freelancer.getRating())
                .reviews(freelancer.getReviews())
                .categories(freelancer.getCategories())
                .build();
    }
}
