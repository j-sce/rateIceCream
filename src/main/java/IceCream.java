import java.util.Objects;

public class IceCream {

    private String name;
    private String producer;
    private int volume;

    public IceCream(String name, String producer, int volume) {
        this.name = name;
        this.producer = producer;
        this.volume = volume;
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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IceCream iceCream)) return false;
        return getVolume() == iceCream.getVolume() && Objects.equals(getName(), iceCream.getName()) && Objects.equals(getProducer(), iceCream.getProducer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getProducer(), getVolume());
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", volume=" + volume +
                '}';
    }
}
