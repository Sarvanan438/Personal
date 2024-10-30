package DesignPatterns.structural.proxy.server;

public class UserSessionMeta {
    private String ip,mac;

    public UserSessionMeta(String ip, String mac) {
        this.ip = ip;
        this.mac = mac;
    }

    public String getIp() {
        return ip;
    }

    public String getMac() {
        return mac;
    }
}
