Feature: Delete a joke already in the database

  As a user
  I want to delete a joke from the database

  Scenario: A user deletes a joke from the database

    Given the available jokes:
      | Id | Joke                             | Punchline                      |
      | 1  | I once got stuck in an elevator. | Now I take steps to avoid them |
      | 2  | Geology rocks.                   |                                |

    When the user deletes the joke by id: 2

    Then the available jokes should be:
      | Id | Joke                             | Punchline                      |
      | 1  | I once got stuck in an elevator. | Now I take steps to avoid them |