package yangyuc.ducksservice.model;

public class MallardDuck extends Duck{
    public MallardDuck(int id, Type type, FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(id, type, flyBehavior, quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("Displaying Mallard Duck");
    }
}
