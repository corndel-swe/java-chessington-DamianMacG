# Day 1 Exercises

Let's start off making a simple counter. A counter is quite a good use case for
classes since it requires state (the current count) a way to read that state
(getting the current count), and methods to change that state (increment and
reset).

## Exercise 1: Classes and Instances

First, refresh your memory of classes with the notes on
[Classes and Instances](https://tech-docs.corndel.com/java/classes-and-instances.html).

To run the tests for this exercise, run `./mvnw clean test -Dtest=D1E1Tests` in
your terminal.

Your instructions are to:

- [x] Open up
  [Counter.java](../src/main/java/com/corndel/exercises/Counter.java) and
  create a new class called `Counter`

- [x] Declare an `int` property called `count`

- [x] Give it a constructor that initialises `count` to `0`

> [!NOTE]
>
> Make sure your class name has a capital `C`

## Exercise 2: Instance methods

Now, have a look through
[Instance methods](https://tech-docs.corndel.com/java/instance-methods).

You can run the tests for this exercise using
`./mvnw clean test -Dtest=D1E2Tests`.

We'll want to be able to increment the counter, reset our counter, and get the
current count.

Have a go implementing the following public methods:

- [x] `increment()`, which adds one to `count`

- [x] `reset()`, which sets `count` to `0`

- [x] `getCount()`, which returns the current `count`

## Exercise 3: Private properties

Finally, read about
[Private properties](https://tech-docs.corndel.com/java/private-properties).

You can run the tests for this exercise using
`./mvnw clean test -Dtest=D1E3Tests`.

- [x] Refactor the `count` property to be private, so that it's hidden from
  outside the class.

## Extensions

Modify the constructor so that it can accept an _optional_ argument as the
initial count.
