import java.time.LocalDate;
import java.util.Locale;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

class Order {
    private int orderID;
    private LocalDate orderDate;
    private OrderDetail[] lineItems;
    private int count;

    public Order() {
    }

    public Order(int orderID, LocalDate orderDate) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.lineItems = new OrderDetail[10];
        this.count = 0;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    } 

    public OrderDetail[] getLineItems() {
        return lineItems;
    }

    public void setLineItems(OrderDetail[] lineItems) {
        this.lineItems = lineItems;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void addLineItem(Product product, int quantity) {
        lineItems[count++] = new OrderDetail(product, quantity);
    }

    public double calcTotalCharge() {
        double total = 0;
        for (int i = 0; i < count; i++) {
          total += lineItems[i].calcTotalPrice();
        }
        return total;
      }

    public String toString() {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
        String str = numberFormat.format(count);
        StringBuilder sb = new StringBuilder();
        sb.append("\nMa HD: ").append(orderID).append("\nNgay lap hoa don: ").append(orderDate).append("\n");
        for (int i = 0; i < count; i++) {
          sb.append("\n\t").append(lineItems[i]).append("\n");
        }
        sb.append("\nTong tien thanh toan: ").append(calcTotalCharge() + " VND\n");
        return sb.toString();
      }
  }
  
class OrderDetail {
    private int quantity;
    private Product product;

    public OrderDetail(Product product, int quantity) {
      this.product = product;
      this.quantity = quantity;
    }  

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double calcTotalPrice() {
        return product.calcTotalPrice(quantity);
    }

    public String toString() {
        return String.format(" %s  | So luong: %d  | Thanh tien: %.2f VND", product, quantity, calcTotalPrice());
    }
}
class Product {
    private String description;
    private String productID;
    private double price;

    public Product() {
    }

    public Product(String description, String productID, double price) {
        this.description = description;
        this.productID = productID;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double calcTotalPrice(int quantity) {
        return this.price * quantity;
    }
    public String toString() {
        return String.format("Ma SP: %s  | Mo ta: %s  | Don gia: %.2f", description, productID, price);
    }
}

 class labTH3 {
  public static void main(String[] args) {
    Product p1 = new Product("sp4", "Nuoc tuong", 8000);
    Product p2 = new Product("sp1", "Gao", 18000);
    Product p3 = new Product("sp3", "Duong", 10000);
    Product p4 = new Product("sp1", "Gao", 18000);
    Order o1 = new Order(1, LocalDate.now());
    o1.addLineItem(p1, 10);
    o1.addLineItem(p2, 5);
    o1.addLineItem(p3, 1);
    o1.addLineItem(p4, 1);
    System.out.println(o1.toString());
    }
}