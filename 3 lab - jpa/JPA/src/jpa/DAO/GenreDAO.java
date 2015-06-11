/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.DAO;

import jpa.DAO.pool.ConnectionPool;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.DAO.pool.PreparedStatementGenerator;
import jpa.DAO.pool.StatementPool;
import jpa.Entity.Genre;

/**
 *
 * @author Kira
 */
public class GenreDAO extends AbstractDAO<Long, Genre>{

    public static final String SQL_SELECT_ALL_GENRES = "SELECT * FROM genres;";
    public static final String SQL_SELECT_GENRE_BY_ID = "SELECT * FROM genres WHERE id = %d;";
    public static final String SQL_SELECT_GENRE_BY_NAME = "SELECT * FROM genres WHERE name = '%s';";
    public static final String SQL_DELETE_GENRE_BY_ID = "DELETE FROM genres WHERE id = %d;";
    public static final String SQL_INSERT_GENRE = "INSERT INTO genres VALUES (%d,'%s');";
    public static final String SQL_UPDATE_GENRE = "UPDATE genres SET name = '%s' WHERE id = %d;";
    @Override
    public List<Genre> findAll() {
        
        List<Genre> genres = new ArrayList<>();
        Statement statement = StatementPool.getStatement();

        try {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_GENRES);
            if(resultSet.first())
            {
                do{
                    Genre genre = ResultSetConverter.toGenre(resultSet);
                    genres.add(genre);
                }while(resultSet.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return genres;
    }

    @Override
    public Genre findEntityById(Long id) {
        
        Statement statement = StatementPool.getStatement();
        PreparedStatement ps = PreparedStatementGenerator.getStatement(String.format(SQL_SELECT_GENRE_BY_ID, id));
        try {
            ResultSet result = ps.executeQuery();
            return ResultSetConverter.toGenre(result);
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Statement statement = StatementPool.getStatement();
        PreparedStatement ps = PreparedStatementGenerator.getStatement(String.format(SQL_DELETE_GENRE_BY_ID, id));
        try {
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Genre entity) {
        Statement statement = StatementPool.getStatement();
        PreparedStatement ps = PreparedStatementGenerator.getStatement(String.format(SQL_DELETE_GENRE_BY_ID, entity.getGenreID()));
        try {
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean create(Genre entity) {
        Statement statement = StatementPool.getStatement();
        PreparedStatement ps = PreparedStatementGenerator.getStatement(String.format(SQL_INSERT_GENRE, entity.getGenreID(), entity.getName()));
        try {
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Genre update(Genre entity) {
        Statement statement = StatementPool.getStatement();
        PreparedStatement ps = PreparedStatementGenerator.getStatement(String.format(SQL_SELECT_GENRE_BY_ID, entity.getGenreID()));
        Genre oldGenre = null;
        try {
            ResultSet result = ps.executeQuery();
            result.first();
            oldGenre = ResultSetConverter.toGenre(result);
            if (oldGenre != null)
            {
                ps = PreparedStatementGenerator.getStatement(String.format(SQL_UPDATE_GENRE, entity.getName(),  entity.getGenreID()));
                
                ps.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return oldGenre;
    }

    @Override
    public void closeConnection() {
        StatementPool.closeStatement();
    }
    
}

