package org.tekCorp.api.Util;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Inspiron on 16/06/2015.
 */
public class DateUtil {

    public static String getDateInString(GregorianCalendar gc, boolean court){
        if (gc == null){
            return "** unknown **";
        }
        String year = ""+gc.get(Calendar.YEAR);
        String day = ""+gc.get(Calendar.DATE);
        if (gc.get(Calendar.DATE) < 10){
            day = "0"+day;
        }
        String month = ""+(gc.get(Calendar.MONTH)+1);
        if ((gc.get(Calendar.MONTH)+1) < 10){
            month = "0"+month;
        }
        String hour = ""+gc.get(Calendar.HOUR);
        if (gc.get(Calendar.HOUR) < 10){
            hour = "0"+hour;
        }
        String min = ""+gc.get(Calendar.MINUTE);
        if (gc.get(Calendar.MINUTE) < 10){
            min = "0"+min;
        }
        String sec = ""+gc.get(Calendar.SECOND);
        if (gc.get(Calendar.SECOND) < 10){
            sec = "0"+sec;
        }
        if (court){
            return day+"-"+month+"-"+year;
        }
        return day+"-"+month+"-"+year+" "+hour+":"+min+":"+sec;
    }

    public static String getDateInString(GregorianCalendar gc){
        return getDateInString(gc, false);
    }

    public static GregorianCalendar getCalendarToString(String date) {
        if (date == null || date.isEmpty()){
            return null;
        }

        Integer year = null;
        Integer month = null;
        Integer day = null;

        String regex = "";
        if (date.contains("-")){
            regex = "-";
        }else if(date.contains("/")){
            regex = "/";
        }

        if (date.split(regex)[0].length() == 4){
            year = Integer.parseInt(date.split(regex)[0]);
            day = Integer.parseInt(date.split(regex)[2]);
        }else{
            day = Integer.parseInt(date.split(regex)[0]);
            year = Integer.parseInt(date.split(regex)[2]);
        }
        month = Integer.parseInt(date.split(regex)[1]);

        return new GregorianCalendar(year, month-1, day);
    }
}
