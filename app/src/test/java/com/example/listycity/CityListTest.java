package com.example.listycity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    // --- Helpers ---
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    // --- 21. add() adds a new city ---
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    // --- 22. add() duplicate throws ---
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> cityList.add(city));
    }

    // --- 24. getCities() sorted order ---
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    // --- hasCity() true/false ---
    @Test
    void testHasCity() {
        CityList list = mockCityList();
        City present = mockCity();
        City absent = new City("Calgary", "Alberta");

        assertTrue(list.hasCity(present));
        assertFalse(list.hasCity(absent));
    }

    // --- delete() removes when present ---
    @Test
    void testDeleteRemoves() {
        CityList list = new CityList();
        City edm = new City("Edmonton", "Alberta");
        City cal = new City("Calgary", "Alberta");
        list.add(edm);
        list.add(cal);

        list.delete(edm);

        assertFalse(list.hasCity(edm));
        assertTrue(list.hasCity(cal));
        assertEquals(1, list.countCities());
    }

    // --- delete() throws when absent ---
    @Test
    void testDeleteThrowsWhenAbsent() {
        CityList list = mockCityList(); // contains Edmonton
        City absent = new City("Regina", "Saskatchewan");

        assertThrows(IllegalArgumentException.class, () -> list.delete(absent));
    }

    // --- countCities() returns size ---
    @Test
    void testCountCities() {
        CityList list = new CityList();
        assertEquals(0, list.countCities());
        list.add(new City("Edmonton", "Alberta"));
        list.add(new City("Calgary", "Alberta"));
        assertEquals(2, list.countCities());
    }
}
