package org.selenide.examples.google.selenide_page_object;

import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {
  @Test
  public void userCanSearch() {
    open("https://google.com/ncr");
    new GooglePage().searchFor("selenide");

    SearchResultsPage results = new SearchResultsPage();
    results.getResults().shouldHave(sizeGreaterThan(7));
    results.getResult(0).shouldHave(text("Selenide: concise UI tests in Java"));
  }
}
