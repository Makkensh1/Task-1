package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {

    private static String url = "jdbc:postgresql://localhost:5432/task1";
    private static String userName = "postgres";
    private static String password = "12345";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println("!!!");
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public static SessionFactory getSession() throws HibernateException {
        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url", url);
        prop.setProperty("hibernate.connection.username", userName);
        prop.setProperty("hibernate.connection.password", password);
        prop.setProperty("dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
        prop.setProperty("hibernate.hbm2ddl.auto", "update");
        prop.setProperty("hibernate.show_sql", "false");
        Configuration cfg = new org.hibernate.cfg.Configuration();
        cfg.addAnnotatedClass(User.class);
        cfg.setProperties(prop);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        return cfg.buildSessionFactory();
    }

}
