package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

class GildedRoseTest {

    void testItem(String name, int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        GildedRose app = new GildedRose(new Item[] { new Item(name, sellIn, quality) });

        app.updateQuality();

        assertEquals(expectedSellIn, app.items[0].sellIn);
        assertEquals(expectedQuality, app.items[0].quality);
    }

    static Stream<Arguments> normalItems() {
        String name = "Normal Item";
        return Stream.of(
                arguments(name, 5, 10, 4, 9),
                arguments(name, 4, 9, 3, 8),
                arguments(name, 3, 8, 2, 7),
                arguments(name, 2, 7, 1, 6),
                arguments(name, 1, 6, 0, 5),
                arguments(name, 0, 5, -1, 3),
                arguments(name, -1, 3, -2, 1),
                arguments(name, -2, 1, -3, 0),
                arguments(name, -3, 0, -4, 0));
    }

    static Stream<Arguments> agedBrie() {
        String name = "Aged Brie";
        return Stream.of(
                arguments(name, 5, 0, 4, 1),
                arguments(name, 4, 1, 3, 2),
                arguments(name, 3, 2, 2, 3),
                arguments(name, 2, 43, 1, 44),
                arguments(name, 1, 44, 0, 45),
                arguments(name, 0, 45, -1, 47),
                arguments(name, -1, 47, -2, 49),
                arguments(name, -2, 49, -3, 50),
                arguments(name, -3, 50, -4, 50));
    }

    static Stream<Arguments> backstagePasses() {
        String name = "Backstage passes to a TAFKAL80ETC concert";
        return Stream.of(
                arguments(name, 12, 0, 11, 1),
                arguments(name, 11, 1, 10, 2),
                arguments(name, 10, 2, 9, 4),
                arguments(name, 7, 4, 6, 6),
                arguments(name, 5, 6, 4, 9),
                arguments(name, 4, 9, 3, 12),
                arguments(name, 3, 12, 2, 15),
                arguments(name, 1, 15, 0, 18),
                arguments(name, -1, 0, -2, 0));
    }

    static Stream<Arguments> sulfuras() {
        String name = "Sulfuras, Hand of Ragnaros";
        return Stream.of(
                arguments(name, 3, 10, 3, 10),
                arguments(name, 2, -5, 2, -5),
                arguments(name, 0, 100, 0, 100),
                arguments(name, -1, 13, -1, 13));
    }

    static Stream<Arguments> conjuredItems() {
        String name = "Conjured Mana Cake";
        return Stream.of(
                arguments(name, 3, 10, 2, 8),
                arguments(name, 2, 8, 1, 6),
                arguments(name, 1, 6, 0, 4),
                arguments(name, 0, 8, -1, 4),
                arguments(name, -1, 4, -2, 0),
                arguments(name, -2, 0, -3, 0));
    }

    @ParameterizedTest
    @MethodSource("normalItems")
    void timePassesForNormalItems(String name, int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        testItem(name, sellIn, quality, expectedSellIn, expectedQuality);
    }

    @ParameterizedTest
    @MethodSource("agedBrie")
    void timePassesForAgedBrie(String name, int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        testItem(name, sellIn, quality, expectedSellIn, expectedQuality);
    }

    @ParameterizedTest
    @MethodSource("backstagePasses")
    void timePassesForBackstagePasses(String name, int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        testItem(name, sellIn, quality, expectedSellIn, expectedQuality);
    }

    @ParameterizedTest
    @MethodSource("sulfuras")
    void timePassesForSulfuras(String name, int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        testItem(name, sellIn, quality, expectedSellIn, expectedQuality);
    }

    @ParameterizedTest
    @MethodSource("conjuredItems")
    void timePassesForConjuredItems(String name, int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        // testItem(name, sellIn, quality, expectedSellIn, expectedQuality);
    }

}
