The Grandest Staircase Of Them All
==================================
 
Commander Lambda wants to know how many different types of staircases can be built with each amount of bricks.

1. Each staircase should consist of 2 or more steps.  
2. All steps must contain at least one brick. 
3. No two steps are allowed to be at the same height - each step must be lower than the previous one. 
   A step's height is classified as the total amount of bricks that make up that step.

Examples
========

For example, when N = 3, you have only 1 choice of how to build the staircase, 
with the first step having a height of 2 and the second step having a height of 1: (# indicates a brick)

#
##
21

When N = 4, you still only have 1 staircase choice:

#
###
31
 
But when N = 5, there are two ways you can build a staircase from the given bricks. 
The two staircases can have heights (4, 1) or (3, 2), as shown below:

#
####
41

##
###
32

____________
N = 6 --> 3
============

(5, 1)
#
#####

(4, 2)
##
####

(3, 2, 1)
#
##
###
____________
N = 7 --> 4
============

(6, 1)
#
######

(5, 2)
##
#####

(4, 2, 1)
#
##
####

(4, 3)
###
####

____________
N = 8 -->
============

(7, 1)
#
#######

(6, 2)
##
######

(5, 3)
###
#####

(5, 2, 1)
#
##
#####

(4, 3, 1)
#
###
####

Write a function called solution(n) that takes a positive integer n and returns the number 
of different staircases  that can be built from exactly n bricks. 3 <= n <= 200.

Test cases
==========

* Solution.solution(3) = 1

* Solution.solution(200) = 487067745

