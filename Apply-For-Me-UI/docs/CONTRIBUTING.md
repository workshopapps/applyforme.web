### Contribution Guidelines

- Do not push directly to main branch
- Create your working branch and give it a descriptive name like: feature/{feature-name}
- Make micro commits, so the code reviewer can see step by step your changes to the codebase.
- Make sure your PR sumarry is descriptive, in other to make the code reviewer understand what changes you have made.
- Only make changes to section of the codebase assigned to you.
- Please follow the commit message standards below:
  - feat: a new feature
  - fix: a bug fix
  - docs: changes to documentation
  - style: formatting, missing semi-colons,
  - refactor: refactoring production code
  - test: adding tests, refactoring test
  - chore: updating build tasks, package manager configs, etc; no production code change

**NOTE**: Also take a look at our [Naming convections](./NAMINGCONVECTION.md) in other to follow our codebase standards.

### GitHub Actions Enforcement

This Action enforcement uses lint: which is process of automatically check your source code for programatic and stylistic errors. Further implementation was done using GitHub Action so as to automatically check your PR (Pull Request) for styling and programatical errors, which will enable us to have maintain coding standards and clean codebase by catching such error as quick as possible.

This GitHub Action is going to run [ESLint](https://eslint.org/) javascript issues.

[ESLint](https://eslint.org/) is a tool for identifying and reporting on patterns found in ECMAScript/JavaScript code, with the goal of making code more consistent and avoiding bugs.

**Notes**

- When you open your first pull request you might see the result of the GitHub Actions with errors:

<img width="551" alt="gitaction" src="https://user-images.githubusercontent.com/58771507/202259787-785c13e5-b11a-4a62-ad9e-4668b7b1b40e.png">

- Do not panic, you can Click on the Details link to see the full output and the errors that need to be fixed:

 <img width="551" alt="gitaction" src="https://user-images.githubusercontent.com/58771507/202260184-0dff49e5-3b5f-44bb-81e8-0439367b0c08.png">

- Go your terminal and run the Linter auto-fix command to fix this errors, and you can push the fixed code back to github.

#### Set-up linters in your local env

##### ESLint

- Run

```cmd
npm install --save-dev eslint@7.x eslint-config-airbnb@18.x eslint-plugin-import@2.x eslint-plugin-jsx-a11y@6.x eslint-plugin-react@7.x eslint-plugin-react-hooks@4.x @babel/eslint-parser@7.x @babel/core@7.x  @babel/plugin-syntax-jsx@7.x  @babel/preset-react@7.x @babel/preset-react@7.x
```

#### Linter auto-fix command

This command is to be run, on the root of your directory of your project in your terminal. to fix linter errors.

##### ESLint

- Run

```
npm run auto-fix-js
```

<br />

### Expected endpoints and behaviors

`GET '/{endpoint-name}'`

- Fetches a dictionary of {endpoint-name} in which the keys are the ids and the value is the corresponding string of the {endpoint name}
- Request Arguments: None
- Returns: An object with...

```json
{
  "example": {
    "exampleName": "Science"
  }
}
```
