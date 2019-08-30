package com.romanceabroad.ui;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ContactUsTests extends BaseUI {

    @DataProvider(name = "ContactUs")
    public static Object[][] testContactUsForm() throws Exception{
        ArrayList<Object[]>out = new ArrayList<> ();
        Files.readAllLines (Paths.get ("ContactUs.txt")).stream ().forEach (s -> {

            String[] data = s.split (",");
            out.add (new Object[]{data[0], data[1], data[2], data[3]});
        });
        return  out.toArray (new Object[out.size ()][]);
    }

    @Test(dataProvider = "ContactUs")
    public void testContactUsform(String nickname, String email, String subject, String message){

        mainPage.clickLinkContactUs ();
        contactUsPage.contactUsSelectReason ();
        contactUsPage.contactUsCompleteForm (contactUsPage.generateNewNumber(Data.captcha, 5), nickname,
                email, subject, message);

    }
}
