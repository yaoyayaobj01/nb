# Gilded Rose starting position in Java

## Run the Text Fixture from Command-Line

```
./gradlew -q text
```

### Specify Number of Days

For e.g. 10 days:

```
./gradlew -q text --args 10
```

1、编写测试类，将生成的对比文件进行修改，让二者保持一致

2、生成了一个文件，自己再创建一个，让两个文件里的内容一致，然后再运行测试即可通过
ApprovalTest.updateQuality.approved.txt
ApprovalTest.updateQuality.received.txt

3、在代码中看单测覆盖率，要把所有的代码行都覆盖掉

4、开始使用Ctrl+T抽变量和代码, 循环可以直接抽

5、复杂的if else所有判断逻辑全部抽成一个大方法foo()，然后自己把自己想要提取的判断维度的if else写出来，然后把foo()重复的扔到里面

6、ctrl+t inline方法，把foo替换成全部代码

7、if中的方法把判断条件一点点换成true/false，然后使用idea提示简化后，就能抽取出来一个只有"Aged Brie"的方法，抽取出来

8、把else中的内容根据提示简化后，把else中的所有内容重复5、6、7步骤
private void updateItemQuality(Item item) {
    if (item.name.equals("Aged Brie")) {
        updateAgedBrieQuality(item);
    } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
        foo2();
    } else{
        foo2();
    }
}
9、重复上述过程，最终获得
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
10、（如果有自己新加的分支内容，要用单元测试慢慢测，因为是新修改的代码，就不要再往Approval中添加了）
