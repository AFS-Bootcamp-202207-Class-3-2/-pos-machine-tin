package pos.machine;

/**
 * @author 陈祁天
 * @date 2022/7/19
 * @description 回执实体类
 */
public class Receipt {
    private String barcode;

    private String Name;

    private int price;

    private Integer Quantity;

    private Integer UnitPrice;

    private Integer Subtotal;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public Integer getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        UnitPrice = unitPrice;
    }

    public Integer getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        Subtotal = subtotal;
    }
}
