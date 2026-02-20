package dev.restate.sdk.integration.serviceb;

import dev.restate.sdk.annotation.Handler;
import dev.restate.sdk.annotation.Service;
import dev.restate.sdk.integration.ExternalInterface;

@Service
public class ServiceB implements ExternalInterface {
    @Handler
    @Override
    public String greet(String name) {
        return "Hello from ServiceB, " + name;
    }
}
