package com.example.builderpattern;

class Computer {
    // Attributes
    private String CPU;
    private String RAM;
    private String storage;
    private String graphicsCard;
    private String operatingSystem;

    // Private constructor to enforce object creation via the Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.operatingSystem = builder.operatingSystem;
    }

    // Getters
    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getStorage() {
        return storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    // Static nested Builder class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private String operatingSystem;

        // Methods to set each attribute
        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        // Build method to create an instance of Computer
        public Computer build() {
            return new Computer(this);
        }
    }
}


public class BuilderPatternTest {
    public static void main(String[] args) {
        // Create different configurations of Computer using the Builder
        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA GeForce RTX 3080")
                .setOperatingSystem("Windows 10")
                .build();

        Computer officeComputer = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setOperatingSystem("Windows 10")
                .build();

        // Display the configurations
        System.out.println("Gaming Computer Configuration:");
        System.out.println("CPU: " + gamingComputer.getCPU());
        System.out.println("RAM: " + gamingComputer.getRAM());
        System.out.println("Storage: " + gamingComputer.getStorage());
        System.out.println("Graphics Card: " + gamingComputer.getGraphicsCard());
        System.out.println("Operating System: " + gamingComputer.getOperatingSystem());

        System.out.println("\nOffice Computer Configuration:");
        System.out.println("CPU: " + officeComputer.getCPU());
        System.out.println("RAM: " + officeComputer.getRAM());
        System.out.println("Storage: " + officeComputer.getStorage());
        System.out.println("Operating System: " + officeComputer.getOperatingSystem());
    }
}


// No changes needed in this step as the private constructor and the Builder class are already implemented in Step 2.
