package com.hydraulic.applyforme.validator;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component
public class DateValidator {

    static final String dateFormat = "yyyy-MM-dd";
    static final String startDateFormat = "yyyy-MM-dd hh:mm:ss";

    public boolean isValid(String dateStr) {

        DateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Date startDateFormat(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(startDateFormat);
        Date date = null;
        try {
            date = sdf.parse(dateStr + " 00:00:00");
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        return date;
    }

    public Date endDateFormat(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(startDateFormat);
        Date date = null;
        try {
            date = sdf.parse(dateStr + " 23:59:59");
        } catch (ParseException e) {

        }
        return date;
    }
}