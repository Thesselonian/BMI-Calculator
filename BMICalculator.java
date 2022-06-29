import java.util.*;

public class BMICalculator {
    public static void main(String[] args) {
        Person userInformation = getUserInformation();
        System.out.println("Your BMI is: " + calculateBMI(userInformation));
    }
    // Person class with weight and height properties
    // Inspired by https://www.techiedelight.com/return-multiple-values-method-java/
    public static class Person {
        public double weight;
        public double height;

        // Person method to store weight and height properties on person object
        public Person(double weight, double height) {
            this.weight = weight;
            this.height = height;
        }
    }
    // Method to calculate BMI using Person object passed in as argument
    static double calculateBMI(Person Person) {
        double weight = Person.weight;
        double height = Person.height;
        double BMI = (704*weight)/(height*height);
        return BMI;
    }
    // Method to get users height and weight, store as properties on generated Person object
    static Person getUserInformation() {
        Scanner keyboard = new Scanner(System.in);
        double weight = 0.0;
        double heightInInches = 0.0;
        Boolean validResponse = true;

        System.out.println("Enter your weight in pounds");
        // do while loop that will continue once the users response is valid. 
        do {
            try {
                weight = keyboard.nextDouble();
                validResponse = true;
                if(weight<=0) {
                    throw new Exception("Your response must be a positive value");
                }
                keyboard.nextLine();
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Your response was invalid. Please try again to enter your weight in pounds.");
                validResponse = false;
                keyboard.nextLine();
            }
        }
        while(!validResponse);
        System.out.println("Enter your height in inches.");
        do {
            try {
                heightInInches = keyboard.nextDouble();
                validResponse = true;
                keyboard.nextLine();
                if(heightInInches<=0) {
                    throw new Exception("Your response must be a positive value");
                }
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Your response was invalid. Please try again to enter your height in inches");
                validResponse = false;
                keyboard.nextLine();
            }
        }
        while(!validResponse);
        return new Person(weight, heightInInches);
    }
}