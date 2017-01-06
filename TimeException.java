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
public class TimeException extends Exception{

    public TimeException() {
    }
    
    @Override
    public String getMessage() {
        return "----- Invalid time format! -----\n";
    }
    
    
}
