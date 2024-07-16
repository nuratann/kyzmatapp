package models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "categories")
public class Category {
    @Id
    private Integer id;
    private String name;
    @ManyToOne
    private Category parent;
    @Column(columnDefinition = "json")
    private String flow;
}
