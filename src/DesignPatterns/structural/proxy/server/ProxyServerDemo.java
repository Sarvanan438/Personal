    package DesignPatterns.structural.proxy.server;

    public class ProxyServerDemo {

        public static void main(String[] args) {
            Server server = new ProxyServer(new User("admin user", new Role("Admin")),new UserSessionMeta("0.0.0.0","12.1l232;"));

            server.updateName("new server");
        }
    }
