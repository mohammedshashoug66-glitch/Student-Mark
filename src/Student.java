public class Student {
    private String registrationNumber;
    private String name;
    private int age;
    private double mark1;
    private double mark2;
    private double mark3;

    // Parameterized Constructor with validation
    public Student(String registrationNumber, String name, int age, double mark1, double mark2, double mark3) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        setAge(age);
        setMark1(mark1);
        setMark2(mark2);
        setMark3(mark3);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than 0.");
        }
        this.age = age;
    }

    public double getMark1() {
        return mark1;
    }

    public void setMark1(double mark1) {
        validateMark(mark1, "Mark 1");
        this.mark1 = mark1;
    }

    public double getMark2() {
        return mark2;
    }

    public void setMark2(double mark2) {
        validateMark(mark2, "Mark 2");
        this.mark2 = mark2;
    }

    public double getMark3() {
        return mark3;
    }

    public void setMark3(double mark3) {
        validateMark(mark3, "Mark 3");
        this.mark3 = mark3;
    }

    private void validateMark(double mark, String label) {
        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException(label + " must be between 0 and 100.");
        }
    }

    // Calculate average mark
    public double calculateAverage() {
        return (mark1 + mark2 + mark3) / 3.0;
    }

    // Determine academic status
    public String getStatus() {
        return calculateAverage() >= 50.0 ? "PASS" : "FAIL";
    }

    // Display all student information
    public void displayInformation() {
        double average = calculateAverage();
        System.out.println("======================================");
        System.out.println("Registration Number : " + registrationNumber);
        System.out.println("Name                : " + name);
        System.out.println("Age                 : " + age);
        System.out.println("Mark 1              : " + mark1);
        System.out.println("Mark 2              : " + mark2);
        System.out.println("Mark 3              : " + mark3);
        System.out.printf("Average             : %.2f%n", average);
        System.out.println("Status              : " + getStatus());
        System.out.println("======================================");
    }
}