package dev.restate.sdk.integration.router;

import dev.restate.sdk.Restate;
import dev.restate.sdk.annotation.Handler;
import dev.restate.sdk.annotation.Service;
import dev.restate.sdk.integration.ExternalInterface;

@Service
public class RouterService {

    public record RouteRequest(String targetService, String name) {}

    @Handler
    public String route(RouteRequest request) {
        return Restate.service(ExternalInterface.class, request.targetService()).greet(request.name());
    }
}
