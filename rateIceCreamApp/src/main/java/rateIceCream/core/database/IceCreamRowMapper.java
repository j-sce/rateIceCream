package rateIceCream.core.database;

import org.springframework.jdbc.core.RowMapper;
import rateIceCream.core.domain.IceCream;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IceCreamRowMapper implements RowMapper<IceCream> {
    @Override
    public IceCream mapRow(ResultSet rs, int rowNum) throws SQLException {
        IceCream iceCream = new IceCream();
        iceCream.setId(rs.getLong("id"));
        iceCream.setName(rs.getString("name"));
        iceCream.setProducer(rs.getString("producer"));
        iceCream.setBarcode(rs.getString("barcode"));
        return iceCream;
    }
}
