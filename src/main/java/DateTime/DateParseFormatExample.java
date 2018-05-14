package DateTime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class DateParseFormatExample {

    public static void main(String[] args) {

        //Format examples
        LocalDate date = LocalDate.now();
        //default format
        System.out.println("Default format of LocalDate="+date);
        //specific format
        System.out.println(date.format(DateTimeFormatter.ofPattern(" d::MMM::uuuu")));
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));


        LocalDateTime dateTime = LocalDateTime.now();
        //default format
        System.out.println("Default format of LocalDateTime="+dateTime);
        //specific format
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
        System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));

        Instant timestamp = Instant.now();
        //default format
        System.out.println("Default format of Instant="+timestamp);

        //Parse examples
//        LocalDateTime dt = LocalDateTime.parse("27::Apr::2014 21::39::48",
//                DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
//        System.out.println("Default format after parsing = "+dt);
//        //=>
////        Exception in thread "main" java.time.format.DateTimeParseException: Text '27::Apr::2014 21::39::48' could not be parsed at index 4
////        at java.time.format.DateTimeFormatter.parseResolved0(DateTimeFormatter.java:1949)
////        at java.time.format.DateTimeFormatter.parse(DateTimeFormatter.java:1851)
////        at java.time.LocalDateTime.parse(LocalDateTime.java:492)
////        at DateTime.DateParseFormatExample.main(DateParseFormatExample.java:33)
        // change to

        DateTimeFormatter format = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("d::MMM::uuuu HH::mm::ss")
                .toFormatter(Locale.ENGLISH);

        LocalDateTime dt = LocalDateTime.parse("27::Apr::2014 21::39::48", format);
        System.out.println("Default format after parsing = "+dt);

        //or
//        LocalDateTime dt = LocalDateTime.parse("27::四月::2014 21::39::48",
//                DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
//        System.out.println("Default format after parsing = "+dt);
    }

}
