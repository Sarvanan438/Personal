package DesignPatterns.structural.proxy.server;

import java.util.Date;

public class MainServer implements Server{
    private String name;
    private Date date;
    private AccessPolicy accessPolicy;


    @Override
    public void updateName(String name) {
        this.name=name;
    }

    public MainServer(String name, Date date, AccessPolicy accessPolicy) {
        this.name = name;
        this.date = date;
        this.accessPolicy = accessPolicy;
    }

    @Override
    public void updateServerTime(Date date) {
        this.date=date;
    }

    @Override
    public void updateAccessPolicy(AccessPolicy policy) {
            this.accessPolicy=policy;
    }

    @Override
    public String getServerName() {
        return this.name;
    }

    @Override
    public Date getServerTime() {
        return this.date;
    }

    @Override
    public AccessPolicy getAccessPolicy() {
        return this.accessPolicy;
    }
}
