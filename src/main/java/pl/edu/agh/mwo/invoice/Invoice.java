package pl.edu.agh.mwo.invoice;

<<<<<<< HEAD
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
=======
>>>>>>> 8c86a74c20832bb8edd2023ac9535db42ddc7fb0
import pl.edu.agh.mwo.invoice.product.Product;

import java.math.BigDecimal;
import java.util.HashMap;

import static java.math.BigDecimal.ZERO;

public class Invoice {
<<<<<<< HEAD
    private Map<Product, Integer> products = new HashMap<Product, Integer>();

    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException();
=======
    private HashMap<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product) {
        this.addProduct(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        if (quantity.equals(0) || Integer.signum(quantity) == -1) {
            throw new IllegalArgumentException("Quantity can not be zero or negative!");
>>>>>>> 8c86a74c20832bb8edd2023ac9535db42ddc7fb0
        }
        products.put(product, quantity);
    }

<<<<<<< HEAD
    public BigDecimal getNetTotal() {
        BigDecimal totalNet = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalNet = totalNet.add(product.getPrice().multiply(quantity));
        }
        return totalNet;
    }

    public BigDecimal getTaxTotal() {
        return getGrossTotal().subtract(getNetTotal());
    }

    public BigDecimal getGrossTotal() {
        BigDecimal totalGross = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
        }
        return totalGross;
=======
    public BigDecimal getSubtotal() {
        BigDecimal subtotal = ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = BigDecimal.valueOf(products.get(product));
            BigDecimal tempSubtotal = product.getPrice().multiply(quantity);
            subtotal = subtotal.add(tempSubtotal);
        }
        return subtotal;
    }

    public BigDecimal getTax() {
        BigDecimal tax = ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = BigDecimal.valueOf(products.get(product));
            BigDecimal tempTax = product.getPrice().multiply(product.getTaxPercent()).multiply(quantity);
            tax = tax.add(tempTax);
        }
        return tax;
    }

    public BigDecimal getTotal() {
        BigDecimal total = ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = BigDecimal.valueOf(products.get(product));
            BigDecimal tempTotal = product.getPrice().add(product.getPrice().multiply(product.getTaxPercent())).multiply(quantity);
            total = total.add(tempTotal);
        }
        return total;
>>>>>>> 8c86a74c20832bb8edd2023ac9535db42ddc7fb0
    }
}