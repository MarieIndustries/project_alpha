Feature: Add a funny joke

  As a user
  I want to add a joke to the database

  Scenario: A user adds a joke to the database

    When the user adds "I heard they aren't making shortbread any longer"

    Then the available jokes should be:
      | Id | Joke                                             |
      | 1  | I heard they aren't making shortbread any longer |

  Scenario: A user adds a joke and a punchline to the database

    When the user adds "I once got stuck in an elevator." and "Now I take steps to avoid them"

    Then the available jokes should be:
      | Id | Joke                             | Punchline                      |
      | 1  | I once got stuck in an elevator. | Now I take steps to avoid them |