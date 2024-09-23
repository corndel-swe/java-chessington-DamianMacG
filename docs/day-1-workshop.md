# Day 1 Workshop

> [!NOTE]
>
> Be sure to read `CONTRIBUTING.md` before getting started on the workshops.

Take a look at the `getAvailableMoves` method in the `Pawn` class. This method
has been partially implemented, so they can take one step forward.

For the other pieces, `getAvailableMoves` method has not been implemented at
all.

This workshop is all about getting this method working as much as possible for
all classes.

> [!TIP]
>
> There are a _lot_ of movement rules in chess. Don't get overwhelmed - the
> point is to implement what you can in the time allowed and see how far we get.

## First steps

- [x] Run

      ```bash
      ./mvnw clean test -Dtest=PawnTest
      ```

      This will run tests for the pawn

- [x] Take a look at `PawnTest.java` to get a sense of the specification. You
  will notice that some tests are "skipped". To begin with, we will only
  focus on the tests which are not skipped.

- [x] Choose a piece, and work on its `getAvailableMoves` method to make its
  tests pass.

- [ ] Move onto a new piece, and keep going until all non-pending tests are
  passing.

## Moving on

If you take a look at the some of the test files under the
`tests/models/pieces/` directory, you'll see that there are some tests that are
currently being skipped (they have the `@Disabled` annotation).

- [ ] Choose a piece and pick the first `@Disabled` to remove. Un-skip both the
  white version of the test and the black version of the test.

- [ ] Run the tests again, you should see a pair of failing tests.

- [ ] Now that you have some failing tests, once again, try to write some code
  to make them pass.

- [ ] When you make them pass, pick another piece and/or another test to un-skip
  and repeat the process again.

## Check out your work

Make sure to run the web app with

```bash
./mvnw exec:java -Dexec.mainClass=com.corndel.chessington.Main
```

and visit `http://localhost:8080`. You should see the moves you are implementing
taking shape in the web app.
