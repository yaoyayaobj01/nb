package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItemQuality(items[i]);
        }
    }

    private void updateItemQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            updateAgedBrieQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            updateBackstagePassesQuality(item);
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            updateSulfurasQuality(item);
        } else if (item.name.equals("Conjured Mana Cake")) {
            updateConjuredManaCakeQuality(item);
        } else {
            updateOthers(item);
        }
    }

    private static void updateOthers(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void updateSulfurasQuality(Item item) {
    }

    private static void updateBackstagePassesQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
            if (item.sellIn < 11 && item.quality < 50) {
                item.quality = item.quality + 1;
            }
            if (item.sellIn < 6 && item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private static void updateAgedBrieQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }


    private void updateConjuredManaCakeQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 2;
        }

        if (item.sellIn < 1 && item.quality > 0) {
            item.quality = item.quality - 2;
        }
        item.quality = Math.max(0, item.quality);
        item.sellIn = item.sellIn - 1;
    }
}
