package com.jupiter.product;

public class CompareProductByPrice implements ICompareStrategy {

	protected double price;

	public CompareProductByPrice(double price) {
		this.price = price;
	}

	@Override
	public boolean CompareProduct(Product product) {
		// TODO Auto-generated method stub
		return product.getPrice() == this.price;
	}

}
