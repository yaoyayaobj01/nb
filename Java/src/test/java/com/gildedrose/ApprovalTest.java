package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

public class ApprovalTest {
//    @Test
//    void testApproval() {
//        Item[] items = new Item[]{new Item("foo", 0, 0)};
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        Approvals.verifyAll("", app.items);
//    }

    @Test
    public void updateQuality() {
        CombinationApprovals.verifyAllCombinations(
            this::callUpdateQuality,
            new String[]{"a common item", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"},
            new Integer[]{0, -1, 20}, //sellIn
            new Integer[]{0, 1, 80, 49, 50}  //quality
        );
    }

    private String callUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        return gildedRose.items[0].toString().replace(" ", "");
    }
}
