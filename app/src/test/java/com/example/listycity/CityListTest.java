package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    // --- Helper methods ---
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    // --- 21. Test add() method ---
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        // Verify size increased + city added
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    // --- 22. Test duplicate add throws exception ---
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        // Adding duplicate should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    // --- 24. Test getCities() behavior ---
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        // The first city retrieved from getCities() should match mockCity
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        // Add a new city that comes alphabetically before "Edmonton"
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // Now the new city should be first, and the original city second
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

}
