package com.plataformasHeterogeneas.ProyectoPlataformasApi.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Builder
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long userId;
    @Column(unique=true)
    @NonNull @Getter @Setter private String userName;
    @NonNull @Getter @Setter private String gamerTag;
    @NonNull @Getter @Setter private String email;
    @NonNull @Getter @Setter private String password;
    @Getter @Setter private String profilePictureURL;
    @Builder.Default @NonNull @Getter @Setter private java.util.Date creationDate = LocalDateTime.now();
    @Builder.Default @NonNull @Getter @Setter private int enemiesDefeated = 0;
}