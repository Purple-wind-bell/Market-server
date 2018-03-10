package cn.ys.vo;

import java.io.Serializable;

/**
 * book类
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Product implements Serializable {
	private Integer id;
	private String name;
	private String ownername;
	private Float price;
	/** 存放图片路径 */
	private String path;
	/** 文件名 唯一 */
	private String filename;
	/** 描述 */
	private String description;

	/** 分类 多对一 */
	private Category category;// 书籍分类

	public Product() {
	}

	public Product(Integer id, String name, String ownername, Float price, String path, String filename,
			String description, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.ownername = ownername;
		this.price = price;
		this.path = path;
		this.filename = filename;
		this.description = description;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Float getPrice() {
		return price;
	}

	public String getPath() {
		return path;
	}

	public String getFilename() {
		return filename;
	}

	public String getDescription() {
		return description;
	}

	public Category getCategory() {
		return category;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

}
