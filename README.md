## Summary

Hey kind folks! This is my work for the technical assignment. I spent quite a bit of time on this, but it was quite a
good exercise to make a proper project structure out of a simple scenario. I did my best to follow the single-purpose
principal, and I think that did a good job of keeping the structure clean. Happy reading!

## Project details

- This app is built using Java 17 and Gradle
- The IDE that I used was IntelliJ IDEA 2022.3.2 (Ultimate Edition)
- The operating system I coded on was macOS Ventura 13.1
- If using IntelliJ, then IDE should auto-import all necessary gradle dependencies.
- With this project as the terminal's current directory, you can run `./gradlew run` to start the app, or press the play
  button next to the main method in `App.java`
- To run the unit tests, runt the `./gradlew test` command.
- The app's command line input will take the absolute file path of the input file, and then the league results will be
  generated.

## Notes / Improvements

- I was a bit torn between on making this project as over-engineered as it is, but I decided to focus on the
  maintainability and "production-ready" aspects of the assignment, and I believe that this is close to what the
  internal structure's complexity would look like.
- The reason for using sets instead of declaring a first team and second team for each match, is to allow expansion on
  scenarios with more than two teams, however the winner calculation would have been more complex and more than is
  required.
- I tried using the Lombok annotation library with this project, but ran into a few issues so decided to write my own
  getters, setters, and constructors.
- There is room for improvement with the validation - but I think that would *really* be over-engineering it.
- I'm unable to unit-test the `assertFileHasLines` method, as my editor by default inserts a line into the file.

## The problem being solved:
We want you to create a production ready, maintainable, testable command-line application that
will calculate the ranking table for a league.
The input and output will be text. Either using stdin/stdout or taking filenames on the command
line is fine. The input contains results of games, one per line. See “Sample input” for details.
The output should be ordered from most to least points, following the format specified in
“Expected output”.

The rules:\
In this league, a draw (tie) is worth 1 point and a win is worth 3 points. A loss is worth 0 points.
If two or more teams have the same number of points, they should have the same rank and be
printed in alphabetical order (as in the tie for 3rd place in the sample data).

Sample input:\
Lions 3, Snakes 3\
Tarantulas 1, FC Awesome 0\
Lions 1, FC Awesome 1\
Tarantulas 3, Snakes 1\
Lions 4, Grouches 0

Expected output:
1. Tarantulas, 6 pts
2. Lions, 5 pts
3. FC Awesome, 1 pt
3. Snakes, 1 pt
5. Grouches, 0 pts
