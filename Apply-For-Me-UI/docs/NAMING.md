### Naming Convections

In this project we make use of the [BEM](https://en.bem.info/methodology/naming-convention/) nameing convections

#### Javascript

##### Naming convection for Varibles

- Make use of camel case for naming variables

```javascript
//Bad
let follwcount = 23;

// Good
let followCount = 23;
```

- Variable name must be descripive

```javascript
// Bad
let b = "john";

//Good
let firstName = "john";
```

- Constant varibles should be written in `Uppercase` for one `word` and `UPPER_SNAKE_CASE`

```javascript
//  Bad
const nose = 1;

// Good
const NOSE = 1; #Upper case

// Bad
const daysInDecember = 31;

// Good
const DAYS_IN_DECEMBER = 31;  #Upper snake case
```

- Boolean variable should have an `is` or `has` as prefixes.

```javascript
// Bad
let open = true;

//Good
let isOpen = true;
```

##### Naming convection for Function

- Function name should be camel cased for more than two word

```javascript
// Bad
function getname() {
  return null;
}

// Good
function getName() {
  return null;
}
```

##### Naming convection for Class

- Make use of `Pascal case`(First letter is always capitalized) in naming classes.

```javascript
//Bad
class dog_movie {
  constructor(dogName) {
    this.dogName = "freddo";
  }
}

//Good
class DogMovie {
  constructor(dogName) {
    this.dogName = "freddo";
  }
}
```

##### Naming convection for Functional React Components

```javascript
// Bad
function dog_movie() {
  return (
    <div>
      <span> Hello world </span>
    </div>
  );
}

// Good
function DogMovie() {
  return (
    <div>
      <span> Hello world </span>
    </div>
  );
}
```

<br>

#### Styling

##### Naming Rules

`block-name__elem-name_mod-name_mod-val`

- Names are written in lowercase Latin letters.

- Words are separated by a hyphen (-).

- The `block name` defines the namespace for its elements and modifiers.

- The `element` name is separated from the block name by a double underscore (\_\_).

- The `modifier` name is separated from the block or element name by a single underscore (\_).

- The `modifier value` is separated from the modifier name by a single underscore (\_).

```html
<!-- `logo` block -->
<div class="logo logo_theme_islands">
  <img src="URL" alt="logo" class="logo__img" />
</div>

<!-- `user` block-->
<div class="user user_theme_islands">
  <img src="URL" alt="user-logo" class="user__img" />
  ...
</div>
```

```css
.logo {
} /* CSS class for the `logo` block */

.logo__img {
} /* CSS class for the `logo__img` element */

.logo_theme_islands {
} /* CSS class for the `logo_theme_islands` modifier */

.user {
} /* CSS class for the `user` block */

.user__img {
} /* CSS class for the `user__img` element */

.user_theme_islands {
} /* CSS class for the `user_theme_islands` modifier */
```

<br>

#### Files & Folders

##### Images

- Make use of `snake case` naming convection

```doc
 IMAGES
=====================
<!-- Bad -->
Flower.jpg
HomeImage.png

<!-- Good -->
flower.jpg
home_image.png
```

##### Folders

- Make use of `kebab` naming convection

```doc
FOLDER
===========

<!-- Bad -->
HomePage
Landing

<!-- Good -->
home-page
landing
```

##### Javascript files

- Make use of `pascal case` naming convection and javascript extension must be `jsx`

```doc

JAVASCRIPT FILE
================

<!-- Bad -->
home_page.jsx
landing.jsx

<!-- Good -->
Landing.jsx
HomePage.jsx
```
