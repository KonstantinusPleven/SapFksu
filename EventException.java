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
public class EventException  extends Exception{

    public EventException() {
    }

    @Override
    public String getMessage() {
        return "----- There is another event on this time! -----\n";
    }
    
    
}
