package com.stc.andreybell.practice.webserver;

import org.springframework.stereotype.Service;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.MonoProcessor;
import reactor.netty.http.server.HttpServer;

import java.nio.file.Paths;

import static reactor.core.publisher.Flux.just;

@Service
public class AppServer {


    public void run() {
        HttpServer.create()
                .host("localhost")
                .port(8081)
                .route(routes -> routes
                        .file("/file", Paths.get("E:\\videos\\Videoclip3.avi"))
//                        .directory("/directory", Paths.get("E\\videos\\"))
                        .get("/", (req, res) -> res.sendString(just("hello")))
                        .post("/add", (req, res) -> {
                            return res.sendString(just(req.receiveObject().toString()));
                        })
                        .get("/info", (req, res) -> res.sendString(just("Created by belyaev-a"))))
                .bind()
                .block();
    }

}
