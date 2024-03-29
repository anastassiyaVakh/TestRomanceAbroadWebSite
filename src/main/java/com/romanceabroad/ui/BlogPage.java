package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BlogPage extends BaseActions {

    public BlogPage(WebDriver driver, WebDriverWait wait){
        super( driver,wait);
    }

    String currentUrlBlog;

    public String verifyBlogLinkIsDisplayed(){
        getNavigateToLinkPage (Locators.LINK_BLOG);
        currentUrlBlog = driver.getCurrentUrl ();
        return currentUrlBlog;
    }

    public List<WebElement> collectAllLinksOfArticles(){
        List<WebElement> linksOfArticles = driver.findElements (Locators.LINKS_OF_ARTICLES);
        return linksOfArticles;
      }
}