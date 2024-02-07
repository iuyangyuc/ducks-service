package yangyuc.ducksservice.model;

public class RedheadDuck extends Duck{
    public RedheadDuck(int id, Type type, FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(id, type, flyBehavior, quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("Displaying Redhead Duck");
    }
}
