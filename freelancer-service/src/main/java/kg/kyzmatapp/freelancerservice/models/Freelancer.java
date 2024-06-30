package kg.kyzmatapp.freelancerservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
