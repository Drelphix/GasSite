package by.instasite.tableviews;

import java.util.Comparator;

public class MainView implements Comparator<MainView> {
    private String franchise;
    private String stationName;
    private String stationAddress;
    private String fuelName;
    private double price;

    public MainView() {

    }

    public MainView(String franchise, String stationName, String stationAddress, String fuelName, double price) {
        this.franchise = franchise;
        this.stationName = stationName;
        this.stationAddress = stationAddress;
        this.fuelName = fuelName;
        this.price = price;
    }

    public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }

    public String getFuelName() {
        return fuelName;
    }

    public void setFuelName(String fuelName) {
        this.fuelName = fuelName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.getFranchise() + " " + this.getStationName() + " " + this.getStationAddress() + " " + this.getFuelName() + this.getPrice();
    }

    @Override
    public int compare(MainView o1, MainView o2) {
        if (o1.getPrice() > o2.getPrice())
            return 0;
        else return 1;
    }

    @Override
    public Comparator<MainView> reversed() {
        return null;
    }
}
