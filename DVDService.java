/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.service;

import DVD.dao.DVDDaoFilePersistenceException;
import DVD.dto.DVD;
import java.util.List;

/**
 *
 * @author Kelsey
 */
public interface DVDService {
    void createDVD(DVD dvd) throws 
            DVDDaoFilePersistenceException,
            DVDServiceDataValidationException,
            DVDServiceDuplicateIdException;
    List<DVD> getAllDvds()throws DVDDaoFilePersistenceException;
    DVD getDVD(String title) throws DVDDaoFilePersistenceException;
    DVD removeVD(String title) throws DVDDaoFilePersistenceException;
    DVD editDVD(DVD newdvd) throws DVDDaoFilePersistenceException;
}
