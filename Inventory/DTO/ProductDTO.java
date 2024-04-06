package Inventory.DTO;

public class ProductDTO{
    private String proID, proName, proPrice, proOrigin, proRemain, proQuantity;

    public ProductDTO(String proID, String proName, String proPrice, String proOrigin, String proRemain, String proQuantity) {
        this.proID = proID;
        this.proName = proName;
        this.proPrice = proPrice;
        this.proOrigin = proOrigin;
        this.proRemain = proRemain;
        this.proQuantity = proQuantity;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProPrice() {
        return proPrice;
    }

    public void setProPrice(String proPrice) {
        this.proPrice = proPrice;
    }

    public String getProOrigin() {
        return proOrigin;
    }

    public void setProOrigin(String proOrigin) {
        this.proOrigin = proOrigin;
    }

    public String getProRemain() {
        return proRemain;
    }

    public void setProRemain(String proRemain) {
        this.proRemain = proRemain;
    }

    public String getProQuantity() {
        return proQuantity;
    }

    public void setProQuantity(String proQuantity) {
        this.proQuantity = proQuantity;
    }
    
    
}