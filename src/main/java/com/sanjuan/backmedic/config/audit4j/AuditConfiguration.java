package com.sanjuan.backmedic.config.audit4j;

import lombok.AllArgsConstructor;
import org.audit4j.core.MetaData;
import org.audit4j.core.handler.ConsoleAuditHandler;
import org.audit4j.core.handler.Handler;
import org.audit4j.core.handler.file.FileAuditHandler;
import org.audit4j.core.layout.Layout;
import org.audit4j.core.layout.SimpleLayout;
import org.audit4j.handler.db.DatabaseAuditHandler;
import org.audit4j.integration.spring.AuditAspect;
import org.audit4j.integration.spring.SpringAudit4jConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.yaml.snakeyaml.Yaml;
import reactor.event.Event;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Configuration
@EnableAspectJAutoProxy
//@PropertySource("classpath:ddbbaudit4j.properties")
public class AuditConfiguration {

    private final Environment environment;

    @Bean
    public Layout layout() {
        return new SimpleLayout();
    }

    @Bean
    public MetaData metaData() {
        return new MyMetaData();
    }

    @Bean
    public CustomDatabaseAuditHandler databaseHandler() {
        CustomDatabaseAuditHandler databaseHandler = new CustomDatabaseAuditHandler();
        databaseHandler.setEmbedded("false");
//        databaseHandler.setDefault_table_name("AUDITORIA");
//        databaseHandler.setSchema("MEDIC");
        databaseHandler.setDb_user("postgres");
        databaseHandler.setDb_password("heredia.89");
        databaseHandler.setDb_url("jdbc:postgresql://localhost:5432/postgres");
//        databaseHandler.setDb_url("jdbc:oracle:thin:@localhost:1521/FREEPDB1");
        databaseHandler.setDb_driver("org.postgresql.Driver");
        return databaseHandler;
    }



    @Bean
    public FileAuditHandler fileAuditHandler() {
        return new FileAuditHandler();
    }

    @Bean
    public ConsoleAuditHandler consoleAuditHandler() {
        return new ConsoleAuditHandler();
    }


    @Bean
    public SpringAudit4jConfig springAudit4jConfig() {
        SpringAudit4jConfig audit4jConfig = new SpringAudit4jConfig();
        Map<String, String> props = new HashMap<>();
        props.put("log.file.location", ".");
        List<Handler> handlers = new ArrayList<>();
//        handlers.add(consoleAuditHandler());
//        handlers.add(fileAuditHandler());
        handlers.add(databaseHandler());
        audit4jConfig.setHandlers(handlers);
        audit4jConfig.setLayout(layout());
        audit4jConfig.setMetaData(metaData());
        audit4jConfig.setProperties(props);
        return audit4jConfig;

    }

    @Bean
    public AuditAspect auditAspect() {
        return new AuditAspect();
    }
}