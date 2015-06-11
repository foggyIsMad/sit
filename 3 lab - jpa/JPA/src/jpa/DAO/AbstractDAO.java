/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.DAO;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import jpa.Entity.DubbingObject;

/**
 *
 * @author Kira
 * @param <KeyType>
 * @param <Type>
 */
public abstract class AbstractDAO<KeyType, Type extends DubbingObject > {
    public abstract List<Type> findAll();
    public abstract Type findEntityById(KeyType id);
    public abstract boolean delete(KeyType id);
    public abstract boolean delete(Type entity);
    public abstract boolean create(Type entity);
    public abstract Type update(Type entity);
    public abstract void closeConnection();
    
}
