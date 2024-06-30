package kg.kyzmatapp.freelancerservice.repositories;

import kg.kyzmatapp.freelancerservice.models.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelancerRepository extends JpaRepository<Freelancer, String> {
}
