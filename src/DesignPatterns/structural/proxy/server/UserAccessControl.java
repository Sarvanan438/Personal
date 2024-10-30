package DesignPatterns.structural.proxy.server;

import java.util.List;

public class UserAccessControl implements AccessControl{
    private User user ;
    private UserSessionMeta sessionMeta;
    private List<User> authorizedUser;
    private List<Role> authorizedRoles;

    public UserAccessControl(User user, UserSessionMeta sessionMeta, List<User> authorizedUser, List<Role> authorizedRoles) {
        this.user = user;
        this.sessionMeta = sessionMeta;
        this.authorizedUser = authorizedUser;
        this.authorizedRoles = authorizedRoles;
    }


    private boolean isUserAllowed(){
        return this.authorizedUser.contains(this.user);
    }

    private boolean isRoleAllowed(){
        return this.authorizedRoles.contains(this.user.getRole());
    }
    @Override
    public boolean isAuthorized() {
        return this.isRoleAllowed() || this.isUserAllowed() ;
    }
}
