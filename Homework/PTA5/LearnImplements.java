package Homework.PTA5;
interface AnimalSound {
    void makeSound();
}

class Dog implements AnimalSound {
    @Override
    public void makeSound() {
        System.out.println("汪汪");
    }
}

class Cat implements AnimalSound {
    @Override
    public void makeSound() {
        System.out.println("喵喵");
    }
}

public class LearnImplements {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        dog.makeSound();
        cat.makeSound();
        AnimalSound dog1 = new Dog();
        AnimalSound cat1 = new Cat();
        dog1.makeSound();
        cat1.makeSound(); 
    }
}
