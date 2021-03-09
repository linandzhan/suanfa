package mianshiTi.克隆.用clone实现深浅克隆;

public class Address implements Cloneable{
    private String addressName;

    private String number;

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Address(String addressName, String number) {
        this.addressName = addressName;
        this.number = number;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
