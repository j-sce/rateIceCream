package rateIceCream.core.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import rateIceCream.core.domain.IceCream;

import java.util.List;

@Component
public class JdbcDatabaseImpl implements Database {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(IceCream iceCream) {
        jdbcTemplate.update("INSERT INTO ice_creams(name, producer, barcode) " +
                        "VALUES (?, ?, ?)",
                iceCream.getName(), iceCream.getProducer(), iceCream.getBarcode()
        );
    }

    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE FROM ice_creams WHERE id = ?";
        Object[] args = new Object[]{id};
        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public List<IceCream> getAllIceCreams() {
        String sql = "SELECT * FROM ice_creams";
        return jdbcTemplate.query(sql, new IceCreamRowMapper());
    }

    @Override
    public List<IceCream> findByName(String name) {
        String sql = "SELECT * FROM ice_creams WHERE name LIKE ?";
        Object[] args = new String[]{"%" + name + "%"};
        return jdbcTemplate.query(sql, args, new IceCreamRowMapper());
    }

    @Override
    public List<IceCream> findByProducer(String producer) {
        String sql = "SELECT * FROM ice_creams WHERE producer LIKE ?";
        Object[] args = new String[]{"%" + producer + "%"};
        return jdbcTemplate.query(sql, args, new IceCreamRowMapper());
    }

    @Override
    public List<IceCream> findByNameAndProducer(String name, String producer) {
        String sql = "SELECT * FROM ice_creams WHERE name LIKE ? AND producer LIKE ?";
        Object[] args = new String[]{"%" + name + "%", "%" + producer + "%"};
        return jdbcTemplate.query(sql, args, new IceCreamRowMapper());
    }

    @Override
    public List<IceCream> findByBarcode(String barcode) {
        String sql = "SELECT * FROM ice_creams WHERE barcode = ?";
        Object[] args = new Object[]{barcode};
        return jdbcTemplate.query(sql, args, new IceCreamRowMapper());
    }
}
