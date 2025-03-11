package SlightlyAdvanced;

// 基类
class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("动物发出声音。");
    }
}

// 继承自基类，并且重写发出叫声的方法
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + "汪汪叫。");
    }
}

// 继承自基类，并且重写发出叫声的方法
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + "喵喵叫。");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Animal dog = new Dog("狗狗");
        Animal cat = new Cat("猫猫");
        // 实现了多态
        dog.makeSound();
        cat.makeSound();
    }
}
