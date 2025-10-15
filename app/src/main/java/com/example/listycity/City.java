package com.example.listycity;

/**
 * This is a class that defines a City object.
 * It stores the city's name and its province.
 */
public class City implements Comparable<City> {

    /** The name of the city. */
    private String city;

    /** The name of the province. */
    private String province;

    /**
     * Creates a new City with a given name and province.
     * @param city the name of the city
     * @param province the name of the province
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name.
     * @return the name of the city
     */
    public String getCityName() {
        return this.city;
    }

    /**
     * Gets the province name.
     * @return the name of the province
     */
    public String getProvinceName() {
        return this.province;
    }

    /**
     * Compares two City objects alphabetically by their city name.
     * @param o another City object to compare with
     * @return negative if this city comes before, 0 if same, positive if after
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }
}
