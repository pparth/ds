package com.odesk.directoryservice.service;

import com.odesk.directoryservice.configuration.DirectoryServiceConf;
import com.odesk.directoryservice.db.ApplicantRecommendationDAO;
import com.odesk.directoryservice.resource.ApplicantRecommendationResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.DBIFactory;
import org.skife.jdbi.v2.DBI;

public class DirectoryServiceSrv extends Service<DirectoryServiceConf> {

    public static void main(String[] args) throws Exception {
        new DirectoryServiceSrv().run(args);
    }

    private DirectoryServiceSrv() {
        super();
    }

    @Override
    public void initialize(Bootstrap<DirectoryServiceConf> directoryServiceConfBootstrap) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void run(DirectoryServiceConf directoryServiceConf, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI db = factory.build(environment, directoryServiceConf.getDatabaseConfiguration(), "mysql");

        environment.addResource(new ApplicantRecommendationResource(db.onDemand(ApplicantRecommendationDAO.class)));
        // environment.addHealthCheck(new DatabaseHealthCheck());
    }

}
