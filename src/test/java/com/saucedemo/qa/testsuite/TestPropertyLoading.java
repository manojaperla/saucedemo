package com.saucedemo.qa.testsuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestPropertyLoading {

	public static void main(String[] args) {
		try (InputStream input = new FileInputStream("src/test/resources/app.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("app.url"));
            System.out.println(prop.getProperty("app.std.username"));
            System.out.println(prop.getProperty("app.user.password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

	}

}
