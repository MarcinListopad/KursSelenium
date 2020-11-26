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
      |dd1989847@urhen.com |jogatu   |Jaki |Wambierzycka  |Wroclaw |50-537 |Poland  |72 968 17 60|