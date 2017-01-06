/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sapfksu;

/**
 *
 * @author v
 */
public class DaysException  extends Exception{

    public DaysException() {
    }
    
    @Override
    public String getMessage() {
        return "----- In this month there are fewer days! -----\n";
    }
    
    
}
