package DesignPatterns.structural.proxy.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProxyServer implements Server{
    Server mainServer;
    private User user;
    private UserSessionMeta sessionMeta;
    private AccessControl accessControl;

    public ProxyServer(User user, UserSessionMeta sessionMeta) {
        this.user = user;
        this.sessionMeta = sessionMeta;
        this.createAccessControl();
        this.createServerInstance();
    }

    private void createAccessControl(){
        if(this.accessControl==null) {
            this.accessControl = new UserAccessControl(user,sessionMeta,new ArrayList<>(), List.of(new Role("Admin")));
        }
    }
    private void createServerInstance(){
        if(this.mainServer ==null) {
            this.mainServer = ServerFactory.createServer();
            this.mainServer = new AccessControlProxy(this.mainServer,accessControl);
            this.mainServer = new LoggerProxy(this.mainServer,user ,sessionMeta);
        }

    }

    private void destroyServerInstance(){
        this.mainServer=null;
    }
    @Override
    public void updateName(String name) {
        this.mainServer.updateName(name);
    }

    @Override
    public void updateServerTime(Date date) {
        this.mainServer.updateServerTime(date);
    }

    @Override
    public void updateAccessPolicy(AccessPolicy policy) {
        this.mainServer.updateAccessPolicy(policy);
    }

    @Override
    public String getServerName() {
        return this.mainServer.getServerName();
    }

    @Override
    public Date getServerTime() {
        return this.mainServer.getServerTime();
    }

    @Override
    public AccessPolicy getAccessPolicy() {
        return this.mainServer.getAccessPolicy();
    }
}
