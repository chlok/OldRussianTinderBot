package ru.liga.oldrussiantinderbot.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    private Long id;
    private String name;
    //потом заменим на энамы, яхз как их в пост запросе передать
    private String sex;
    private Integer age;
    private String description;

    private String partnerSex;

    //сэты из видео, таблички он там делает в ручную
    @ManyToMany
    @JoinTable(
            name = "i_was_chosen",
            joinColumns = {@JoinColumn(name = "this_user_id")},
            inverseJoinColumns = {@JoinColumn(name = "choosed_user_id")}
    )
    private Set<User> whoChooseMe = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "my_choose",
            joinColumns = {@JoinColumn(name = "choosed_user_id")},
            inverseJoinColumns = {@JoinColumn(name = "this_user_id")}
    )
    private Set<User> whoIChose = new HashSet<>();
}
