/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.dao;

/**
 *
 * @author Kelsey
 */
public interface AuditDao {
    public void writeauditEntry(String entry) throws DVDDaoFilePersistenceException;
   
}
