
public class Product {

	private long id;
	private String name;
	private int quantity;
	private Category category;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
