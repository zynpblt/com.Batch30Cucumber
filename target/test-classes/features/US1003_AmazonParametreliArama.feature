@Paralel2
Feature: US1003 kullanici istedigi kelime icin arama yapip,sonucu test eder

  Scenario: TC07 istenen kelimenin oldugunu test etme
    Given kullanici "amazonUrl" sayfasina gider
    And "ipod" icin arama yapar
    Then sonucun "ipod" icerdigini test eder
    And  sayfayi kapatir

    #parametre olarak yazdiimiz kelimeyi stepdefiniation da String olarak kullanacaksa
  #ne yazdigimiz onemli degil.

  #Ancak eger parametre olarak yazdigimiz kelimeyi configuration properties'den alacaksak
  #burada yazdigimiz parametrenin congiguration.properties'deki yazim ile ayni olmasi gerekir
  #eger yazim farkli olursa nullPointerException verir

  #buradaki parametre ile congiguration.properties deki key ayni olduktan sonra
  #stepdefinition'da parametre adi olarak ne yazdigimizin bir onemi olmaz