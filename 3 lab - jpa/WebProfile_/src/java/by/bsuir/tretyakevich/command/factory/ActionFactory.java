/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.tretyakevich.command.factory;


import by.bsuir.tretyakevich.command.ActionCommand;
import by.bsuir.tretyakevich.command.client.CommandFactory;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kira
 */
public class ActionFactory {
    
    public ActionCommand defineCommand(HttpServletRequest request){
       
        ActionCommand current = null;
        
        String action = request.getParameter("command");
        if(action == null || action.isEmpty())
            return current;
        current = CommandFactory.getCommand(action.toUpperCase());
        
        return current;
    }
}
