package io.hedwig.explore.todo.mapimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;

/**
 * Created by patrick on 2017/6/30.
 */

@SpringBootApplication
@EnableAutoConfiguration
public class ToDoServiceApplication {

    private static final Logger logger = LoggerFactory.getLogger(ToDoServiceApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        logger.info("start ToDoService Server and Start Up parameters are: ");
        for (final String arg : args) {
            logger.info(arg);
        }

        SpringApplication app = new SpringApplication(ToDoServiceApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        Environment env  = app.run(args).getEnvironment();
        logger.info("Access URLs: Local http://127.0.0.1:{}: External: http:{}:{}",
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
//       SpringApplication ap = (SpringApplication) SpringApplication.run(ToDoServiceApplication.class,args);
        Set<ApplicationListener<?>> listeners =  app.getListeners();
        for (ApplicationListener<?> listener : listeners) {
           logger.info(listener.toString());
        }
        logger.info("End of starting ToDoService Server");
    }
}
