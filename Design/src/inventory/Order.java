package inventory;

import java.util.List;
import java.util.Map;

public class Order {

	private Store store;
	private String nationality;
	private String passport;
	private Map<String, Inventory> inventories;

	public Order(Store store, String passport, List<Inventory> inventories) {
		super();
		this.store = store;
		this.passport = passport;
		setNationality(passport);
		setInventories(inventories);
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String passport) {
		if (passport != null && passport.length() > 0) {
			if (Constant.BRAZIL_REGEX.matcher(passport).find(0)) {
				this.nationality = Constant.BRAZIL;
			} else if (Constant.ARGENTINA_REGEX.matcher(passport).find(0)) {
				this.nationality = Constant.ARGENTINA;
			} else
				this.nationality = null;
		}
	}

	public Map<String, Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		for (Inventory inv : inventories) {
			this.inventories.put(inv.getItemType(), inv);
		}
	}
}
