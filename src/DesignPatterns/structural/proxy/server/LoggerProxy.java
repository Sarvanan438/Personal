package DesignPatterns.structural.proxy.server;

import java.util.Date;

public class LoggerProxy implements Server{

    private Server server;
    private User user;
    private UserSessionMeta meta;

    public LoggerProxy(Server server, User user, UserSessionMeta meta) {
        this.server = server;
        this.user = user;
        this.meta = meta;
    }

    @Override
    public void updateName(String name) {
        System.out.println("changing user name "+user.getUser());
        this.server.updateName(name);
    }

    @Override
    public void updateServerTime(Date date) {
        System.out.println("updated server time from "+this.server.getServerTime().toString());
        this.server.updateServerTime(date);
    }

    @Override
    public void updateAccessPolicy(AccessPolicy policy) {

    }

    @Override
    public String getServerName() {
        System.out.println("Accessing server name "+this.user.getUser());
        return this.server.getServerName();
    }

    @Override
    public Date getServerTime() {
        return null;
    }

    @Override
    public AccessPolicy getAccessPolicy() {
        return null;
    }
}
