package com.plataformasHeterogeneas.ProyectoPlataformasApi.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
    @Column(unique=true)
    @NonNull @Getter @Setter private String name;
    @NonNull @Getter @Setter private String password;
    @NonNull @Getter @Setter private String email;
    @NonNull @Getter @Setter private String degree;
    @NonNull @Getter @Setter private String address;
    @NonNull @Getter @Setter private String phone;
    @NonNull @Getter @Setter private String languages;
    //Work experience
    @NonNull @Getter @Setter private String workName;
    @NonNull @Getter @Setter private String workPosition;
    @Temporal(TemporalType.DATE)
    @NonNull @Getter @Setter private java.util.Date workDateIni;
    @Temporal(TemporalType.DATE)
    @NonNull @Getter @Setter private java.util.Date workDateEnd;
    @NonNull @Getter @Setter private String workDescription;
    //Education
    @NonNull @Getter @Setter private String schoolName;
    @NonNull @Getter @Setter private String schoolDegree;
    @Temporal(TemporalType.DATE)
    @NonNull @Getter @Setter private java.util.Date schoolDateIni;
    @Temporal(TemporalType.DATE)
    @NonNull @Getter @Setter private java.util.Date schoolDateEnd;
    @NonNull @Getter @Setter private long schoolAverage;
    //Skills
    //@ElementCollection
    //@CollectionTable(name = "user_skills", joinColumns = @JoinColumn(name = "user_id"))
    //@Column(name = "skill")
    //@Getter @Setter private List<String> skills;
    @NonNull @Getter @Setter private String skills;
    //Achievements
    @NonNull @Getter @Setter private String achievementName;
    @Temporal(TemporalType.DATE)
    @NonNull @Getter @Setter private java.util.Date achievementDate;
    @NonNull @Getter @Setter private String achievementDescription;
}