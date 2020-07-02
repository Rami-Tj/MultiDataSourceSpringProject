package com.multiDataSourceSpring.entity;

import com.multiDataSourceSpring.entity.enums.DataTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TYPE_DONNEES")
public class DataType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TYPE_DONNEE_ID")
    private int id;

    @Column(name = "LIBELLE")
    @Enumerated(value = EnumType.STRING)
    private DataTypeName name;
}
