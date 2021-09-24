@search
Feature: Arama Senaryoları
  Misafir kullanıcısı olarak
  Otel aramak istiyorum

  @CaseId:TC-155
  @quick-cases
  Scenario: 1- Misafir olarak kelime ile arama
    Given Uygulamaya misafir kullanıcı ile giriş yapılır
    When Arama ekranından "antalya" aratılır
    And Bulunan ilk arama sonucu seçilir
    And Otele tıklanır
    Then Otellerin listelendiği görülmelidir

  @CaseId:TC-156
  @full-cases
  Scenario Outline: 2- Misafir olarak şehire göre arama
    Given Uygulamaya misafir kullanıcı ile giriş yapılır
    When Arama ekranından "<city>" aratılır
    And Bulunan ilk arama sonucu seçilir
    And Otele tıklanır
    Then Otellerin listelendiği görülmelidir
    Examples:
      |city|
      |antalya|
      |bodrum|
      |izmir|
      |marmaris|

