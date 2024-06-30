package kg.kyzmatapp.freelancerservice.models.dtos;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
public class FreelancerRegDto {

    private String firstName;
    private String lastName;

    private String email;
    private String phone;

    private String description;
    private Set<String> categories;
    private Float rating;
    private Set<String> reviews;
    private Set<String> teams;

}
