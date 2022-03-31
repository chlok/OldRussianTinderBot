package ru.liga.oldrussiantinderbot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Как запихнуть энам в post запрос???
 */
@ToString
public class GenderDTO {

    @Getter
    @Setter
    @JsonProperty(value = "gender")
    private Gender gender;

    enum Gender {
        MALE,
        FEMALE
    }
}
