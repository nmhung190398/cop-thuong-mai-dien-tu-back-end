package com.caigicungco.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "district")
public class DistrictEntity {

    @Id
    Integer id;
    @Column(name = "_name")
    private String name;

    @Column(name = "_prefix")
    private String prefix;

    @Column(name = "_province_id")
    private Integer provinceId;

}
