interface Animal {
    void sound();
}
class Dog implements Animal {
    public void sound() {
        System.out.println("Woof Woof");
    }
}
public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();
    }
}
