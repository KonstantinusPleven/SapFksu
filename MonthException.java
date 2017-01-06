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
public class MonthException extends Exception{

    public MonthException() {
    }

    @Override
    public String getMessage() {
        return "----- There is no such month! -----";
    }
    
    
}
