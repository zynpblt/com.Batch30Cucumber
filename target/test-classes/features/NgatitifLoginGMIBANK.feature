Feature: Negatif Login
  Scenario: GMIBankNegatif login

Given kullanici gmibank sayfasina gider
Then gmibank signin butonuna tiklar
And gmibank username kutusuna "<yanlisUserName>" yazar
And gmibank password kutusuna "<yanlisPassword>" yazar
And gmibank signin butonuna basar
Then gmibank giris yapilamadigini test eder
And sayfayi kapatir



Examples:
|yanlisUserName|yanlisPassword|
|employee1    |  Manager1! |
|employee2    |  Manager2! |
|employee3    |  Manager3! |
|employee4    |  Manager4! |
|employee5    |  Manager5! |