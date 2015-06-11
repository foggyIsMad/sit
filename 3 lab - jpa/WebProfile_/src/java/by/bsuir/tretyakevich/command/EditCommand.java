/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.tretyakevich.command;

import by.bsuir.tretyakevich.webprofiler.data.DataKeeper;
import by.bsuir.tretyakevich.webprofiler.data.Model.DAO.CastingDAO;
import by.bsuir.tretyakevich.webprofiler.data.Model.DAO.GenreDAO;
import by.bsuir.tretyakevich.webprofiler.data.Model.DAO.SoundmanDAO;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kira
 */
public class EditCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        
        DataKeeper dataKeeper = DataKeeper.getInstance();
        if (!dataKeeper.isEmpty()){
            request.setAttribute("textValue", dataKeeper.getCurrentProject());
            request.setAttribute("action","SAVEEDITED");
            request.setAttribute("genreList", GenreDAO.findAll());
            request.setAttribute("soundmanList", SoundmanDAO.findAll());
            request.setAttribute("castingList", CastingDAO.findAll());
            return "/jsp/updatePage.jsp";
        }
        else
        {
            return "/jsp/mainpage.jsp";
        }
    }
    
}
