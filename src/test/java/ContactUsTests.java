import org.testng.annotations.Test;

public class ContactUsTests extends BaseUI {
    @Test
    public void testContactUsform(){

        contactUsPage.contactUsTests (contactUsPage.generateNewNumber(Data.captcha, 5), Data.nickname,
                Data.email, Data.subject);

    }
}
