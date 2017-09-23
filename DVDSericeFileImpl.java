/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.service;

import DVD.dao.AuditDao;
import DVD.dao.DVDDao;
import DVD.dao.DVDDaoFilePersistenceException;
import DVD.dto.DVD;
import java.util.List;

/**
 *
 * @author Kelsey
 */
public class DVDSericeFileImpl implements DVDService {
    AuditDao audit;

    DVDDao dao;

    public DVDSericeFileImpl(DVDDao dao, AuditDao audit) {
        this.audit=audit;
        this.dao = dao;
    }

    @Override
    public void createDVD(DVD dvd) throws DVDDaoFilePersistenceException, DVDServiceDataValidationException, DVDServiceDuplicateIdException {
        if(dao.getDVD(dvd.getTitle())!=null){
            throw new DVDServiceDataValidationException("Error: Title "+dvd.getTitle()+" already exits");
        }
        validateData(dvd);
        dao.addDVD(dvd.getTitle(), dvd);
        audit.writeauditEntry("DvD "+dvd.getTitle()+"has been added");
        
    }

    @Override
    public List<DVD> getAllDvds() throws DVDDaoFilePersistenceException {
        return dao.getAllDVDS();
    }

    @Override
    public DVD getDVD(String title) throws DVDDaoFilePersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DVD removeVD(String title) throws DVDDaoFilePersistenceException {
        DVD removedDvd=dao.removeDVD(title);
        audit.writeauditEntry("DVD "+title+"has been removed");
        return removedDvd;
      
    }

    @Override
    public DVD editDVD(DVD newdvd) throws DVDDaoFilePersistenceException {
        return dao.editDVD(newdvd.getTitle(), newdvd);
    }

    private void validateData(DVD dvd) throws DVDServiceDataValidationException {
        if (dvd.getTitle() == null
                || dvd.getTitle().trim().length() == 0
                || dvd.getReleaseDate() == null || dvd.getReleaseDate().trim().length() == 0
                || dvd.getMpaaRating() == null || dvd.getReleaseDate().trim().length() == 0
                || dvd.getDirectorName() == null || dvd.getDirectorName().trim().length() == 0
                || dvd.getStudio() == null || dvd.getStudio().trim().length() == 0
                || dvd.getUserRating() == null || dvd.getUserRating().length() == 0) {
            throw new DVDServiceDataValidationException("All fields are required");
        }

    }

}
