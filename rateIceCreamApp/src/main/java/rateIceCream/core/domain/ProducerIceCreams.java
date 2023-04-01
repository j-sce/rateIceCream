package rateIceCream.core.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "producer_ice_creams")
public class ProducerIceCreams {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producer_id", nullable = false)
    private Producer producer;

    @ManyToOne
    @JoinColumn(name = "ice_cream_id", nullable = false)
    private IceCream iceCream;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public IceCream getIceCream() {
        return iceCream;
    }

    public void setIceCream(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProducerIceCreams that = (ProducerIceCreams) o;
        return getId().equals(that.getId()) && getProducer().equals(that.getProducer()) && getIceCream().equals(that.getIceCream());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProducer(), getIceCream());
    }

    @Override
    public String toString() {
        return "ProducerIceCreams{" +
                "id=" + id +
                ", producer=" + producer +
                ", iceCream=" + iceCream +
                '}';
    }
}
