package at.htl.websocket;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Server server = new Server();
        server.start();

        Client client = new Client();
        client.start();

        server.join();
        client.join();
    }
}
