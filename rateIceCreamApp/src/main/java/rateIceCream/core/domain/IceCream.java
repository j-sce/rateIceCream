package rateIceCream.core.domain;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ice_creams")
public class IceCream {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "producer", nullable = false)
    private String producer;

    @Column(name = "barcode", nullable = false)
    private String barcode;

    public IceCream() {
    }

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
