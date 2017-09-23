/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author Kelsey
 */
public class AuditDaoFileImpl implements AuditDao{
    public static final String AUDIT="audit.text";

    @Override
    public void writeauditEntry(String entry) throws DVDDaoFilePersistenceException {
        PrintWriter out;
        try{
            out=new PrintWriter(new FileWriter(AUDIT, true));
        }catch(IOException e){
            throw new DVDDaoFilePersistenceException("Could not load the file", e);
        }
         LocalDateTime timestamp=LocalDateTime.now();
         out.println(timestamp.toString()+" : "+entry);
         out.flush();
    }
   
    
    
}
