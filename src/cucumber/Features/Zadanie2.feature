Feature: Buy product

  Scenario Outline: user can buy Hummingbird Printed Sweater

    Given open website https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=addresses

    When log in to user account <Email> i <Password>

    Then  in search box put Hummingbird Printed Sweater and click search

    And click on Hummingbird Printed Sweater picture

    And chose <size>

    And write <quantity>

    And add to cart

    And proceed to checkout

    And confirm proceed to checkout

    And confirm address

    And choose shipping method PrestaShop pick up in store,

    And pay by check

    And order with an obligation to pay

#    And take a screenshot with confirmation of order

    And close browser

    Examples:
      |Email               |Password |size  |quantity |
      |dd1989847@urhen.com |jogatu   |M     |5        |