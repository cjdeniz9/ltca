package com.pluralsight.workbook.iii.asychronous;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FormatDates {
    public static void main(String[] args) {

        LocalDateTime dateTime = LocalDateTime.now();

        DateTimeFormatter fmtFirst = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter fmtSecond = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter fmtThird = DateTimeFormatter.ofPattern("EEEE dd, yyyy");
        DateTimeFormatter fmtFourth = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm").withZone(ZoneId.of("GMT"));
        DateTimeFormatter fmtFifth = DateTimeFormatter.ofPattern("HH:mm 'on' dd-MMM-yyyy").withZone(ZoneId.systemDefault());

        formattedDate(dateTime, fmtFirst);
        formattedDate(dateTime, fmtSecond);
        formattedDate(dateTime, fmtThird);
        formattedDate(dateTime, fmtFourth);
        formattedDate(dateTime, fmtFifth);

    }

    public static void formattedDate(LocalDateTime dateTime,DateTimeFormatter fmt) {
        String formattedDate = dateTime.format(fmt);
        System.out.println(formattedDate);
    }
}
