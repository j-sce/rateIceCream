package rateIceCream;

import java.util.Objects;

public class IceCream {

    private long id;
    private String name;
    private String producer;
    private long volume;

    public IceCream(String name, String producer, long volume) {
        this.name = name;
        this.producer = producer;
        this.volume = volume;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", volume=" + volume +
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
                Objects.equals(volume, iceCream.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, producer, volume);
    }
}
