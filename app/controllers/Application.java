package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(ExcelControllerHelper.class)
public class Application extends Controller {

    public static void index() {
         List<AdventCalendar> calendars = AdventCalendar.find("order by category").fetch();
        render(calendars);
   }

    public static void excel() {
         List<AdventCalendar> calendars = AdventCalendar.find("order by category").fetch();
        request.format = "xls";
        String __FILE_NAME__ = "advent_calendar.xls";
        render(__FILE_NAME__, calendars);
    }
}
