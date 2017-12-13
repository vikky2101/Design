package inventory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class OrderService {

	private static HashMap<String, Store> allStores = new HashMap<String, Store>();

	public static void initilaizeStores() {
		allStores.put(Constant.ARGENTINA,
				new Store(Constant.ARGENTINA,
						new Inventory(Constant.IPHONE, Constant.ARG_IPHONE_PRICE, Constant.ARG_IPHONE_COUNT),
						new Inventory(Constant.IPOD, Constant.ARG_IPOD_PRICE, Constant.ARG_IPOD_COUNT)));

		allStores.put(Constant.BRAZIL,
				new Store(Constant.BRAZIL,
						new Inventory(Constant.IPHONE, Constant.BRAZIL_IPHONE_PRICE, Constant.BRAZIL_IPHONE_COUNT),
						new Inventory(Constant.IPOD, Constant.BRAZIL_IPOD_PRICE, Constant.BRAZIL_IPOD_COUNT)));

	}

	public static String processOrder(String input) {
		String tokens[] = input.split(":");
		Store store = allStores.get(tokens[0]);
		String passport = tokens[1];
		List<Inventory> inventories = new LinkedList<Inventory>();
		for (int i = 2; i < tokens.length; i++) {
			inventories.add(new Inventory(tokens[i], Integer.parseInt(tokens[i + 1])));
		}
		Order order = new Order(store, passport, inventories);
		int price = calculateCost(store, order);
		StringBuilder sb = new StringBuilder();
		sb.append(price).append(":")
				.append(allStores.get(Constant.ARGENTINA).getInventories().get(Constant.IPHONE).itemCount).append(":")
				.append(allStores.get(Constant.BRAZIL).getInventories().get(Constant.IPHONE).itemCount).append(":")
				.append(allStores.get(Constant.ARGENTINA).getInventories().get(Constant.IPOD).itemCount).append(":")
				.append(allStores.get(Constant.BRAZIL).getInventories().get(Constant.IPOD).itemCount);
		return sb.toString();
	}

	private static int calculateCost(Store store, Order order) {
		int cost = 0;
		Map<String, Inventory> inventories = order.getInventories();
		for (Map.Entry<String, Inventory> entry : inventories.entrySet()) {
			cost += store.getInventories().get(entry.getValue().itemType).itemPrice * entry.getValue().itemCount;
		}

		return cost;

	}
}
