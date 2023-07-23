public class Toy {
    private int id;
    private String name;
    private int quantity;
    private double weight;

    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity(){
        return quantity;
    }

    public double getWeight(){
        return weight;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("No ");
        sb.append(id);
        sb.append(". ");
        sb.append(name);
        sb.append(". Оставшееся количество ");
        sb.append(quantity);
        return sb.toString();
    }

    @Override
    public String toString() {
       return "No " + this.id + ". " + this.name  + ". Оставшееся количество " + this.quantity;
    }

}

