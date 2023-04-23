package rateIceCream.matchers;

import org.mockito.ArgumentMatcher;
import rateIceCream.core.domain.Producer;

public class ProducerMatcher implements ArgumentMatcher<Producer> {

    private String name;

    public ProducerMatcher(String name) {
        this.name = name;
    }

    @Override
    public boolean matches(Producer producer) {
        return producer.getName().equals(name);
    }
}
