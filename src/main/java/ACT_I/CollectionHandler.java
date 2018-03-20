package ACT_I;

import Characteristics.Event;
import com.google.gson.*;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class CollectionHandler {
    Stack<Event> Events = new Stack<>();
    private File file;
    private Scanner scan;

    public static void main(String[] args) {
        CollectionHandler ch = new CollectionHandler();
        //извлечь из аргументов путь и имя файлов и разделить их:
        String FilePath = args[0].substring(0, args[0].lastIndexOf('\\') + 1);
        String FileName = args[0].substring(args[0].lastIndexOf('\\') + 1, args[0].length());
        //открыть файл на чтение:
        ch.file = new File(FilePath, FileName);
        try {
            FileReader fr = new FileReader(ch.file);
            ch.scan = new Scanner(fr);
            ch.load();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    private void load() {
        Events.clear();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        while (scan.hasNextLine()) {
            Event event = gson.fromJson(scan.nextLine(), Event.class);
            Events.push(event);
        }
    }


}
