package com.sigom.DependencyInjection.c_dependency_injection_interface;


public class Main {
    public static void main(String[] args) {

        ClientApplication app1 = new ClientApplication(new MailChimpService());
        app1.doSomeStuff();

        ClientApplication app2 = new ClientApplication(new MockTestService());
        app2.doSomeStuff();


    }
}
class ClientApplication {

    MessagingService service;
    public ClientApplication(MessagingService service){
        this.service = service;
    }

    public void doSomeStuff(){
        service.sendMessage("Hi this message using interface");
    }
}
interface MessagingService {
    void sendMessage(String message);
}
class MailChimpService implements MessagingService {

    @Override
    public void sendMessage(String message) {
        System.out.println("MailChimp services delivery : " + message);
    }
}
class MockTestService implements MessagingService{

    @Override
    public void sendMessage(String message) {
        System.out.println("Mocking the messaging service :" + message);
    }
}

