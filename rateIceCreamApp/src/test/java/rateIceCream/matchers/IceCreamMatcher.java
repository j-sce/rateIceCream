package rateIceCream.matchers;

import org.mockito.ArgumentMatcher;
import rateIceCream.core.domain.IceCream;

public class IceCreamMatcher implements ArgumentMatcher<IceCream> {

    private String name;
    private String producer;
    private String barcode;

    public IceCreamMatcher(String name, String producer, String barcode) {
        this.name = name;
        this.producer = producer;
        this.barcode = barcode;
    }

    @Override
    public boolean matches(IceCream iceCream) {
        return iceCream.getName().equals(name)
                && iceCream.getProducer().equals(producer)
                && iceCream.getBarcode().equals(barcode);
    }
}
