package cn.ys.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import cn.ys.dao.ProductDao;
import cn.ys.util.C3P0Util;
import cn.ys.vo.Product;

public class ProductDaoImpl implements ProductDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	@Override
	public boolean addProduct(Product product) {
		int row = -1;
		try {
			row = qr.update(
					"insert into product (name, ownername, price, path, filename, description) values(?,?,?,?,?,?)",
					product.getName(), product.getOwnername(), product.getPrice(), product.getPath(),
					product.getFilename(), product.getDescription());
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return row != -1;
	}

	@Override
	public List<Product> findAll() {
		try {
			return qr.query("select * from product", new BeanListHandler<Product>(Product.class));
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public List<Product> findByOwner(String ownername) {
		try {
			return qr.query("select * from product where ownername = ?", new BeanListHandler<Product>(Product.class),
					ownername);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void updateProduct(Integer proId, Product product) {
		try {
			qr.update("update product set name = ?, price = ?, description = ? where id = ?", product.getName(),
					product.getPrice(), product.getDescription(), proId);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public boolean deleteProductById(Integer id) {
		int row = -1;
		try {
			row = qr.update("delete from product where id = ?", id);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return row != -1;
	}

	@Override
	public List<Product> findByName(String productName) {
		List<Product> p = null;
		try {
			p = qr.query("select * from product where name = ?", new BeanListHandler<Product>(Product.class),
					productName);
		} catch (SQLException e) {
			throw new RuntimeException("ss");
		}
		return p;
	}

	@Override
	public Product findById(Integer id) {
		Product p = null;
		try {
			p = qr.query("select * from product where id = ?", new BeanHandler<Product>(Product.class), id);
		} catch (SQLException e) {
			throw new RuntimeException("ss");
		}
		return p;
	}

}
