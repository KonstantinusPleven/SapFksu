/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sapfksu;

import java.util.Scanner;

/**
 *
 * @author v
 */
public class Event {

    private final Scanner scan = new Scanner(System.in);

    private Date Date;
    private String Description;
    private String Marker;
    private String Type;
    

    public Event(int i){
    }
    public Event() {
        this.Date = new Date();
        this.Marker = setMarkerC();
        this.Type = setTypeC();
        System.out.println("Enter little description for your event:");
        this.Description = scan.nextLine();
        System.out.println("\n\t\t Done!");
        
    }

    
    public Date getDate() {
        return Date;
    }
    public String getDescription() {
        return Description;
    }
    public String getMarker() {
        return Marker;
    }
    public String getType() {
        return Type;
    }

    
    public void setDate() {
        this.Date = new Date();
    }
    public void setDescription() {
        System.out.println("Enter little description for your event:");
        this.Description = scan.nextLine();
    }
    public void setMarker() {
        this.Marker = setMarkerC();
    }
    public void setType() {
        this.Type = setTypeC();
    }
    
    
    
    public String setMarkerC() {
        int mark = 0;
        String marker;
        System.out.println("Enter a marker for the event:\n\t 1.public\n\t"
                + " 2.personal\n\t 3.confidential");
        do {
            try{
            marker = scan.nextLine();
            mark = Integer.parseInt(marker);
            if (mark == 1) {
                return "public";
            }
            if (mark == 2) {
                return "personal";
            }
            if (mark == 3) {
                return "confidential";
            }
            else{
                System.out.println("\n\t\t Try Again:");
            }
            }catch(Exception ex){
                 System.out.printf("Something went wrong!Try again:");
                 mark = 0;
            }
        } while (mark < 1 || mark > 3);
        return "Undefined";
    }
    public String setTypeC(){
        int t =0;
        String type;
        
        System.out.println("Enter type of your event:\n\t 1.Task"
                + "\n\t 2.Meeting");
        do {
            try{
            type = scan.nextLine();
            t = Integer.parseInt(type);
            if (t == 1) {
                return "Meeting";
            }
            if (t == 2) {
                return "Task";
            }
            else{
                System.out.println("\n\t\t Try Again:");
            }
            }catch(Exception ex){
                 System.out.printf("Something went wrong!Try again:");
                 t = 0;
            }
        } while (t < 1 || t > 2);
        return "Undefined";
    }
}
