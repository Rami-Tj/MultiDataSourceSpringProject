package com.multiDataSourceSpring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TABLEAUX")
public class TableResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TABLEAU_ID")
    private int id;

    @Column(name = "LIBELLE")
    private String name;

    @OneToMany
    @JoinColumn(name = "TABLEAU_ID")
    private List<TableColumn> columns;
}
