package DesignPatterns.structural.proxy.server;

public class User implements Comparable<User> {

    private String user;
    private Role role;

    public User(String user, Role role) {
        this.user = user;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public String getUser() {
        return user;
    }


    @Override
    public int compareTo(User o) {
        return o.getUser().compareTo(this.user) + o.getRole().compareTo(this.role);
    }

    public boolean isEqual(User user){
        return this.compareTo(user)==0;
    }


}
