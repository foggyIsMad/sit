/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpa.DAO.GenreDAO;
import jpa.Entity.Generated.Casting;
import jpa.Entity.Generated.Project;
import jpa.Entity.Genre;

/**
 *
 * @author Kira
 */
public class JPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //jpa_set();
        jpa_get();
        //jdbcTest();
    }
    
    public static void jpa_set()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = factory.createEntityManager();
        
        EntityTransaction transaction = entityManager.getTransaction(); 
        transaction.begin();
        
        Casting cast = new Casting();
        cast.setActorList("WALL-E, EVA");
        
        entityManager.persist(cast);
        entityManager.flush();
        
        transaction.commit(); 
        entityManager.close(); 
        factory.close();
    }
    
    public static void jpa_get()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = factory.createEntityManager();
        
        Query query = entityManager.createNamedQuery("Project.findByProjectName");
        query.setParameter("projectName", "Never Say Goodbye");
        
        List<Project> projects = (List<Project>) query.getResultList();
        System.out.println("Found: " + projects.size() + " times");
        
        if (projects.size() > 0)
        {
            for(Project project: projects)
                System.out.println(project);
        }
        
        Project p = projects.get(0);
        System.out.println("#Project");
        System.out.println(p.getProjectName());
        System.out.println(p.getGenreId());
        System.out.println(p.getSoundmanId());
        System.out.println(p.getCastingId());
        System.out.println(p.getDescription());
        System.out.println(p.getPublishYear());
        
        query = entityManager.createNamedQuery("Casting.findByIdCasting");
        query.setParameter("idCasting", 1);
        List<Casting> actors = (List<Casting>) query.getResultList();
        
        System.out.println("Found actors: " + projects.size() + " times");
        if (actors.size() > 0)
        {
            for(Casting actor: actors)
                System.out.println(actor);
        }
        
    }
    
        
    public static void jdbcTest()
    {
        Genre genre = new Genre();
        GenreDAO genreDao = new GenreDAO();
        
        genre.setGenreID(1L);
        genre.setName("Fus!");
        
        genreDao.create(genre);
        
        genre.setGenreID(2L);
        genre.setName("Rouh!");
        
        genreDao.create(genre);
        
        genre.setGenreID(3L);
        genre.setName("Dah!");
        
        genreDao.create(genre);
        
        System.out.println("3 added:\n");
        List<Genre> list = genreDao.findAll();
        for(Genre var: list)
            System.out.println(var);
        
        genreDao.delete(2L);
        
        System.out.println("2 deleted:\n");
        list = genreDao.findAll();
        for(Genre var: list)
            System.out.println(var);
        
        genre.setGenreID(1L);
        genre.setName("Fus-Rouh!");
        
        genreDao.update(genre);
        
        System.out.println("1st updated:\n");
        list = genreDao.findAll();
        for(Genre var: list)
            System.out.println(var);
        
        genreDao.closeConnection();
    }
}
