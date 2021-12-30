package com.severstal;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import com.severstal.pages.MainDemoqaPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DemoqaFormTest {
    private static final Faker faker = new Faker();
    private static final TestData testData = new TestData();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1280";
        open("https://demoqa.com/automation-practice-form");

        testData
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setUserEmail(faker.internet().emailAddress())
                .setUserNumber(faker.phoneNumber().subscriberNumber(10))
                .setCurrentAddress(faker.address().fullAddress())
                .setDateOfBirth(faker);
        ;
    }

    @Test
    void fillStudentRegistrationForm () {
        new MainDemoqaPage().
                practiceFormPage
                .setStudentRegistrationForm(testData)
                .checkStudentRegistrationForm(testData)
        ;
    }
}
