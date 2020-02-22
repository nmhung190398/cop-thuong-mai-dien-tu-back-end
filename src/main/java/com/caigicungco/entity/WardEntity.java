package com.caigicungco.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ward")
@Data
public class WardEntity {
    @Id
    private Integer id;

    @Column(name = "_name")
    private String name;

    @Column(name = "_prefix")
    private String prefix;

    @Column(name = "_province_id")
    private Integer provinceId;

    @Column(name = "_district_id")
    private Integer districtId;
}
