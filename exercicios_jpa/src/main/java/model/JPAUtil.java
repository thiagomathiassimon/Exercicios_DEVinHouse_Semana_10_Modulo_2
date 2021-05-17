package model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    public static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("exercicios_devinhouse");

}
