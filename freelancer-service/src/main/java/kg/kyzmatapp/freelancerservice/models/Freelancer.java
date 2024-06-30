package kg.kyzmatapp.freelancerservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Freelancer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String firstName;
    private String lastName;

    private String email;
    private String phone;

    @Column(columnDefinition = "TEXT")
    private String description;
    @ElementCollection
    private Set<String> categories;
    private Float rating;
    @ElementCollection
    private Set<String> reviews;
    @ElementCollection
    private Set<String> teams;
}
