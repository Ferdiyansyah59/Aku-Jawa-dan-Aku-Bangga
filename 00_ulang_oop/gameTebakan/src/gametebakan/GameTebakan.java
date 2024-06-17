import java.util.Scanner;

// Kelas dasar (superclass)
class Product {
    protected String productName;
    protected double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Product: " + productName);
        System.out.println("Price: $" + price);
    }

    public double calculateDiscount(double discountRate) {
        return price - (price * discountRate);
    }
}

// Kelas turunan pertama (subclass) untuk produk fisik
class PhysicalProduct extends Product {
    private double weight;

    public PhysicalProduct(String productName, double price, double weight) {
        super(productName, price);
        this.weight = weight;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Weight: " + weight + " kg");
    }

    public double calculateShippingCost() {
        // Dummy shipping cost calculation based on weight
        return weight * 2.5;
    }
}

// Kelas turunan kedua (subclass) untuk produk digital
class DigitalProduct extends Product {
    private String downloadLink;

    public DigitalProduct(String productName, double price, String downloadLink) {
        super(productName, price);
        this.downloadLink = downloadLink;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Download Link: " + downloadLink);
    }
}

public class GameTebakan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input data produk fisik
        System.out.print("Enter name for Physical Product: ");
        String physicalProductName = scanner.nextLine();
        System.out.print("Enter price for Physical Product: $");
        double physicalProductPrice = scanner.nextDouble();
        System.out.print("Enter weight for Physical Product (kg): ");
        double physicalProductWeight = scanner.nextDouble();

        PhysicalProduct physicalProduct = new PhysicalProduct(
                physicalProductName, physicalProductPrice, physicalProductWeight);

        // Input data produk digital
        scanner.nextLine(); // consume newline character
        System.out.print("\nEnter name for Digital Product: ");
        String digitalProductName = scanner.nextLine();
        System.out.print("Enter price for Digital Product: $");
        double digitalProductPrice = scanner.nextDouble();
        scanner.nextLine(); // consume newline character
        System.out.print("Enter download link for Digital Product: ");
        String downloadLink = scanner.nextLine();

        DigitalProduct digitalProduct = new DigitalProduct(
                digitalProductName, digitalProductPrice, downloadLink);

        // Menampilkan informasi produk
        System.out.println("\nPhysical Product Information:");
        physicalProduct.displayInfo();
        System.out.println("Discounted Price: $" + physicalProduct.calculateDiscount(0.1));
        System.out.println("Shipping Cost: $" + physicalProduct.calculateShippingCost());

        System.out.println("\nDigital Product Information:");
        digitalProduct.displayInfo();
        System.out.println("Discounted Price: $" + digitalProduct.calculateDiscount(0.05));

        scanner.close();
    }
}
