# Problem 1: Adjusting Flight Paths

## Problem Overview

You have a number of flight paths, each defined by a series of coordinates. The challenge is to adjust these paths so that no two paths overlap or intersect at the same coordinates.

## Approach Breakdown

**Input Reading:**
1. Determine how many flight paths you need to process.
2. For each flight path, read the coordinates provided in a specified format.

**Initial Path Storage:**
1. Store each flight’s path in a list. Each path is represented as a 2D array where each element is a coordinate pair.

**Adjusting Paths to Avoid Intersections:**
1. Use a set to keep track of coordinates that have already been used. This helps ensure that no two paths share the same coordinates.
2. If a coordinate from a path is already in use, adjust (e.g., increment) the coordinate until you find a unique one.

**Output the Results:**
1. After adjusting the paths, print out the new coordinates for each flight path.

**NOTE:** The code is working but the output does not match for a particular test case.

---

# Problem 2: Distributing Apples Based on Payment

## Problem Overview

Three friends—Ram, Sham, and Rahim—went shopping for apples and spent a total of 100 rupees. Ram paid 50 rupees, Sham paid 30 rupees, and Rahim paid 20 rupees. Each apple has a weight on it, and we need to distribute the apples among them based on how much each person paid. The challenge is to make sure that the apples are distributed so that each person gets a share proportional to the amount they spent. We cannot cut the apples; each one must be given whole.

## Approach Breakdown

**Input Reading:**
1. Find out how many apples there are and what their weights are.
2. Ask the user to enter the weight of each apple until they enter a special value (-1) to stop.

**Initial Path Storage:**
1. Store the weights of all the apples in a list.

**Calculating Shares:**
1. Calculate the total weight of all apples.
2. Determine how much each person should get based on the percentage of the total amount they paid (Ram: 50%, Sham: 30%, Rahim: 20%).

**Distributing Apples:**
1. Sort the apples by weight from heaviest to lightest.
2. Try to give apples to each person so that their total weight of apples matches their share as closely as possible. Start by giving the largest apples first to ensure the distribution is as fair as possible.

**Output the Results:**
1. After distributing the apples, print out which apples each person received.

This approach helps ensure that everyone gets a fair share of apples based on what they paid, while also respecting the constraint that apples can't be divided.

---

# Problem 3: Find All Paths for the Special Castle

## Problem Overview

You have a chessboard where you place several soldiers on random cells and a special castle in another random cell. The castle has a unique set of rules for moving around:
1. It can only move forward in the direction it's facing.
2. When it "kills" a soldier, it turns left and continues moving.
3. After killing a soldier, the soldier's cell becomes empty.
4. The castle can jump over other soldiers without stopping.

The task is to find all the possible paths that the castle can take to return to its starting point, following these rules.

## Approach Breakdown

**Input Reading:**
1. Enter the number of soldiers and their positions on the chessboard.
2. Enter the position of the special castle.

**Initial Setup:**
1. Store the positions of all soldiers and the castle in a data structure that allows easy access and modification.

**Finding Paths:**
1. From the starting position, the castle tries to move in the current direction (starting with moving South).
2. If it encounters a soldier in its path, it "kills" the soldier (removes it from the board), turns left, and continues.
3. The castle can also jump over soldiers, allowing it to bypass them.
4. The goal is to explore all possible ways the castle can move to return to the starting position.

**Output the Results:**
1. After calculating all possible paths, print each path showing the sequence of movements and kills the castle made.
