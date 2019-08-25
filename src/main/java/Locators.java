import org.openqa.selenium.By;

public class Locators {

    public static final By H1_TTILE = By.xpath ("//h1");

    //Media Page
    public static final By LINK_MEDIA = By.cssSelector("a[href='https://romanceabroad.com/media/index']");
    public static final By LINK_PHOTO = By.cssSelector("a[@href='https://romanceabroad.com/media/photo']");
    public static final By LINK_VIDEO = By.cssSelector("a[@href='https://romanceabroad.com/media/video]");
    public static final By LINK_ALBUMS = By.cssSelector("a[@href='https://romanceabroad.com/media/albums]");
    public static final By GALLERY_FILTERS = By.xpath ("//ul[@id='gallery_filters']//li");

    public static final By LINK_JOIN_TODAY = By.xpath ("//div[@class='col-lg-12 text-center']//a[@href='#']");
    //Main Page
    public static final By NAVIGATION_MENU = By.xpath("//ul[@class='navbar-nav']//li");
    public static final By TITLE_OF_PAGE = By.cssSelector("//hi");
    public static final By IFRAME_VIDEO = By.xpath("//div[@class='video']//iframe");
    public static final By BUTTON_PLAY = By.xpath("//button[@class='ytp-large-play-button ytp-button']");
    public static final By BUTTON_LOGIN = By.cssSelector("#ajax_login_link");
    public static final By TEXT_FIELD_LOGIN_EMAIL = By.xpath ("//div[@class='lc-content-inner']//input[@id='email']");
    public static final By TEXT_FIELD_LOGIN_PASSWORD = By.xpath ("//div[@class='lc-content-inner']//input[@id='password']");
    public static final By BUTTON_SIGN_IN = By.xpath ("//button[@class='btn btn-primary']");
    public static final By IMAGES = By.xpath ("//a[@class='g-pic-border g-rounded']");
    //Registration
    public static final By BUTTON_REGISTRATION = By.cssSelector("#show-registration-block");
    public static final By BUTTON_NEXT = By.xpath("//button[@data-action='next-page'][text()='Next']");
    public static final By TEXT_FIELD_EMAIL = By.cssSelector("input#email");
    public static final By TEXT_FIELD_PASSWORD = By.cssSelector("input#password");
    public static final By TEXT_FIELD_NICKNAME = By.cssSelector("#nickname");
    public static final By LIST_DAY = By.cssSelector("#daySelect");
    public static final By LIST_DAY_VALUE = By.xpath("//li[@data-handler='selectDay']");
    public static final By LIST_MONTH = By.cssSelector("#monthSelect");
    public static final By LIST_MONTH_VALUE = By.xpath("//li[@data-handler='selectMonth']");
    public static final By LIST_YEAR = By.cssSelector("#yearSelect");
    public static final By LIST_YEAR_VALUE = By.xpath("//li[@data-handler='selectYear']");
    public static final By TEXT_FIELD_PHONE = By.cssSelector("input[name='data[phone]']");
    public static final By CHECKBOX_TERMS = By.cssSelector("input#confirmation");
    public static final By AUTOFILLING_FORM_LOCATION = By.xpath ("//input[@name='region_name']");
    public static final By LIST_VALUE_LOCATION = By.xpath("//div[@class='dropdown dropdown_location']//ul//li");

    //Search Page

    public static final By LINK_SEARCH = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    public static final By PROFILE = By.cssSelector("a[href='https://romanceabroad.com/users/view/358/profile']");
    public static final By DROP_DOWN_LIST_SORT_BY = By.xpath("//div[@class='form-inline']//select");
    public static final By DROP_DOWN_LIST_SORT_BY_MIN_AGE = By.xpath("//select[@id='age_min']");
    public static final By DROP_DOWN_LIST_SORT_BY_MAX_AGE = By.cssSelector ("select#age_max");
    public static final By BUTTON_SEARCH = By.cssSelector("#main_search_button_user_advanced");

    //Tours Page
    public static final By LINK_TOUR_TO_UKRAINE = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine']");
    public static final By SEARCH_FIELD_PRODUCT = By.cssSelector ("#search_product");
    public static final By BUTTON_QUICK_VIEW = By.xpath("//buttton[@class='btn btn-primary']");
    public static final By BUTTON_SEARCH_PRODUCT = By.cssSelector("#search_friend");
    public static final By FOOTER_OPTIONS = By.xpath ("//div[@class='footer-menu-list-group-item-text']");
    public static final By LINK_CONTACT_US = By.xpath ("//a[@id='footer_footer-menu-help-item_footer-menu-tickets-item']");

    //Gifts Page
    public static final By LINK_GIFTS = By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']");
    public static final By LINK_TEDDY_BEARS = By.xpath ("//a[@href='https://romanceabroad.com/store/sweets/11-teddy_bear']");
    public static final By LINK_FLOWER_BASKET = By.xpath ("https://romanceabroad.com/store/sweets/12-flower_basket");

    //Contact Us Page
    public static final By LIST_REASON = By.xpath ("//select[@name='id_reason']");
    public static final By TEXT_FIELD_USER_NAME_CONTACT_US = By.xpath (" //input[@name='user_name']");
    public static final By TEXT_FIELD_EMAIL_CONTACT_US = By.xpath ("//input[@name='user_email']");
    public static final By TEXT_FIELD_SUBJECT_CONTACT_US = By.xpath ("//input[@name='user_name']");
    public static final By TEXT_FIELD_MESSAGE_CONTACT_US = By.xpath ("//textarea[@name='message']");
    public static final By TEXT_FIELD_CAPTCHA = By.cssSelector ("#g-recaptcha-response");
    public static final By BUTTON_SEND_CONTACT_US = By.xpath ("//input[@name='btn_save']");

    //Blog Page
    public static final By LINK_BLOG = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");
    public static final By LINKS_OF_ARTICLES = By.xpath ("//ul[@class='nav nav-pills nav-stacked content-pages-tree']//li");
}
