package rateIceCream.core.domain;

import java.util.Objects;

public class IceCream {

    private Long id;
    private String name;
    private String producer;
    private String barcode;

    public IceCream(String name, String producer, String barcode) {
        this.name = name;
        this.producer = producer;
        this.barcode = barcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", barcode=" + barcode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IceCream iceCream = (IceCream) o;
        return Objects.equals(id, iceCream.id) &&
                Objects.equals(name, iceCream.name) &&
                Objects.equals(producer, iceCream.producer) &&
                Objects.equals(barcode, iceCream.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, producer, barcode);
    }
}
