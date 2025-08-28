package pro.skypro.skyshop.model.product;

public class DiscountedProduct extends Product {
    private final int basicPrice;
    private final double discount;

    public DiscountedProduct(String name, int basicPrice, double discount) {
        super(name);
        if (basicPrice <= 0) {
            throw new IllegalArgumentException("Неверная цена!");
        }
        this.basicPrice = basicPrice;
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Неверная скидка!");
        }
        this.discount = discount;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    @Override
    public int getPrice() {
        return (int) (basicPrice * (1 - discount / 100));
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public Product clone() {
        return new DiscountedProduct(this.name, this.basicPrice, this.discount);
    }

    @Override
    public String toString() {
        return name + ": " + getPrice() + "₽" + " (скидка " + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
