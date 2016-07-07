package com.toneloc.olympicsapp;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by t on 7/6/16.
 */
public class CountryUnitTest {

    @Test
    public void returnsCorrectName() throws Exception {
        Country testCountry = new Country("Persia", 12, 14, 16);
        assertEquals("Persia",testCountry.getmName());
    }
}

//exits correctly