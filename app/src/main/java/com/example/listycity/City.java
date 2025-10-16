package com.example.listycity;

import java.util.Objects;

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

    /**
     * Two City objects are considered equal if they have the same city and province names.
     * @param o the other object to compare
     * @return true if both cities have the same name and province
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City cityObj = (City) o;
        return Objects.equals(city, cityObj.city)
                && Objects.equals(province, cityObj.province);
    }

    /**
     * Computes the hash code for this city based on its name and province.
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }

    /**
     * Returns a string representation of the city and province.
     * @return the city and province as a string
     */
    @Override
    public String toString() {
        return city + ", " + province;
    }
}
