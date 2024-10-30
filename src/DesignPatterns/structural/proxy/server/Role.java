package DesignPatterns.structural.proxy.server;

public class Role implements Comparable<Role>{

    final String name;

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Role o) {
        return this.name.compareTo(o.getName()) ;
    }

    public boolean compare(Role o){
        return this.compareTo(o) ==0;
    }
}
