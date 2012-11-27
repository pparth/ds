package com.odesk.directoryservice.health;


import com.yammer.metrics.core.HealthCheck;

public class DatabaseHealthCheck  extends HealthCheck{

    public DatabaseHealthCheck() {
        super("database");
    }

    @Override
    protected Result check() throws Exception {
        if (true) {
            return Result.healthy();
        } else {
            return Result.unhealthy("Cannot connect to database.");
        }
    }

}
