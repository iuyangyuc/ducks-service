package yangyuc.ducksservice.model;

public class RubberDuck extends Duck{
    public RubberDuck(int id, Type type, FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(id, type, flyBehavior, quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("Displaying Rubber Duck");
    }
}
