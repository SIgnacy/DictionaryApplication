Simple application that allows users to add categories and terms with descriptions.

<h3>Command Informations</h3>

<table>
  <tr>
    <th>Command</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>HELP</td>
    <td>Displays information about commands.</td>
  </tr>
  <tr>
    <td>EXIT</td>
    <td>Exiting the program.</td>
  </tr>
  <tr>
    <td>ADD CATEGORY "name"</td>
    <td>Adds a new category.</td>
  </tr>
  <tr>
    <td>DELETE CATEGORY "name"</td>
    <td>Delete given category.</td>
  </tr>
  <tr>
    <td>UPDATE CATEGORY "old name" "new name"</td>
    <td>Updates the category name.</td>
  </tr>
  <tr>
    <td>ADD TERM "term" "description" to "category"</td>
    <td>Adds a new term with given description to existing category.</td>
  </tr>
  <tr>
    <td>DELETE TERM "term" from "category"</td>
    <td>Delete given term from given category.</td>
  </tr>
  <tr>
    <td>UPDATE TERM "oldTerm" to "newTerm" in "category"</td>
    <td>Updates term in given category.</td>
  </tr>
  <tr>
    <td>UPDATE TERM DESCRIPTION "term" "newDescription" in "category"</td>
    <td>Updates description of term in given category.</td>
  </tr>
  <tr>
    <td>UPDATE TERM CATEGORY "term" "oldCategory" "newCategory"</td>
    <td>Updates category of given term.</td>
  </tr>
  <tr>
    <td>LIST ALL</td>
    <td>List all saved terms in dictionary.</td>
  </tr>
  <tr>
    <td>LIST "category name"</td>
    <td>List all saved terms from given category.</td>
  </tr>
  <tr>
    <td>SEARCH "term"</td>
    <td>List all terms with given name.</td>
  </tr>
</table>

For now, after closing the application, added categories and terms are not saved.
