package org.deepdive.apiserver.lecture.repository.entity;

import jakarta.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringToListConverter implements AttributeConverter<List<String>, String> {

    private static final String SPLIT_CHAR = "\\|";
    private static final String JOIN_CHAR = "|";

    @Override
    public String convertToDatabaseColumn(List<String> stringList) {
        if (stringList == null || stringList.isEmpty()) {
            return "";
        }
        return String.join(JOIN_CHAR, stringList);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return List.of();
        }
        log.debug("[StringToListConverter] db data is {}", dbData);
        List<String> result = Arrays.stream(dbData.split(SPLIT_CHAR))
            .map(String::trim)
            .collect(Collectors.toList());
        for (String s : result) {
            log.debug("{}", s);
        }
        return Arrays.stream(dbData.split(SPLIT_CHAR))
            .map(String::trim)
            .toList();
    }
}
