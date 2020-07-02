package com.multiDataSourceSpring.entity;

import com.multiDataSourceSpring.entity.enums.DBSMName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        name = "TYPE_RESSOURCE_DONNEES",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"LIBELLE"})
        })
public class DataSourceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TYPE_RESSOURCE_DONNEE_ID")
    private int id;

    @Column(name = "LIBELLE")
    @Enumerated(value = EnumType.STRING)
    private DBSMName name;

    public DataSourceType(DBSMName name) {
        this.name = name;
    }
}
