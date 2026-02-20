package dev.restate.sdk.integration.servicea;

import dev.restate.sdk.annotation.Handler;
import dev.restate.sdk.annotation.Service;
import dev.restate.sdk.integration.ExternalInterface;

@Service
public class ServiceA implements ExternalInterface {
    @Handler
    @Override
    public String greet(String name) {
        return "Hello from ServiceA, " + name;
    }
}
