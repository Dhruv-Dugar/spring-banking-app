package com.spring.Banking.Config;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id= "features")
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean isEmployeeServiceHealthy= checkEmployeeServiceHealth();
        if(isEmployeeServiceHealthy){
            return Health.up()
                    .withDetail("Employee Service" ,"Up and running")
                    .build();
        }
        else{
            return Health.down()
                    .withDetail("Employee Service","Down")
                    .build();
        }

        //@ReadOperation
        //return null;
    }

    private boolean checkEmployeeServiceHealth() {
      //  return databaseService.isDatabaseHealthy();
        return true;
    }

    @ReadOperation
    public Health features() {
        return health();
    }
}
