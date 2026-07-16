package com.yashraj.base;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage {

    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    protected void click(Locator locator) {
        locator.click();
    }

    protected void fill(Locator locator, String value) {
        locator.fill(value);
    }

    protected String getText(Locator locator) {
        return locator.textContent();
    }
}