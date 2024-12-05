package com.example.product.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.annotation.Transient;

import java.math.BigDecimal;

@Document(collection = "product")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Product {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String name;

    private String description;

    private BigDecimal price;

    @Transient
    private int servicePort;
}
