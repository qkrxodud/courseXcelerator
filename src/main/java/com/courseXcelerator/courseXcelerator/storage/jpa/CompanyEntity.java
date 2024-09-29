package com.courseXcelerator.courseXcelerator.storage.jpa;

import com.courseXcelerator.courseXcelerator.core.domain.crawler.Company;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "company")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Company toModel() {
        return Company.builder()
                .id(id)
                .name(name)
                .build();
    }
}
