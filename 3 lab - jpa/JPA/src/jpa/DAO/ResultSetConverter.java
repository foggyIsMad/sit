/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.Entity.Genre;

/**
 *
 * @author Kira
 */
class ResultSetConverter {
    
    public static Genre toGenre(ResultSet set) throws SQLException{
        Genre genre = new Genre();
        genre.setGenreID(set.getLong("id"));
        genre.setName(set.getString("name"));
        return genre;
    }
}
