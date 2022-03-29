package model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    Integer id;
    Gender gender;
    String name;
    Integer age;
    String description;
    Gender chosenGender;
    List<User> chosenList;
}
