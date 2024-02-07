package yangyuc.ducksservice.model;

public abstract class Duck{
    private Integer id;
    private Type type;
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public Duck(int id, Type type, FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.id = id;
        this.type = type;
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public Duck(int id, Type type) {
        this.id = id;
        this.type = type;
    }

    public record DuckData(Integer id, String type) {
        public String toLine() {
            return id + " " + type;
        }

        public static DuckData fromLine(String line) {
            String[] parts = line.split(" ");
            return new DuckData(Integer.parseInt(parts[0]), parts[1].toUpperCase());
        }
    }
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Type getType() { return type; }

    public void setType(Type type) { this.type = type; }

    public void swim() {
        System.out.println("Swimming");
    }

    public void display() {
        System.out.println("Displaying");
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public FlyBehavior getFlyBehavior() { return flyBehavior; }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public QuackBehavior getQuackBehavior() { return quackBehavior; }
}
