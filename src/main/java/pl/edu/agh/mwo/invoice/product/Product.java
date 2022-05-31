package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
    private final String name;

    private final BigDecimal price;

    private final BigDecimal taxPercent;

    protected Product(String name, BigDecimal price, BigDecimal tax) {
<<<<<<< HEAD
        if (name == null || name.equals("") || price == null
                || tax == null || tax.compareTo(new BigDecimal(0)) < 0
                || price.compareTo(new BigDecimal(0)) < 0) {
            throw new IllegalArgumentException();
=======
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null and cannot be empty.");
        }
        if (price == null || price.signum() == -1) {
            throw new IllegalArgumentException("Price cannot be negative and null.");
>>>>>>> 8c86a74c20832bb8edd2023ac9535db42ddc7fb0
        }
        this.name = name;
        this.price = price;
        this.taxPercent = tax;
    }

    public String getName() {
<<<<<<< HEAD
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTaxPercent() {
        return taxPercent;
    }

    public BigDecimal getPriceWithTax() {
        return price.multiply(taxPercent).add(price);
=======
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getTaxPercent() {
        return this.taxPercent;
    }

    public BigDecimal getPriceWithTax() {
        return this.price.multiply(this.taxPercent).add(this.price);
>>>>>>> 8c86a74c20832bb8edd2023ac9535db42ddc7fb0
    }
}