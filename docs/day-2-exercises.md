# Day 2 Exercises

In these exercises, we'll be implementing some maths and geometry functionality
using classes.

## Exercise 1: Static methods and properties

Let's make our own set of utility methods and properties, called `Maths`. A
skeleton file and class is provided in
[Maths.java](../src/main/java/com/corndel/exercises/Maths.java)

Read the docs about
[static members](https://tech-docs.corndel.com/java/static-members.html).

To run the tests for this exercise, run `./mvnw clean test -Dtest=D2E1Tests` in
your terminal.

- [x] Add a static property `PI` to `Maths`. The value of `Maths.PI` should be
  the `double` `3.14`.

- [x] Add the static method `Maths.max(double a, double b)`, which returns the
  largest of `a` and `b`.

## Exercise 2: Inheritance

To continue on with our theme with maths, we've written a `Rectangle` and a
`Square` class.

If you have a quick look through the files, you'll spot that the `Rectangle` and
`Square` classes look (and are conceptually) _very_ similar - a sign that we can
do some refactoring.

Let's start off by reading the documentation on
[Inheritance](https://tech-docs.corndel.com/java/inheritance.html)

Since a `Square` is a special type of `Rectangle`, let's make `Square` _inherit
from_ `Rectangle`.

- [ ] Use the `extends` keyword in the class definition to make `Square` a
  subclass of `Rectangle`

- [ ] We also need to call `super` in the constructor of `Square` to call the
  constructor of `Rectangle` and set the `width` and `height` properties.

- [ ] Are there any functions we can remove from `Square` that are already
  defined in `Rectangle`?

- [ ] Do we need `#side` anymore if we're using `#width` and `#height`?

## Exercise 3: Interfaces

Every shape has a similar set of properties - e.g. area and perimeter - but the
way you work them out can be different.

Finding the area for a square and a rectangle may be similar enough, but what
about a triangle? Or a circle?

In this exercise, we will write the `getArea` and `getPerimeter` methods in
several shape classes to return the correct values for that shape.

- [ ] Read the documentation on
  [Interfaces](https://tech-docs.corndel.com/java/interfaces.html)

- [ ] Take a look at the
  [Shape](../src/main/java/com/corndel/exercises/Shape.java) interface

- [ ] Make sure
  [RightTriangle](../src/main/java/com/corndel/exercises/RightTriangle.java)
  implements the `Shape` interface

  > [!NOTE]
  >
  > Make sure to use the `implements` keyword and `@Override` decorator

- [ ] Make [Circle](../src/main/java/com/corndel/exercises/Circle.java)
  implement `Shape`

- [ ] And [Rectangle](../src/main/java/com/corndel/exercises/Rectangle.java)
  (note that, although we have already written `getArea` and `getPerimeter`
  methods, we should still `implements Shape` for consistency).
