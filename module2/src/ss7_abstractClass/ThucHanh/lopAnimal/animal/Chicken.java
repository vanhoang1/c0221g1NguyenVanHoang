package ss7_abstractClass.ThucHanh.lopAnimal.animal;
import  ss7_abstractClass.ThucHanh.lopAnimal.edible.Edible;
public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }
    @Override
    public String howToEat() {
        return "could be fried";
    }
}
