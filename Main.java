import java.io.IOException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ToyStore store = new ToyStore();
        store.addToy(new Toy(1, "Автомобиль", 5, 10));
        store.addToy(new Toy(2, "Вертолет", 5, 10.2));
        store.addToy(new Toy(3, "Танк", 5, 12.6));
        store.addToy(new Toy(4, "Кукла", 5, 16));
        store.addToy(new Toy(5, "Мяч", 5, 30));
        store.addToy(new Toy(6, "Лего", 5, 7.5));
        store.addToy(new Toy(7, "Робот", 5, 20));
        
        Scanner scanner = new Scanner(System.in, "ibm866");
        
        boolean exit = false;

        while(!exit){
            System.out.println("Выберите действие: ");
            System.out.println("1. Розыгрыш игрушки");
            System.out.println("2. Добавление новой игрушки");
            System.out.println("3. Изменение веса (частоты выпадения) игрушки");
            System.out.println("4. Список игрушек в магазине");
            System.out.println("5. Список выйгранных игрушек");
            System.out.println("5. Выйти");
            
            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                    store.drawToys();
                    break;
                case 2:
                    int id = store.size();
                    System.out.println("Введите название новой игрушки: ");
                    String name = scanner.next();
                    System.out.println("Введите количество новой игрушки: ");
                    int quantity = scanner.nextInt();
                    System.out.println("Введите вес (частоту выпадения) новой игрушки: ");
                    double weight = scanner.nextDouble();
                    store.addToy(new Toy(id, name, quantity, weight));
                    break;
                case 3:
                    System.out.println("Введите id игрушки, у которой необходимо изменить вес: ");
                    int toyId = scanner.nextInt();
                    System.out.println("Введите новый вес(частоту выпадения) игрушки: ");
                    double newWeight = scanner.nextDouble();
                    store.setToyWeight(toyId, newWeight);
                    break;
                case 4:
                    store.list();
                    break;
                case 5:
                    store.read();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз. ");
                    break;
                
            }

        }
        scanner.close();
    }
}