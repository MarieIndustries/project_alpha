Feature: Update a joke

  As a user
  If there is a joke in the database already
  I want to be able to update it

  Scenario: A user updates a joke in the database with no punchline

    Given the available jokes:
      | Id | Joke                                          | Punchline |
      | 1  | A complement is the highest form of flattery. |           |

    When the user updates the joke by id:
      | Id |  Joke                                       | Punchline |
      | 1  |  A plateau is the highest form of flattery. |           |

    Then the available jokes should be:
      | Id | Joke                                        | Punchline |
      | 1  |  A plateau is the highest form of flattery. |           |

  Scenario: A user updates a joke in the database with a punchline

    Given the available jokes:
      | Id | Joke                                   | Punchline   |
      | 1  | I'm reading a book about anti-gravity. | It's great. |

    When the user updates the joke by id:
      | Id | Joke                                   | Punchline            |
      | 1  | I'm reading a book about anti-gravity. | I can't put it down. |

    Then the available jokes should be:
      | Id | Joke                                   | Punchline            |
      | 1  | I'm reading a book about anti-gravity. | I can't put it down. |