/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.tretyakevich.command;

import by.bsuir.tretyakevich.webprofiler.data.DataKeeper;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gleb
 */
public class NextCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        
        DataKeeper dataKeeper = DataKeeper.getInstance();
        dataKeeper.moveNext();
        request.setAttribute("currentValue", dataKeeper.getCurrentProject());
        return "/jsp/mainpage.jsp";
    }
    
}
