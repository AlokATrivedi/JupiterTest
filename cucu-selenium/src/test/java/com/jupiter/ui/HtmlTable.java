package com.jupiter.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HtmlTable {

	private WebElement element;

	public HtmlTable(WebElement element) {
		this.element = element;

	}

	private int getColumnIndex(String columnName) throws Exception {

		List<WebElement> headerList = this.element.findElements(By.cssSelector("thead th"));
		for (WebElement header : headerList) {
			if (header.getText().trim().equals(columnName)) {
				return headerList.indexOf(header);
			}
		}

		throw new Exception("Column Name not found");
	}

	public WebElement getCellValue(String findColumn, String findValue, String returnColumn) throws Exception {
		int findColumnIndex = this.getColumnIndex(findColumn);
		int returnColumnIndex = this.getColumnIndex(returnColumn);
		List<WebElement> rowList = this.element.findElements(By.cssSelector("tbody tr"));
		for (WebElement row : rowList) {
			List<WebElement> rowCellList = row.findElements(By.tagName("td"));
			if (rowCellList.get(findColumnIndex).getText().trim().equals(findValue)) {
				return rowCellList.get(returnColumnIndex);
			}
		}
		throw new Exception("No items found");

	}

	public WebElement getRowByIndex(int index) throws Exception {
		List<WebElement> rowlist = this.element.findElements(By.cssSelector("tbody tr"));
		if (index <= rowlist.size()) {
			return rowlist.get(index);
		}
		throw new Exception("Could not find the row");
	}
	
	public int getTableSize(){
		List<WebElement> rowlist = this.element.findElements(By.cssSelector("tbody tr"));
		return rowlist.size();
	}
}
