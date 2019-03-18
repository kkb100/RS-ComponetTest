$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/ProductSearchFilter.feature");
formatter.feature({
  "name": "This is a product filter functionality",
  "description": "  As a customer\n  I want to filter my search result\n  So that the relevant product is displayed",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Regression1"
    }
  ]
});
formatter.scenario({
  "name": "Customer searching for phone",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Regression1"
    },
    {
      "name": "@sanity"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the home page",
  "keyword": "Given "
});
formatter.match({
  "location": "CheckOutStepsDef.i_am_on_the_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for product batteries",
  "keyword": "When "
});
formatter.match({
  "location": "ProductSearchFilterStepsDef.iSearchForABatteryProduct()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate product is displayed low to high",
  "keyword": "Then "
});
formatter.match({
  "location": "ProductSearchFilterStepsDef.theProductIsSortedLowToHigh()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Customer searching for phone",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Regression1"
    },
    {
      "name": "@sanity"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the home page",
  "keyword": "Given "
});
formatter.match({
  "location": "CheckOutStepsDef.i_am_on_the_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for product batteries",
  "keyword": "When "
});
formatter.match({
  "location": "ProductSearchFilterStepsDef.iSearchForABatteryProduct()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate product is displayed high to low",
  "keyword": "Then "
});
formatter.match({
  "location": "ProductSearchFilterStepsDef.theProductIsSortedHighToLow()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});