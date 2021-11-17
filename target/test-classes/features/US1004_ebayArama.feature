
Feature: US1004 ebay sayfasinada kelime arama

  Scenario: TC08 kullanici ebay'de istedigi kelimeyi aratip test eder
    #Bu test CALISMAZ
    Given kullanici "ebayUrl" sayfasina gider
    Then "nutella" icin arama yapar
    And sonucun "nutella" icerdigini test eder
    Then sayfayi kapatir

    #burada tum stepdefiniton'lar tanimli gibi gorunsede testimiz calismaz
  #cunku arama yapar ve sonucu test eder stepdefinition'lari amazon sayfasina gore locate edilmisti
  #burada yeniden locate etmemiz gerekirken ayni cumleyi yazdigimiz icin biz den yeni
  #stepdefinition istemedi
  #bu yuzden gherkin ile yazdigimiz cumlelerin tam tanimlayici olmasi onemlidir