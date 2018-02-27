package cn.ys.dao;

import java.util.List;

import cn.ys.vo.Category;

public interface CategoryDao {

	void save(Category category);

	boolean findByName(String categoryName);

	/**
	 * 全部查询
	 * 
	 * @return
	 */
	List<Category> findAll();

	/**
	 * id查询分类
	 * 
	 * @param categoryId
	 * @return
	 */
	Category findById(Integer categoryId);

	/**
	 * 根据分类名删除分类
	 * 
	 * @param categoryName
	 * @return
	 */
	boolean deleteByName(String categoryName);

	/**
	 * 修改
	 * 
	 * @param categoryName
	 * @param category
	 * @return
	 */
	boolean update(Integer id, Category category);
}
