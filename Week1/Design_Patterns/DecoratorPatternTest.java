package com.example.decoratorpattern;

interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email with message: " + message);
    }
}


abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}


class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS with message: " + message);
    }
}



class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlackNotification(message);
    }

    private void sendSlackNotification(String message) {
        System.out.println("Sending Slack notification with message: " + message);
    }
}

public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Create the basic notifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate the notifier with SMS and Slack notifications
        Notifier smsAndEmailNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackSmsAndEmailNotifier = new SlackNotifierDecorator(smsAndEmailNotifier);

        // Send notifications via multiple channels
        String message = "Hello, this is a test message!";
        slackSmsAndEmailNotifier.send(message);
    }
}

