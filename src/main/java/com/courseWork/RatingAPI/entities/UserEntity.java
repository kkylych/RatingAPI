package com.courseWork.RatingAPI.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String password;

    private String email;

    private LocalDateTime registrationDate;

    @PrePersist
    private void init() {
        this.registrationDate = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "user", fetch =  FetchType.LAZY)
    private List<ReviewEntity> reviews;

}
