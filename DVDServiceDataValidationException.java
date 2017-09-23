/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.service;

/**
 *
 * @author Kelsey
 */
public class DVDServiceDataValidationException extends Exception{

    public DVDServiceDataValidationException(String message) {
        super(message);
    }

    public DVDServiceDataValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
