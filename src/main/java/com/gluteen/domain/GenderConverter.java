package com.gluteen.domain;

import javax.persistence.AttributeConverter;

/**
 * Created by yusufaslan on 30.05.2017.
 */
public class GenderConverter implements AttributeConverter<Gender, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Gender gender) {
        if (gender == null)
            return null;
        return gender.getId();
    }

    @Override
    public Gender convertToEntityAttribute(Integer id) {
        return Gender.getGender(id);
    }
}
