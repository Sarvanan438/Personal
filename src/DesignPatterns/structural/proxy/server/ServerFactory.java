package DesignPatterns.structural.proxy.server;

import java.util.Date;

public class ServerFactory {

    public static Server createServer(){
        return new MainServer("main-server", new Date(),new AccessPolicy("0.0.0.0",0,47));
    }
}
