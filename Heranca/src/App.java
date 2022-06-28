import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
public class App {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Product> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("enter with number of products: ");
        int N = sc.nextInt();
        for(int i = 1; i <= N; i++){
            System.out.print("Common, used or imported(c/u/i): ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            if(ch == 'c'){
                    Product prod = new Product(name, price);
                    list.add(prod);
                    
            }
            else if(ch == 'u'){
                    System.out.print("Manufacture date (dd/MM/yyyy): ");
                    Date manufactureDate = sdf.parse(sc.next());
                    Product prod = new UsedProduct(name, price, manufactureDate);
                    list.add(prod);
            }
            else {
                    System.out.print("customs fee: ");
                    Double customsFee = sc.nextDouble();
                    Product prod = new ImportedProduct(name, price, customsFee);
                    list.add(prod);
            }
        }
            System.out.println();
            System.out.println("Price Tags: ");
            for(Product produ : list){
            System.out.println(produ.PriceTag());
        }
        sc.close();
    }
}
