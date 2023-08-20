package hibernate;

import org.flywaydb.core.Flyway;
import org.h2.jdbcx.JdbcDataSource;

import java.io.IOException;
import java.util.Properties;

public class DBInitService {
    private static String URL = "";
    private static String LOGIN = "";
    private static String PASSWORD = "";

    public JdbcDataSource getProperties() {
        Properties properties = new Properties();
        JdbcDataSource dataSource = new JdbcDataSource();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            properties.load(classLoader.getResourceAsStream("hibernate.properties"));
            URL = properties.getProperty("hibernate.connection.url");
            LOGIN = properties.getProperty("hibernate.connection.username");
            PASSWORD = properties.getProperty("hibernate.connection.password");

            dataSource.setURL(URL);
            dataSource.setUser(LOGIN);
            dataSource.setPassword(PASSWORD);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load database.", e);
        }
        return dataSource;
    }

    public void initDB() {
        JdbcDataSource dataSource = getProperties();

        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .load();

        flyway.migrate();
    }

}
