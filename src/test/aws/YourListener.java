package test.aws;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class YourListener implements ServletContextListener {

@Override
public void contextInitialized(ServletContextEvent contextEvent) {

}

@Override
public void contextDestroyed(ServletContextEvent contextEvent) {

    try {
        com.amazonaws.http.IdleConnectionReaper.shutdown();
    } catch (Throwable t) {
        // log the error
    }
}
}