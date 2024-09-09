package shop;

import java.util.List;

public class Basket {
	public static List<CartItem> add(List<Products> products, List<CartItem> items, Integer idToAdd)
	{
		Products product = products.stream()
			.filter(prod -> prod.getId().equals(idToAdd))
			.findFirst().get();
		
		CartItem cartItem = items.stream()
			.filter(item -> item.getProduct().getId().equals(idToAdd))
			.findFirst().orElseGet(()->newItem(product, items));
		
		int count = cartItem.getCount().intValue();
		cartItem.setCount(count+1);
		cartItem.setTotalPrice(cartItem.getTotalPrice()+product.getPrice());
		
		return items;
	}

	private static CartItem newItem(Products product, List<CartItem> items) {
		CartItem item = new CartItem();
		item.setProduct(product);
		item.setCount(0);
		item.setTotalPrice(0.0);
		items.add(item);
		return item;
	}
	
	public static double getTotalPrice(List<CartItem> items)
	{
		double sum = 0.0;
		for(CartItem item : items)
		{
			sum+=item.getTotalPrice();
		}
		return sum;
	}
	

}
