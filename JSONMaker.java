/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sapfksu;

import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONMaker {

    private final Scanner scan = new Scanner(System.in);
    private final WorkWithFiles save = new WorkWithFiles();

    public void Menu() {
        JSONArray array = new JSONArray();

        int k;
        String input;

        do {          
            try {
                array.addAll(save.ReadFromFile());
                System.out.println("Select option from the menu:\n\t\t "
                        + "1.Add new Event.\n\t\t 2.Print. \n\t\t 3.Change event. "
                        + "\n\t\t 4.Delete event. \n\t\t 5.Exit.");
                input = scan.nextLine();
                k = Integer.parseInt(input);
                if (k == 1) {
                    array.add(toJSONObj());
                }
                if (k == 2) {
                    printMenu(array);
                }
                if (k == 3) {
                    array = ChangeEvent(array);
                    if (array.isEmpty() == true) {
                        System.out.println("There is no Events.");
                    }
                }
                if (k == 4) {
                    array = deleteEvent(array);
                    if (array.isEmpty() == true) {
                        System.out.println("There is no Events.");
                    }
                }
                if (k == 5) {
                    save.WriteInFile(array);
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please choose option from the menu, try again.");
            }catch(NullPointerException ex){
                System.out.println("ReadProblem");
            }
        } while (true);
    }

    private void printMenu(JSONArray array) {
        int j;
        String input;
        do {
            try {
                System.out.println("Print menu:\n\t\t 1.Next day.\n\t\t "
                        + "2.Next 7 days \n\t\t 3.Next 30 days.\n\t\t 4.All events.\n\t\t 5.Exit");
                input = scan.nextLine();
                j = Integer.parseInt(input);
                if (j == 1) {
                    Print(array, 24);
                }
                if (j == 2) {
                    Print(array, 24 * 7);
                }
                if (j == 3) {
                    Print(array, 24 * 30);
                }
                if (j == 4) {
                    PrintAll(array);
                    if (array.isEmpty() == true) {
                        System.out.println("There is no Events.");
                    }
                }
                if (j == 5) {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please choose option from the menu, try again.");
            }
        } while (true);
    }
    private JSONObject toJSONObj() {
        Event e = new Event();
        JSONObject object = new JSONObject();
        object.put("Date:", e.getDate().getTimeStr() + ":" + e.getDate().getDay() + ":"
                + e.getDate().getMonth() + ":" + e.getDate().getYear());
        object.put("Type:", e.getType());
        object.put("Marker:", e.getMarker());
        object.put("Description:", e.getDescription());
        return object;
    }
    private void Print(JSONArray array, int hash) {
        JSONObject current = new JSONObject();
        int dateToPr = dateTo();

        for (int i = 0; i < array.size(); i++) {
            current = (JSONObject) array.get(i);
            int currentHash = JSONhashCode(current);
            if (currentHash > dateToPr && currentHash < dateToPr + hash) {
                System.out.println(current.toJSONString());
            }
        }
    }
    private int JSONhashCode(JSONObject currentObj) {
        int currentHash = 0;
        int[] DateValue = new int[5];

        String date = (String) currentObj.get("Date:");
        String[] toCast = date.split(":");

        for (int i = 0; i < toCast.length; i++) {
            Integer x = Integer.valueOf(toCast[i]);
            DateValue[i] = x;
        }
        Date d = new Date(DateValue);
        currentHash = d.hashCode();
        return currentHash;
    }
    private int dateTo() {
        System.out.println("Date to search:");
        Date d = new Date();
        return d.hashCode();
    }
    private JSONArray ChangeEvent(JSONArray array) {
        JSONObject current = new JSONObject();
        int dateToChange = dateTo();

        for (int i = 0; i < array.size(); i++) {
            current = (JSONObject) array.get(i);
            int currentHash = JSONhashCode(current);

            if (dateToChange == currentHash) {
                int k;
                String input;
                System.out.println("Choose option:\n\t\t 1.Change Date.\n\t\t "
                        + "2.Change Marker.\n\t\t 3.Change type.\n\t\t 4.Change description."
                        + "\n\t\t 5.Exit");
                do {
                    try {
                        input = scan.nextLine();
                        k = Integer.parseInt(input);
                        if (k == 1) {
                            Date d = new Date();
                            current.replace("Date:", d.getTimeStr() + ":" + d.getDay() + ":"
                                    + d.getMonth() + ":" + d.getYear());
                        }
                        if (k == 2) {
                            Event e = new Event(1);
                            current.replace("Marker:", e.setMarkerC());
                        }
                        if (k == 3) {
                            Event e = new Event(1);
                            current.replace("Type:", e.setTypeC());
                        }
                        if (k == 4) {
                            System.out.println("New description:");
                            current.replace("Description:", scan.nextLine());
                        }
                        if (k == 5) {
                            break;
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("Please choose option from the menu, try again.");
                    }
                } while (true);
                array.add(i, current);
            }
        }
        return array;
    }
    private JSONArray deleteEvent(JSONArray array) {
        JSONObject current = new JSONObject();
        int hashToKill = dateTo();
        for (int i = 0; i < array.size(); i++) {
            current = (JSONObject) array.get(i);
            int currentHash = JSONhashCode(current);
            if (hashToKill == currentHash) {
                System.out.println("Done!");
                array.remove(i);
                break;
            }
        }
        return array;
    }
    private void PrintAll(JSONArray array) {
        JSONObject current = new JSONObject();

        for (int i = 0; i < array.size(); i++) {
            current = (JSONObject) array.get(i);
            System.out.println(current.toJSONString());
        }
    }
}
