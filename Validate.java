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
public class Validate {

    public void dayValidate(int month, int day) throws MonthException, DaysException {
        if (bigMonth(month) == true) {
            if (day < 0 || day > 31) {
                throw new DaysException();
            }
            if (bigMonth(month) == false) {
                if (day < 0 || day > 30) {
                    throw new DaysException();
                }
                if (month == 2) {
                    if (day < 0 || day > 28) {
                        throw new DaysException();
                    }
                }
            }
        }
    }
    public void monthValidate(int month) throws MonthException{
        if(month<0 || month >12){
            throw new MonthException();
        }
    }
    public void timeValidateHour(int time) throws TimeException{
         if(time<0 || time>23)
            throw new TimeException();
    }
    public void timeValidateMin(int time) throws TimeException{
        if(time<0 || time>59)
            throw new TimeException();
    }
    private boolean bigMonth(int month) throws MonthException {
        if (month == 1) {
            return true;
        }
        if (month == 2) {
            return false;
        }
        if (month == 3) {
            return true;
        }
        if (month == 4) {
            return false;
        }
        if (month == 5) {
            return true;
        }
        if (month == 6) {
            return false;
        }
        if (month == 7) {
            return true;
        }
        if (month == 8) {
            return true;
        }
        if (month == 9) {
            return false;
        }
        if (month == 10) {
            return true;
        }
        if (month == 11) {
            return false;
        }
        if (month == 12) {
            return true;
        } else {
            throw new MonthException();
        }
    }
}
