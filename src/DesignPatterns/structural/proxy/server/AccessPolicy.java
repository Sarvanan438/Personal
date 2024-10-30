package DesignPatterns.structural.proxy.server;

public class AccessPolicy {
    private String whitelistIps;
    int maxAccessLimit,bandNumber;

    public AccessPolicy(String whitelistIps, int maxAccessLimit, int bandNumber) {
        this.whitelistIps = whitelistIps;
        this.maxAccessLimit = maxAccessLimit;
        this.bandNumber = bandNumber;
    }

    public String getWhitelistIps() {
        return whitelistIps;
    }

    public int getMaxAccessLimit() {
        return maxAccessLimit;
    }

    public int getBandNumber() {
        return bandNumber;
    }
}
