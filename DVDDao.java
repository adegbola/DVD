/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.dao;

import DVD.dto.DVD;
import java.util.List;

/**
 *
 * @author Kelsey
 */
public interface DVDDao {
    DVD addDVD(String title, DVD dvd)throws DVDDaoFilePersistenceException;
    List<DVD> getAllDVDS()throws DVDDaoFilePersistenceException;
    DVD getDVD(String title)throws DVDDaoFilePersistenceException;
    DVD removeDVD(String title)throws DVDDaoFilePersistenceException;
    DVD editDVD(String title, DVD newDVD)throws DVDDaoFilePersistenceException;
    
}
