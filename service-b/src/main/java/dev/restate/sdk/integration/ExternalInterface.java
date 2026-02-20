package dev.restate.sdk.integration;

import dev.restate.sdk.annotation.Handler;

public interface ExternalInterface {
    @Handler
    String greet(String name);
}
