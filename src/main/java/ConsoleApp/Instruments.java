package ConsoleApp;

import Characteristics.Event;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Instruments {
    public static String extractFilePath(String path){
        return path.substring(0, path.lastIndexOf('\\') + 1);
    }

    public static String extractFileName(String path){
        return path.substring(path.lastIndexOf('\\') + 1, path.length());
    }

    static Event FromJson(String s) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Event event = gson.fromJson(s, Event.class);
        return event;
    }

    public static ArrayList<String> parseCmd(String cmd) throws WrongArgsException{
        ArrayList<String> listArgs = new ArrayList<>();
        String text[] = cmd.split(" \\{",2);
        if (text.length>1) {
            String cArgs[];
            cArgs = text[1].split("} ");
            int length = cArgs.length;
            cArgs[length - 1] = cArgs[length - 1].substring(0, cArgs[length - 1].length() - 1);
            listArgs.add(text[0]);
            listArgs.add(cArgs[0]);
            if (length > 1) {
                for (int i = 1; i < length; i++) {
                    listArgs.add(cArgs[i].substring(1, cArgs[i].length()));
                }
            }
        }
        else if (cmd.trim().contains(" ")){
            throw (new WrongArgsException());
        } else {
            listArgs.add(text[0]);
        }
            return listArgs;
    }

    public static class WrongArgsException extends Exception {
        @Override
        public String getMessage() {
            return ("Wrong arguments format");
        }
    }
}
