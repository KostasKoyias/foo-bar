# foo-bar

These are my solutions to the [foo-bar challenge](#more-information) invitation
I got from
<span style="color: #0091ea; font-weight:bold; font-size: x-large">G</span>
<span style="color: #f44336; font-weight:bold; font-size: x-large">o</span>
<span style="color: #ffc107; font-weight:bold; font-size: x-large">o</span>
<span style="color: #0091ea; font-weight:bold; font-size: x-large">g</span>
<span style="color: #4caf50; font-weight:bold; font-size: x-large">l</span>
<span style="color: #f44336; font-weight:bold; font-size: x-large">e</span>.

## Repo structure

For all problems solved, standard **Java 8** was used.  
Each level consists of 1 to 3 challenges, each of whom
has it's own package under src with the corresponding level as root.

After cloning/forking, please build the project with Gradle as follows
and type

```bash
./gradlew build
```

Then, to test a particular problem, for example `l2.c2`, please type

<!-- TODO -->
```bash
./gradlew test --tests foo.bar.l2.c2.solution.SolutionTest
``` 

In each challenge, Google provides 2-3 out of the 5-10 total
test cases as examples. The rest of them are hidden.  
For each challenge, source files named **Verify.java**
run the solution provided under the corresponding
**Solution.java** file against those test cases.
Utilities under [Matrix.java](./src/main/java/foo/bar/utils/Matrix.java) are often used
for common matrix operations throughout the project.

## Challenge structure

Based on what I have read until know, this is how the whole challenge
is structured.

| Level | Challenge | Time limit **for each challenge** | Reward after completion             |
|-------|-----------|-----------------------------------|-------------------------------------|
| 1     | 1         | 2 days                            | -                                   |
| 2     | 2         | 3 days                            | Friend referral link<sup>1</sup>    |
| 3     | 3         | 4 days                            | Google Interview<sup>2</sup>        |
| 4     | 2         | 15 days                           | Another friend referral link        |
| 5     | 1         | 22 days                           | -                                   |

>> 1. A referral link allows the person you send it to, to enter foobar.
>> 2. You are asked to fill out your personal info, if you wish, then
 a Google recruiter will contact you soon.

## Challenges

* Level 1

  1. [Braille Translation](./src/main/java/foo/bar/l1/readme.txt)

* Level 2
  1. [Ion Flux Relabeling](./src/main/java/foo/bar/l2/c1/readme.txt)
  2. [Gearing Up for Destruction](./src/main/java/foo/bar/l2/c2/readme.txt)

* Level 3

  1. [Prepare the Bunnies' Escape](./src/main/java/foo/bar/l3/c1/readme.txt)
  2. [The Grandest Staircase Of Them All](./src/main/java/foo/bar/l3/c2/readme.txt)
  3. [Find the Access Codes](./src/main/java/foo/bar/l3/c3/readme.txt)

* Level 4

  1. [Escape Pods](./src/main/java/foo/bar/l4/c1/readme.txt)
  2. [Running with Bunnies](./src/main/java/foo/bar/l4/c2/readme.txt)

* Level 5

  1. [Expanding Nebula](./src/main/java/foo/bar/l5/readme.txt)(not solved)

>> Note that the *readme* files were slightly simplified
while solving the corresponding challenge.

## Contribute

You are welcome to fork this repository and submit your own solutions.
Make a pull request and your version will be reviewed within a few days.

## More information

To learn more about Google's foobar challenge,
check out some of the links below:

1. [medium](https://medium.com/chingu/my-experience-with-the-google-foobar-challenge-and-tips-on-what-to-do-if-you-get-it-9848d31d3d20)
2. [freeCodeCamp](https://www.freecodecamp.org/news/the-foobar-challenge-googles-hidden-test-for-developers-ed8027c1184/)
3. [YouTube](https://www.youtube.com/watch?v=FHQAj9iYPg0)
