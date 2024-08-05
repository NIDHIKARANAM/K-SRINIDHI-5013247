package deepskilling;

 class Computer {
 private String CPU;
 private String RAM;
 private String Storage;
 private String GPU;
 private String OS;

 private Computer(Builder builder) {
     this.CPU = builder.CPU;
     this.RAM = builder.RAM;
     this.Storage = builder.Storage;
     this.GPU = builder.GPU;
     this.OS = builder.OS;
 }

 public static class Builder {
     private String CPU;
     private String RAM;
     private String Storage;
     private String GPU;
     private String OS;

     public Builder setCPU(String CPU) {
         this.CPU = CPU;
         return this;
     }

     public Builder setRAM(String RAM) {
         this.RAM = RAM;
         return this;
     }

     public Builder setStorage(String Storage) {
         this.Storage = Storage;
         return this;
     }

     public Builder setGPU(String GPU) {
         this.GPU = GPU;
         return this;
     }

     public Builder setOS(String OS) {
         this.OS = OS;
         return this;
     }

     public Computer build() {
         return new Computer(this);
     }
 }

 @Override
 public String toString() {
     return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + Storage + ", GPU=" + GPU + ", OS=" + OS + "]";
 }
}

public class TestBuilderPattern {
 public static void main(String[] args) {
     Computer gamingPC = new Computer.Builder()
         .setCPU("Intel i9")
         .setRAM("32GB")
         .setStorage("1TB SSD")
         .setGPU("NVIDIA RTX 3080")
         .setOS("Windows 11")
         .build();

     Computer officePC = new Computer.Builder()
         .setCPU("Intel i5")
         .setRAM("16GB")
         .setStorage("512GB SSD")
         .build();

     System.out.println("Gaming PC Configuration: " + gamingPC);
     System.out.println("Office PC Configuration: " + officePC);
 }
}

