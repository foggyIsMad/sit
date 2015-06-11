/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.tretyakevich.command.client;

import by.bsuir.tretyakevich.command.SaveEditedCommand;
import by.bsuir.tretyakevich.command.ToAllCommand;
import by.bsuir.tretyakevich.command.ActionCommand;
import by.bsuir.tretyakevich.command.PreviousCommand;
import by.bsuir.tretyakevich.command.NextCommand;
import by.bsuir.tretyakevich.command.AddNewValueCommand;
import by.bsuir.tretyakevich.command.AddCommand;
import by.bsuir.tretyakevich.command.TestCommand;
import by.bsuir.tretyakevich.command.EditCommand;
import by.bsuir.tretyakevich.command.ToProjectCommand;
import by.bsuir.tretyakevich.command.ToMainPageCommand;
import by.bsuir.tretyakevich.command.RemoveCommand;
import java.util.HashMap;

/**
 *
 * @author Gleb
 */
public class CommandFactory {
    
    private static final HashMap<String, ActionCommand> actions;
    static{
        actions = new HashMap<>();
        actions.put("ADD", new AddCommand());
        actions.put("EDIT", new EditCommand());
        actions.put("REMOVE", new RemoveCommand());
        actions.put("TEST", new TestCommand());
        actions.put("NEXT", new NextCommand());
        actions.put("PREVIOUS", new PreviousCommand());
        actions.put("ADDNEWVALUE", new AddNewValueCommand());
        actions.put("SAVEEDITED", new SaveEditedCommand());
        actions.put("TOMAINPAGE", new ToMainPageCommand());
        actions.put("TOALL", new ToAllCommand());
        actions.put("TOPROJECT", new ToProjectCommand());
    }

    private CommandFactory() {
    }
    
    public static ActionCommand getCommand(String command)
    {
        return actions.get(command);
    }
    
    
}
