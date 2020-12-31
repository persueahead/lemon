package com.bjlemon.ssm.web.converter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;

public class CustomDateConverter implements Converter<String, Date> {

    private String patterns;

    public void setPatterns(String patterns) {
        this.patterns = patterns;
    }

    @Override
    public Date convert(String value) {
        Date date = null;

        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException("");
        }

        try {
            String[] datePatterns = this.patterns.split(",");
            date = DateUtils.parseDate(value, datePatterns);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
