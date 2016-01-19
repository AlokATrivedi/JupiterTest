package com.jupiter.product;

public class CompareProductByTitle implements ICompareStrategy {

	protected String title;

	public CompareProductByTitle(String title) {
		this.title = title;
	}
	@Override
	public boolean CompareProduct(Product product) {
		// TODO Auto-generated method stub
		return product.getTitle().equals(this.title);
	}

}
