package structural.decoratorPattern;

// Sample
interface Coffee {
    String getDescription();
    double getCost();
}

class SimpleCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 2.6;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public String getDescription(){
        return coffee.getDescription();
    }

    @Override
    public double getCost(){
        return coffee.getCost();
    }
}


class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription(){
        return coffee.getDescription() + " Milk";
    }

    @Override
    public double getCost(){
        return coffee.getCost() + 0.5;
    }
}

class ChocolateDecorator extends CoffeeDecorator {

    public ChocolateDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Chocolate";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.7;
    }

}

public class Main {
    static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new ChocolateDecorator(coffee);

        System.out.println("Description: " + coffee.getDescription());
        System.out.println("Total Cost: $" + coffee.getCost());
    }

}
