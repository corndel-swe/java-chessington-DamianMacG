# Day 2 Workshop

## Refactoring

You may have spotted that there is a class called `AbstractPiece` in
`../src/main/java/com/corndel/chessington/model/pieces/AbstractPiece.java`.

The pieces in the folder should all _inherit_ from the `AbstractPiece` class.

Your task is to do the following:

- [x] Make all pieces inherit from the `AbstractPiece` class

- [x] Move any _duplicated_ code from the child classes into the `AbstractPiece`
  class

- [x] Make sure the tests that _were_ passing before your refactor still pass

> [!TIP]
>
> It's best to do refactors like this a small chunk at a time, and test often to
> make sure we're not breaking tests which worked before. It's hard to keep
> track of too many changes at once!

## Keep going!

With your classes refactored using inheritance, you can continue with
yesterday's task of implementing how each piece moves
