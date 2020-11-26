Feature: Add new address

  Scenario Outline: user can add new address

    Given open website https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=addresses
    When log in to user account <Email> i <Password>
    Then click user button
    Then click Create new address
    And entered alias <alias>
    And entered address <address>
    And entered city <city>
    And entered zip <zip>
    And entered country <country>
    And entered phone <phone>
    And submit new address
    And close browser
    Examples:
      |Email               |Password |alias |address      |city    |zip    |country |phone       |
      |nimiga8304@ofdow.com |123456789  |dom1 |Majdzika 12 |Krakow|32-051 |United Kindom  |13 123 45 67|
