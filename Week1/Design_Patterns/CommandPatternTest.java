package com.example.commandpattern;

interface Command {
    void execute();
}
//package com.example.commandpattern;

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

//package com.example.commandpattern;

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
//package com.example.commandpattern;

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
//package com.example.commandpattern;

class Light {
    public void turnOn() {
        System.out.println("The light is on");
    }

    public void turnOff() {
        System.out.println("The light is off");
    }
}
//package com.example.commandpattern;

public class CommandPatternTest {
    public static void main(String[] args) {
        // Create a Light instance (receiver)
        Light light = new Light();

        // Create Command instances
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Create RemoteControl instance (invoker)
        RemoteControl remote = new RemoteControl();

        // Set and execute LightOnCommand
        remote.setCommand(lightOn);
        remote.pressButton();

        // Set and execute LightOffCommand
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}


