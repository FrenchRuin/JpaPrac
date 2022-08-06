package com.example.jpa.bookmanager.domain;

import com.example.jpa.bookmanager.domain.listener.UserEntityListener;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@RequiredArgsConstructor
@EntityListeners(value = UserEntityListener.class)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city",column = @Column(name = "home_city")),
            @AttributeOverride(name = "district",column = @Column(name = "home_district")),
            @AttributeOverride(name = "detail",column = @Column(name = "home_address_detail")),
            @AttributeOverride(name = "zipCode",column = @Column(name = "home_zip_code")),
    }
    )
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city",column = @Column(name = "company_city")),
            @AttributeOverride(name = "district",column = @Column(name = "company_district")),
            @AttributeOverride(name = "detail",column = @Column(name = "company_address_detail")),
            @AttributeOverride(name = "zipCode",column = @Column(name = "company_zip_code")),
    }
    )
    private Address companyAddress;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ToString.Exclude
    private List<UserHistory> userHistories = new ArrayList<>();  // 1,2,3,4,5


    @OneToMany
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();
}
