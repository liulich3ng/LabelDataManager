package com.liulich3ng.entity;

import com.liulich3ng.constant.PROJECT_STATUS;
import com.liulich3ng.constant.PROJECT_TYPE;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    private String description;

    @Builder.Default
    private PROJECT_STATUS status = PROJECT_STATUS.NEW;

    @Builder.Default
    private PROJECT_TYPE type = PROJECT_TYPE.PCAT;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User creator;

    @Column(columnDefinition = "json")
    private String setting;

}