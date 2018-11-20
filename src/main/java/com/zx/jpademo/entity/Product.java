package com.zx.jpademo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "product")
@Data
public class Product {

    @Id
    private String id;
    private String productId;
    private String productName;
    private String productDesc;
    private Double productPrice;
    private Integer productStock;
}
