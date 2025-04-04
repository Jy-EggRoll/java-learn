package Homework.PTA5;
class Box<T> {
    private T content;

    public Box(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}

public class Learn {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>(10);
        Integer num = integerBox.getContent();
        System.out.println(num);
    }
}
