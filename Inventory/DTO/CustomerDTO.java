package Inventory.DTO;

public class CustomerDTO {
    private String custName, custPhone, custAddress, custEmail;
    private int custID;

    public CustomerDTO(String cusName, String cusPhone, String cusAddress, String cusEmail, int cusID) {
        this.custName = cusName;
        this.custPhone = cusPhone;
        this.custAddress = cusAddress;
        this.custEmail = cusEmail;
        this.custID = cusID;
    }

    public String getCusName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCusEmail() {
        return custEmail;
    }

    public void setCusEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public int getCustID() {
        return custID;
    }

    public void setCusID(int custID) {
        this.custID = custID;
    }
    
}
