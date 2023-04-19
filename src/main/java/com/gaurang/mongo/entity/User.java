package com.gaurang.mongo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
@Builder
@ToString
@Data
public class User {

    @Id
    private String _id;
    private String name;
    private String email;
    private int age;

}
