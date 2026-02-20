package dev.restate.sdk.integration.servicea;

import dev.restate.sdk.http.vertx.RestateHttpServer;
import dev.restate.sdk.endpoint.Endpoint;

public class Main {
    public static void main(String[] args) {
        RestateHttpServer.listen(
            Endpoint.builder()
                .bind(new ServiceA())
                .build(),
            9080);
    }
}
