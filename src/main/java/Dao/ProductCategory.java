package Dao;



public class ProductCategory {

	private int categoryid;
	private String categoryname;
	private String description;
	
	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductCategory [categoryID=" + categoryid + ", categoryName=" + categoryname + ", description="
				+ description + "]";
	}
	
}
