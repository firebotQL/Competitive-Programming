import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis. People must
 * adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether they
 * would prefer a dog or a cat (and  will receive the oldest animal of that type). They cannot select which specific
 * animal they would like. Create the data structure to maintain this system and implement operations such as
 * enqueue, dequeueAny, dequeueDog and dequeueCat. You may sue the build-in LinkedList data structure.
 */
public class Main {
    public static void main(String[] args) {
        
    }

    public static class AnimalShelter {
        private LinkedList<Animal> cats = new LinkedList<Animal>();
        private LinkedList<Animal> dogs = new LinkedList<Animal>();
        int order;

        public void enqueue(Animal animal) {
            animal.setOrder(order++);
            if (animal instanceof Cat) {
                cats.addFirst(animal);
            } else {
                dogs.addFirst(animal);
            }
        }

        public Animal dequeueAny() {
            if (cats.isEmpty() && dogs.isEmpty()) {
                throw new NoSuchElementException();
            }
            if (cats.isEmpty() && !dogs.isEmpty()) {
                return dogs.removeLast();
            }
            if (!cats.isEmpty() && dogs.isEmpty()) {
                return cats.removeLast();
            }
            Animal cat = cats.getLast();
            Animal dog = dogs.getLast();

            if (cat.getOrder() > dog.getOrder()) {
                return dogs.removeLast();
            }

            return cats.removeLast();
        }

        public Cat dequeueCat() {
            return (Cat)cats.removeLast();
        }

        public Dog dequeueDog() {
            return (Dog)dogs.removeLast();
        }
    }

    public static class Animal {
        private int order;
        protected int getOrder() { return order; }
        protected void setOrder(int order) { this.order = order; }
    }
    public static class Cat extends Animal {

    }
    public static class Dog extends Animal {

    }
}
