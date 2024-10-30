package DesignPatterns.structural.proxy.server;

import java.util.Date;

public interface Server {

    void updateName(String name);
    void updateServerTime(Date date);
    void updateAccessPolicy(AccessPolicy policy);
    String getServerName();
    Date getServerTime();
    AccessPolicy getAccessPolicy();
}
