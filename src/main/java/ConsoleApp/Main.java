package ConsoleApp;


import java.io.File;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;

import static ConsoleApp.Instruments.*;

public class Main {
    public static void main(String[] args) {
        CollectionHandler ch = new CollectionHandler();
        ch.file = new File(extractFilePath(args[0]), extractFileName(args[0]));
        ch.load();
        String exitCheck = "";
        do {
            Scanner in = new Scanner(System.in);
            try {
                ArrayList<String> cmd = parseCmd(in.nextLine());
                exitCheck = cmd.get(0);
                try {
                    switch (cmd.get(0)) {
                        case "remove_last": {
                            ch.removeLast();
                        }
                        break;
                        case "import": {
                            ch.Import(cmd.get(1));
                        }
                        break;
                        case "remove_all": {
                            ch.removeAll(FromJson(cmd.get(1)));
                        }
                        break;
                        case "reorder": {
                            ch.reorder();
                        }
                        break;
                        case "save": {
                            ch.save();
                        }
                        break;
                        case "remove": {
                            try {
                                int arg = Integer.parseInt(cmd.get(1));
                                ch.remove(arg);
                            } catch (NumberFormatException e) {
                                ch.remove(FromJson(cmd.get(1))); //перегрузить
                            }
                        }
                        case "info": {
                            ch.info();
                        }
                        break;
                        case "add_if_max": {
                            ch.addIfMax(FromJson(cmd.get(1)));
                        }
                        break;
                        case "remove_greater": {
                            ch.removeGreater(FromJson(cmd.get(1)));
                        }
                        break;
                        case "insert": {
                            ch.insert(Integer.parseInt(cmd.get(1)), FromJson(cmd.get(2)));
                        }
                        break;
                        case "add_if_min": {
                            ch.addIfMin(FromJson(cmd.get(1)));
                        }
                        break;
                        case "remove_first": {
                            ch.removeFirst();
                        }
                        break;
                        case "remove_lower": {
                            ch.removeLower(FromJson(cmd.get(1)));
                        }
                        break;
                        case "clear": {
                            ch.clear();
                        }
                        break;
                        case "add": {
                            ch.add(FromJson(cmd.get(1)));
                        }
                        break;
                        case "load": {
                            ch.load();
                        }
                        break;
                        case "contents": {
                            ch.contents();
                        } break;
                        case "exit":
                            ch.exit();
                            break;
                        default: {
                            System.out.println("No such command");
                        }
                        break;
                    }
                } catch (EmptyStackException e) {
                    System.out.println(e.getMessage());
                } catch (IndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Wrong arguments");
                } catch (com.google.gson.JsonSyntaxException e) {
                    System.out.println("Wrong Json format");
                }
            } catch (WrongArgsException e){
                System.out.println(e.getMessage());
            }
        } while(!exitCheck.equals("exit"));



    }
}
