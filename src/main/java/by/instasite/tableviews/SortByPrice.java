package by.instasite.tableviews;

import java.util.Comparator;

public class SortByPrice implements Comparator<MainView> {
    @Override
    public int compare(MainView o1, MainView o2) {
        return o1.getPrice() > o2.getPrice() ? -1 : (o2.getPrice() > o1.getPrice() ? 1 : 0);
    }
}
