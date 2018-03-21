import Characteristics.Event;
import Characteristics.Place;
import Characteristics.WTPcharacter;
import ConsoleApp.CollectionHandler;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Stack;

import static ConsoleApp.Instruments.extractFileName;
import static ConsoleApp.Instruments.extractFilePath;

public class Initializer {
    public static void main(String[] args) {
        CollectionHandler ch = new CollectionHandler();
        ch.file = new File(extractFilePath(args[0]), extractFileName(args[0]));
        ch.Events = new Stack<>();
        Place place = new Place("Les");
        Place place1 = new Place("Forest");
        WTPcharacter winnie = new WTPcharacter("Winnie");
        WTPcharacter piglet = new WTPcharacter("Piglet");
        GregorianCalendar date1 = new GregorianCalendar();
        GregorianCalendar date2 = new GregorianCalendar();
        GregorianCalendar date3 = new GregorianCalendar();
        GregorianCalendar date4 = new GregorianCalendar();
        GregorianCalendar date5 = new GregorianCalendar();
        date1.set(1901, Calendar.JANUARY,14);
        date2.set(1902, Calendar.JANUARY,15);
        date3.set(1903, Calendar.JANUARY, 16);
        date4.set(1904, Calendar.JANUARY,17);
        date5.set(1905, Calendar.JANUARY,18);
        Event ev1 = new Event("ev1",place,date1,winnie);
        Event ev2 = new Event("ev2",place1,date2,piglet);
        Event ev3 = new Event("ev3",place1,date3,piglet);
        Event ev4 = new Event("ev4",place,date3,piglet);
        Event ev5 = new Event("ev5",place,date1,winnie);
        ch.Events.add(ev1);
        ch.Events.add(ev2);
        ch.Events.add(ev3);
        ch.Events.add(ev4);
        ch.Events.add(ev5);
        ch.save();
        /*GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try {
            PrintWriter pw = new PrintWriter(ch.file);
            pw.print(gson.toJson(ev1));
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

}
