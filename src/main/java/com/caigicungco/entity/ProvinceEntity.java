package com.caigicungco.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "province")
@Entity
public class ProvinceEntity {
    @Id
    Integer id;
    @Column(name = "_name")
    private String name;
    @Column(name = "_code")
    private String code;
}
