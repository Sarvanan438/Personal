package DesignPatterns.structural.proxy.server;

import java.util.Date;

public class AccessControlProxy implements Server{

    private Server server;
    private AccessControl accessControl;
    public AccessControlProxy(Server server,AccessControl accessControl) {
        this.server = server;
    }

    private boolean isUserAllowed(){
        return this.accessControl.isAuthorized();
    }
    @Override
    public void updateName(String name) {
        this.isUserAllowed();
         this.server.updateName(name);
    }

    @Override
    public void updateServerTime(Date date) {

    }

    @Override
    public void updateAccessPolicy(AccessPolicy policy) {

    }

    @Override
    public String getServerName() {
        return "";
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
