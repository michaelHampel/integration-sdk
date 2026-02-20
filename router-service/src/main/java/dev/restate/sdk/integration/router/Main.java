package dev.restate.sdk.integration.router;

import dev.restate.sdk.http.vertx.RestateHttpServer;
import dev.restate.sdk.endpoint.Endpoint;

public class Main {
    public static void main(String[] args) {
        RestateHttpServer.listen(
            Endpoint.builder()
                .bind(new RouterService())
                .build(),
            9080);
    }
}
