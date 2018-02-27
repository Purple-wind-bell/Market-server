package cn.ys.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import cn.ys.dao.CategoryDao;
import cn.ys.util.C3P0Util;
import cn.ys.vo.Category;

public class CateGoryDaoImpl implements CategoryDao {
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

	@Override
	public void save(Category category) {
		try {
			qr.update("insert into category (name, description) values(?,?)", category.getName(),
					category.getDescription());
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	public Category findByName1(String categoryName) {
		Category c = null;
		try {
			c = qr.query("select * from category where name = ?", new BeanHandler<Category>(Category.class),
					categoryName);
		} catch (SQLException e) {
			throw new RuntimeException("ss");
		}
		return c;
	}

	@Override
	public boolean findByName(String categoryName) {
		Category c = null;
		try {
			c = qr.query("select * from category where name = ?", new BeanHandler<Category>(Category.class),
					categoryName);
		} catch (SQLException e) {
			throw new RuntimeException("ss");
		}
		return c != null;
	}

	@Override
	public List<Category> findAll() {
		try {
			return qr.query("select * from category", new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public Category findById(Integer categoryId) {
		try {
			return qr.query("select * from category where id = ?", new BeanHandler<Category>(Category.class),
					categoryId);
		} catch (SQLException e) {
			throw new RuntimeException("ss");
		}
	}

	@Override
	public boolean deleteByName(String categoryName) {
		int row = -1;
		try {
			row = qr.update("delete from category where name = ?", categoryName);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return row != -1;
	}

	@Override
	public boolean update(Integer id, Category category) {
		int row = -1;
		try {
			System.out.println(id);
			row = qr.update("update category set name = ?, description = ? where id = ?", category.getName(),
					category.getDescription(), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row != -1;
	}

}
