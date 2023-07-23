import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class ToyStore {

    private static List<Toy> toys = new ArrayList();
    private static Random random = new Random();

    public ToyStore() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void setToyWeight(int id, double weight){
        for(Toy toy: toys){
            if(toy.getId() == id){
                toy.setWeight(weight);
                break;
            }
        }
    }

    public void drawToys() {
        if (toys.isEmpty()){
            System.out.println("В магазине нет игрушек. ");
            return;
        }
        double totalWeight = 0;
        for (Toy toy: toys) {
            totalWeight += toy.getWeight();
        }
        double randomNumber = random.nextDouble() * totalWeight;
        double currentWeight = 0;
        Toy chosenToy = null;
        for (Toy toy:toys) {
            currentWeight += toy.getWeight();
            if(randomNumber <= currentWeight) {
                chosenToy = toy;
                break;
            }
        }
        if (chosenToy != null) {
            if (chosenToy.getQuantity() > 0) {
                System.out.println("Поздравляем! вы выиграли игрушку: "+ chosenToy.getName());
                write(chosenToy.getName());
                chosenToy.setQuantity(chosenToy.getQuantity() - 1);
                if (chosenToy.getQuantity() == 0){
                    System.out.println("Данная игрушка в магазине закончилась ");
                    toys.remove(chosenToy);
                } else {
                    System.out.println("Оставшееся количество для выйгрыша данной игруши " + chosenToy.getQuantity());
                }
            } 
            else {
                System.out.println("Вы ничего не выиграли");
            }
        } else {
            System.out.println("Вы ничего не выиграли");
        }

    }

    public int size(){
        return toys.size() + 1;
    }

    public void write(String toy) {
        File file = new File("Выйгранные_игрушки.txt");
        try{
            FileWriter fr = new FileWriter(file,true);
            fr.write(toy);
            fr.write("\n");
            fr.close();
        }
        catch(IOException e) {
            System.out.println("Ошибка");
        }
    }

    public static void read() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Выйгранные_игрушки.txt"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void list() {
        for(Toy toy: toys){
            System.out.println(toy.getInfo());
        }
    }
}
