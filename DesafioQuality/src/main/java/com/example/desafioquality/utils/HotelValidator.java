package com.example.desafioquality.utils;

import com.example.desafioquality.exceptions.BadParametersException;
import com.example.desafioquality.exceptions.DateException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HotelValidator {

    private HotelValidator() {
    }

    public static void validateParameters(Map<String, String> parameters) throws RuntimeException {
        if (parameters.isEmpty()) return;
        //validate size
        if (parameters.size() != 3) throw new BadParametersException("Too many or too few parameters");
        //validate key names
        if (parameters.size() == 3 &&
                !(parameters.containsKey("dateTo") &&
                        parameters.containsKey("dateFrom") &&
                        parameters.containsKey("city"))
        ) {
            throw new BadParametersException("Some of this parameters are not allowed");
        }
        //  validate values:
        //
        //date format
        String dateFrom = parameters.get("dateFrom");
        String dateTo = parameters.get("dateTo");
        validateDateFormat(dateFrom);
        validateDateFormat(dateTo);
        //dateFrom < dateTo
        if (!DateUtils.parseDate(dateFrom).isBefore(DateUtils.parseDate(dateTo))) throw new DateException(
                "Date From must be before Date To.");
        //destination must be a String without special characters
        validateNameString(parameters.get("city"));
        //TODO destination must exist, validate in repository layer
    }

    private static void validateDateFormat(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(date, formatter);
        } catch (DateTimeParseException exception) {
            throw new DateException("Date format " + date + " not supported");
        }
    }

    private static void validateNameString(String name){
        Pattern p = Pattern.compile("^[A-Za-z0-9\\u00C1\\u00C9\\u00CD\\u00D3\\u00DA\\u00DC\\u00E1\\u00E9\\u00ED\\u00F3\\u00FA\\u00FC\\u00D1\\u00F1 ]+$");
        Matcher m = p.matcher(name);
        if (!m.matches()) throw new BadParametersException("City name has unsupported characters");
    }
}
