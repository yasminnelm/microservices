package com.example.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String orderNumber;

    @Column(nullable = false)
    private String skuCode;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private String servicePort;
}

//to access mysql instance:     docker exec -it mysql-container mysql -u root -ppass123word
//to run the image (katdar ghi mrra w7da hadi bch ycreei instance m3a volume local fl pc): docker run -d --name mysql-container -e MYSQL_ROOT_PASSWORD=pass123word -e MYSQL_DATABASE=orderdb -e MYSQL_USER=admin -e MYSQL_PASSWORD=mypassword -p 3310:3306 -v C:/Users/PC/Desktop/docker_volumes/orderdb:/var/lib/mysql mysql:latest