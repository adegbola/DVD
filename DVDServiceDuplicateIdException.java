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
public class DVDServiceDuplicateIdException extends Exception{

    public DVDServiceDuplicateIdException(String message) {
        super(message);
    }

    public DVDServiceDuplicateIdException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
