package rateIceCream.core.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_ice_cream_ratings")
public class UserIceCreamRating {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "ice_cream_id", nullable = false)
    private IceCream iceCream;

    @Column(name = "user_ice_cream_rating")
    private Long rating;

    public UserIceCreamRating(User user, IceCream iceCream, Long rating) {
        this.user = user;
        this.iceCream = iceCream;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public IceCream getIceCream() {
        return iceCream;
    }

    public void setIceCream(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserIceCreamRating that = (UserIceCreamRating) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(iceCream, that.iceCream) && Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, iceCream, rating);
    }

    @Override
    public String toString() {
        return "UserIceCreamRating{" +
                "id=" + id +
                ", user=" + user +
                ", iceCream=" + iceCream +
                ", rating=" + rating +
                '}';
    }
}
