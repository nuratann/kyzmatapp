package kg.kyzmatapp.freelancerservice.controllers;

import kg.kyzmatapp.freelancerservice.models.Freelancer;
import kg.kyzmatapp.freelancerservice.services.FreelancerService;
import kg.kyzmatapp.freelancerservice.utils.FreelancerUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@GraphQlTest(FreelancerController.class)
@AutoConfigureGraphQlTester
public class FreelancerControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    private FreelancerService freelancerService;

    @Test
    void testGetAllFreelancers() {

        List<Freelancer> freelancers = FreelancerUtils.RandomFreelancers(5);
        when(freelancerService.getAllFreelancers()).thenReturn(freelancers);

        //language=GraphQl
        String query = """
                query {
                    getAllFreelancers {
                        id
                        firstName
                        lastName
                        email
                        phone
                        description
                        categories
                        rating
                        reviews
                        teams
                    }
                }
                """;

        graphQlTester.document(query).execute()
                .path("getAllFreelancers")
                .entityList(Freelancer.class)
                .hasSize(5);
    }

    @Test
    void testGetFreelancerById() {
        Freelancer freelancer = FreelancerUtils.RandomFreelancer();
        String id = freelancer.getId();
        when(freelancerService.getFreelancer(id)).thenReturn(freelancer);


        //language=GraphQl
        String query = """
                query getFreelancerById($id: ID!){
                    getFreelancerById(id: $id) {
                        id
                        firstName
                        lastName
                        email
                        phone
                        description
                        categories
                        rating
                        reviews
                        teams
                    }
                }
                """;

        graphQlTester.document(query).variable("id", id).execute()
                .path("getFreelancerById").entity(Freelancer.class)
                .satisfies(response -> {
                    assertEquals(response.getId(), freelancer.getId());
                    assertEquals(response.getFirstName(), freelancer.getFirstName());
                });

    }

    @Test
    void testCreateFreelancer() {
        Freelancer freelancer = Freelancer.builder()
                .id(UUID.randomUUID().toString())
                .firstName("James")
                .lastName("Duke")
                .email("jd@mail.com")
                .phone("+29352093762")
                .description("aedrtfgaedrftaergaerfae")
                .teams(new HashSet<>())
                .categories(new HashSet<>())
                .reviews(new HashSet<>())
                .rating(3.9f)
                .build();
        when(freelancerService.createFreelancer(any(Freelancer.class))).thenReturn(freelancer);

        //language=GraphQl
        String query = """
                    mutation CreateFreelancer {
                        createFreelancer(
                            freelancer: {
                                firstName: "James"
                                lastName: "Duke"
                                email: "jd@mail.com"
                                phone: "+29352093762"
                                description: "aedrtfgaedrftaergaerfae"
                                categories: []
                                rating: 3.9
                                reviews: []
                                teams: []
                            }
                        ) {
                            id
                            firstName
                            lastName
                            email
                            phone
                            description
                            categories
                            rating
                            reviews
                            teams
                        }
                    }
                """;

        graphQlTester.document(query)
                .execute()
                .path("createFreelancer")
                .entity(Freelancer.class)
                .satisfies(response -> {
                    assertEquals(response.getFirstName(), freelancer.getFirstName());
                    assertEquals(response.getEmail(), freelancer.getEmail());
                });
    }
}