package dev.restate.sdk.integration.serviceb;

import dev.restate.sdk.http.vertx.RestateHttpServer;
import dev.restate.sdk.endpoint.Endpoint;

public class Main {
    public static void main(String[] args) {
        RestateHttpServer.listen(
            Endpoint.builder()
                .bind(new ServiceB())
                .build(),
            9080);
    }
}
