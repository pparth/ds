package com.odesk.directoryservice.service;

import com.odesk.directoryservice.configuration.DirectoryServiceConf;
import com.odesk.directoryservice.db.ApplicantRecommendationDAO;
import com.odesk.directoryservice.resource.ApplicantRecommendationResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.Database;
import com.yammer.dropwizard.db.DatabaseFactory;

public class DirectoryServiceSrv extends Service<DirectoryServiceConf> {

    public static void main(String[] args) throws Exception {
        new DirectoryServiceSrv().run(args);
    }

    private DirectoryServiceSrv() {
        super("Odesk Directory Service");
    }

    @Override
    protected void initialize(DirectoryServiceConf directoryServiceConf, Environment environment) throws Exception {

        final DatabaseFactory factory = new DatabaseFactory(environment);
        final Database db = factory.build(directoryServiceConf.getDatabaseConfiguration(), "mysql");

        environment.addResource(new ApplicantRecommendationResource(db.onDemand(ApplicantRecommendationDAO.class)));
        // environment.addHealthCheck(new DatabaseHealthCheck());
    }
}
