import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BlogTests extends BaseUI {
    String nameOfArticle;
    String titleOfArticle;

    @Test
    public void testArticlesAndTitles(){
        mainPage.clickTabBlog ();
        List<WebElement> linksOfArticles = blogPage.collectAllLinksOfArticles ();

        for (int i = 0; i < linksOfArticles.size (); i ++) {
            WebElement link = linksOfArticles.get (i);
            nameOfArticle = link.getText ();
            link.click ();
            titleOfArticle = blogPage.getAnyTitle ();
            Assert.assertEquals (nameOfArticle,titleOfArticle);
            linksOfArticles = blogPage.collectAllLinksOfArticles ();

        }
    }



}


