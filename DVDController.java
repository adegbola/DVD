/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.controller;

import DVD.dao.DVDDao;
import DVD.dao.DVDDaoFilePersistenceException;
import DVD.dto.DVD;
import DVD.service.DVDService;
import DVD.service.DVDServiceDataValidationException;
import DVD.service.DVDServiceDuplicateIdException;
import DVD.ui.DVDFileView;
import java.util.List;

/**
 *
 * @author Kelsey
 */
public class DVDController {

    // DVDDao dao;
    DVDService service;
    DVDFileView view;

    public DVDController(DVDService service, DVDFileView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = printMenuSelection();
                switch (menuSelection) {
                    case 1:
                        addDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        listDVD();
                        break;
                    case 5:
                        getDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                        break;

                }
            }
            exit();
        } catch (DVDDaoFilePersistenceException e) {
            e.getMessage();
        }
    }

    private int printMenuSelection() throws DVDDaoFilePersistenceException {
        return view.printMenuSelection();
    }

    private void addDVD() throws DVDDaoFilePersistenceException {
        view.createDVDBanner();
        boolean hasErrors = false;
        do {
            DVD dvd = view.createNewDvd();
            try {
                service.createDVD(dvd);
                view.successBanner();
                hasErrors = false;
            } catch (DVDServiceDataValidationException | DVDServiceDuplicateIdException e) {
                hasErrors = true;
                view.message(e.getMessage());

            }
        } while (hasErrors);

    }

    private void listDVD() throws DVDDaoFilePersistenceException {
        view.listingDVD();
        List<DVD> dvd = service.getAllDvds();
        view.listDVD(dvd);

    }

    private void getDVD() throws DVDDaoFilePersistenceException {
        view.displayDVD();
        String title = view.titleChoice();
        DVD dvd = service.getDVD(title);
        view.getDVD(dvd);

    }

    private void removeDVD() throws DVDDaoFilePersistenceException {
        view.removeBanner();
        String title = view.titleChoice();
        service.removeVD(title);
    }

    private void editDVD() throws DVDDaoFilePersistenceException {
        view.editDvdBanner();
        String title = view.titleChoice();
        DVD dvd = service.getDVD(title);
        view.getDVD(dvd);
        service.removeVD(title);
        DVD editdvd = view.createNewDvd();
        service.editDVD(dvd);
        view.editSuccessBanner();

    }

    private void unknownCommand() throws DVDDaoFilePersistenceException {
        view.unKnownCommand();
    }

    private void exit() throws DVDDaoFilePersistenceException {
        view.exitMessage();
    }
}
