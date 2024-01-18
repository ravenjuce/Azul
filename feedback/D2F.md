# Assignment Two Feedback


## Group  tue12q
u7323052 Wangyi Li
u7323912 Xuanchen Wang
u7233947 Zixin Feng

## Tutor Comment

Congratulations on a high-quality submission. The animation of tiles from factories to storage is nice. The random fixed mosaic variation is good, although it seems to break the GUI for player 1 (the mosaic is not displayed). The use of object-oriented programming in the GUI code is appropriate; overall the GUI code is reasonably well-commented and easy to read. You have a very nice set of unit tests against the `Actions` class.

The implementation of Azul doesn't use the object-oriented design from your skeleton, which makes it unnecessarily complicated. It is very impressive that you got the implementation to work entirely with pattern matching, but the code is almost unreadable. As a small example: `Azul.java:786-795`:
````
                for (int i = 0; i <discard_tile.length() - 1; i+=2){
                    if (((discard_tile .charAt(i) - '0') == 2 && (discard_tile .charAt(i + 1) - '0' > 0)) || ((discard_tile .charAt(i) - '0') > 2)){
                        System.out.println(4);
                        return false;
                    }
                }
````
The above code is checking that there are no more than 20 tiles of any kind in the discard pile. However, the number 20 doesn't appear anywhere in the code, nor is it clear that we're dealing multiple tile types. If this was implemented using a proper object-oriented design, this validity check could be written something like:
````
    for (int numTilesOfType : discard.getNumTilesOfEachType()) {
      if (numTilesOfType > 20) return false;
    }
````

In addition, some rules aren't implemented correctly in the GUI, probably because they don't use the implementations of the tasks. For example, the GUI incorrectly allowed me to place tiles in two different rows in a single drafting move.

Minor comments:

I had difficulty using the GUI - when I clicked in the centre it generated an exception, and after that if I tried to drag any tiles from factory to storage they always went straight to an unexpected area above the storage - initially I thought it was the floor, but then I saw that the floor is below the storage so I don't know what it is. I also would have expected to be able to drag a tile to anywhere in an empty row, rather than the first empty slot. The game didn't start immediately but said "Please click on the colour you want to choose", when really the first thing the player needs to do is click "Start".

The code in `Azul.java` makes inappropriate use of `switch` statements where a simple array index would do. For example, lines 394, 969, 992, 1017, 1462.

Magic numbers should be defined as named constants. For example the number`#1d953f` appears repeatedly throughout the GUI code as one of the tile colours. If you wanted to change the colour of a tile, you'd need to search through the code and replace it in multiple locations. If it were defined as a constant, you'd only need to make the change in one location.

Some of the Git commit messages are not very meaningful. For example, Zixin made 11 commits with the message "Task 9". What were you doing in each of these commits? Surely only one of these actually completed the task - what were the other changes? By making more meaningful commit messages, it becomes possible to go through the history to find a particular commit.

## Mark

**  10.4/13.0**

## Miscellaneous marks

| Level | Requirement | Result |
|:--:|---|:--:|
|    | All files correct                   |   .5/ .5  |
|    | Authorship clear for all classes    |  .25/ .25 |
|    | Program runs from JAR               |  .5 / .5  |
|    | Appropriate use of Git              |  .5 / .5  |
| P  | Appropriate use of OO features      |  .75/1.0  |
| CR | Program well designed               |  .5 / .5  |
| CR | Comments clear and sufficient       |  .25/ .25 |
| CR | Coding style good                   |  .25/ .25 |
| CR | Appropriate use of JUnit tests      |  .25/ .25 |
| D  | Design and code of very high quality|  .25/ .5  |
| D  | Works well and easy to run          |  .25/ .5  |
| HD | Demonstrates interesting extensions |  .25/ .5  |
| HD | Game is exceptional                 | 0   /1.0  |

**Total for miscellaneous marks:**  4.5/6.5

## Game marks (manual)

| Level | Requirement | Result |
|:-:|---|:-:|
|CR|Pieces snap into place (12)      | .25/.25 |
|CR|Only valid placement allowed (12)|    /.25 |
|D |Basic computer opponent (14)     | .5 /.5  |
|HD|Advanced computer opponent (15)  |    /.5  |
|HD|Interesting variant (16)         | .15/.25 |

**Total for manual marks:** 1.13/1.75

## Test results

```
Test Name   Tests Passed  Weighting      Score
-----              -----      -----      -----
task2                3/3      0.125      0.125
task3                2/2      0.125      0.125
task5                3/3       0.25       0.25
task6                5/5        0.5        0.5
task7                1/1       0.25       0.25
task8                5/5        0.5        0.5
task9                8/8       0.75       0.75
task10             11/11        1.0        1.0
task11               4/4        0.5        0.5
task13               2/2       0.75       0.75
-----              -----     Total:  4.75/4.75
```
## Originality statements

#### Originality statement F
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
Stage F represents the culmination of the entire assignment.  We declare that
everything we have submitted for for all stages of this assignment was
entirely our own work, with the following exceptions:



# Sign *your* name and uids here. (Remove entries if you have fewer
# than three members.)
signatures:
- name: Zixin Feng
  uid: u7233947
- name: Wangyi Li
  uid: u7323052
- name: Xuanchen Wang
  uid: u7323912

#### Originality statement E
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
We declare that everything we have submitted for Stage E of this assignment
and all stages before it is entirely our own work, with the following
exceptions:

# Sign *your* name and uids here. (Remove entries if you have fewer
# than three members.)
signatures:
- name: Zixin Feng
  uid: u7233947
- name: Wangyi Li
  uid: u7323052
- name: Xuanchen Wang
  uid: u7323912

#### Originality statements D
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
I declare that everything I have submitted for stage D of this assignment
and all stages before it is entirely my own work, with the following
exceptions:

# Use this to list names of people who you collaborated with, and a
# comment about what you collaborated on.
#
# Add as many "name+comment" entries as necessary
# (or remove it altogether if you haven't collaborated with anyone)
collaboration:
- name: Xuanchen Wang
  comment: >-
  implementation of FillFactory and its test

# Use this to list any code that you used that you did not write,
# aside from code provided by the lecturer.  Provide a comment
# explaining your use and the URL to that code and the licence for
# that code
#



# sign *your* name and uid here
name: zixin Feng
uid: u7233947
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
I declare that everything I have submitted for stage D of this assignment
and all stages before it is entirely my own work, with the following
exceptions:

# Use this to list names of people who you collaborated with, and a
# comment about what you collaborated on.
#
# Add as many "name+comment" entries as necessary
# (or remove it altogether if you haven't collaborated with anyone)
collaboration:
- name: Xuanchen Wang
  comment: >-
  implementation of dragging tiles and its test

# Use this to list any code that you used that you did not write,
# aside from code provided by the lecturer.  Provide a comment
# explaining your use and the URL to that code and the licence for
# that code
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external code)


# Use this to list any assets (artwork, sound, etc) that you used.
# Provide a comment explaining your use of that asset and the URL
# and license for the asset
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external assets)



# sign *your* name and uid here
name: Wangyi Li
uid: u7323052
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
I declare that everything I have submitted for stage D of this assignment
and all stages before it is entirely my own work, with the following
exceptions:

# Use this to list names of people who you collaborated with, and a
# comment about what you collaborated on.
#
# Add as many "name+comment" entries as necessary
# (or remove it altogether if you haven't collaborated with anyone)


# Use this to list any code that you used that you did not write,
# aside from code provided by the lecturer.  Provide a comment
# explaining your use and the URL to that code and the licence for
# that code
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external code)


# Use this to list any assets (artwork, sound, etc) that you used.
# Provide a comment explaining your use of that asset and the URL
# and license for the asset
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external assets)



# sign *your* name and uid here
name: Xuanchen Wang
uid: u7323912

#### Originality statement C
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
We declare that everything we have submitted for Stage C of this assignment
and all stages before it is entirely our own work, with the following
exceptions:

# Use this to list names of people who you collaborated with, and a
# comment about what you collaborated on.
#
# Add as many "name+comment" entries as necessary
# (or remove it altogether if you haven't collaborated with anyone)



# Sign *your* name and uids here. (Remove entries if you have fewer
# than three members.)
signatures:
- name: Wangyi Li
  uid: u7323052
- name: Xuanchen Wang
  uid: u7323912
- name: Zixin Feng
  uid: u7233947

#### Originality statement B
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
We declare that everything we have submitted for Stage B of this assignment
and all stages before it is entirely our own work, with the following
exceptions:

# Use this to list names of people who you collaborated with, and a
# comment about what you collaborated on.
#
# Add as many "name+comment" entries as necessary
# (or remove it altogether if you haven't collaborated with anyone)


# Use this to list any code that you used that you did not write,
# aside from code provided by the lecturer.  Provide a comment
# explaining your use and the URL to that code and the licence for
# that code
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external code)


# Use this to list any assets (artwork, sound, etc) that you used.
# Provide a comment explaining your use of that asset and the URL
# and license for the asset
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external assets)



# Sign *your* name and uids here. (Remove entries if you have fewer
# than three members.)
signatures:
- name: Wangyi Li
  uid: u7323052
- name: Xuanchen Wang
  uid: u7323912
- name: Zixin Feng
  uid: u7233947

## Git Contributions
#### Commit count via git log
```
      3 24011 <m18811652169@163.com>
      8 Bob <u1234567@anu.edu.au>
      3 Cindy <u1234567@anu.edu.au>
     18 Josh Milthorpe <josh.milthorpe@anu.edu.au>
     74 Wangyi Li <u7323052@anu.edu.au>
     14 Xuanchen Wang <u7323912@anu.edu.au>
     17 Xuanchen Wang u7323912@anu.edu.au <m18811652169@163.com>
     45 fengzixin <u7233947@anu.edu.au>

```
#### Line count via git blame
```
     14 24011
      9 Bob
      2 Cindy
   1427 Josh
   1279 Wangyi
   5228 Xuanchen
    565 fengzixin
```
## Git Log
```
commit 2d17c777c063e663586175fc24d6275c77bebde6
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Mon May 24 04:42:54 2021 +0800

    presentation.pdf upload

commit 183e14570b31e4268806c78330278e2ceaef90f1
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Mon May 24 02:04:03 2021 +1000

    Update G-originality.yml

commit 7903d14961c7b2a7da7e6108363b997d77d1f33f
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Mon May 24 02:01:30 2021 +1000

    Update G-contribution.yml

commit 747ba1eee806ef5c1a1959372c67aaf50b4107e3
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Mon May 24 02:01:01 2021 +1000

    Update F-best-u7233947.yml

commit 885834abcbd6fe2b691849198fc1472f00b06505
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Mon May 24 01:58:41 2021 +1000

    Update F-contribution.yml

commit 9728ea02dfb2883631426fb675125b8c0e73d300
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Mon May 24 01:57:03 2021 +1000

    Update F-originality.yml

commit d4bc0f9b94dd67a2b606b2a2539e1d5e9e4ec813
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun May 23 23:56:33 2021 +0800

    G-originality

commit b28c30e7f090c3ab28cd5324d9a54acbc4eb6d78
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun May 23 23:51:38 2021 +0800

    G-contribution G-presenttion

commit 6ed9e6c4bfab002a5c128ea1cc343e51159ec85b
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun May 23 23:49:00 2021 +0800

    G-presentation

commit c0efa072cb95aafb1b07b44663ce9ed81e15f251
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun May 23 22:59:39 2021 +0800

    G-presentation

commit 988b0b7fc7891432baad65da2e56301cfab49661
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun May 23 22:55:14 2021 +0800

    G- contribution & originality

commit 5a8733727e638ab5fcba073cd72dc2ef9cc315af
Merge: 6a7f6f8 7866a19
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Fri May 21 05:26:24 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 7866a19b47a5d690515df487c0b938f5330cc5b9
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Fri May 21 07:12:14 2021 +1000

    Update F-best-u7323052.yml

commit 6a7f6f888284c0919c33fb0cf21498c488d34cd6
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Fri May 21 05:04:59 2021 +0800

    Fixed Task9

commit 60549317d425d9eb7e953a34fb25c70ccf31b630
Merge: 3ce1349 fa4b4ef
Author: Xuanchen Wang u7323912@anu.edu.au <m18811652169@163.com>
Date:   Fri May 21 01:41:48 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 3ce1349c9fd461a2a3e0018175254512f0413940
Author: Xuanchen Wang u7323912@anu.edu.au <m18811652169@163.com>
Date:   Fri May 21 01:41:34 2021 +0800

    Update F-best and F-features

commit fa4b4ef6ab248ab9387ca905d37c1e0114e0e436
Merge: 0eb5552 62bc7d6
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Fri May 21 01:35:43 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 0eb55525baf4ec03d75eb9c353c499beadcfe7df
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Fri May 21 01:35:28 2021 +0800

    Modify task 9

commit 62bc7d6808978746869c28a220b9f810154c7546
Merge: 412893f e18f928
Author: Xuanchen Wang u7323912@anu.edu.au <m18811652169@163.com>
Date:   Fri May 21 01:32:09 2021 +0800

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       game.jar

commit 412893fb481a793759149a40ec71973ccbd2ef18
Author: Xuanchen Wang u7323912@anu.edu.au <m18811652169@163.com>
Date:   Fri May 21 01:31:33 2021 +0800

    Final version

commit e18f9286a0627f5f738ab24d0a3defa4f15d991d
Author: fengzixin <u7233947@anu.edu.au>
Date:   Fri May 21 01:20:07 2021 +0800

    F-Best

commit e3e217f02300b0f1bfb2648ef49dd6f5bad9fca1
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Fri May 21 00:35:55 2021 +0800

    Fix some problems on task 9

commit 851c8038906219b4c9e29ac840fc3db8c06d9556
Author: fengzixin <u7233947@anu.edu.au>
Date:   Thu May 20 23:02:44 2021 +0800

    Task 9

commit 87c2b65ec1f8e6702c7052468d149063869b897b
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Thu May 20 22:49:01 2021 +0800

    Modify F-best

commit bd31f02cff02da4ccb9c43ea108d841a785e6283
Merge: 6c8549f 1392d23
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Thu May 20 22:25:32 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 6c8549fdccad6305d45c799003f9fe7683c7f5ac
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Thu May 20 22:25:19 2021 +0800

    Task13 done

commit 1392d23657042263883c0a2f828d563e1c67f731
Merge: af5c1e3 4740deb
Author: fengzixin <u7233947@anu.edu.au>
Date:   Thu May 20 21:08:17 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit af5c1e3c199ce6f300d1704384be3a939b952f27
Author: fengzixin <u7233947@anu.edu.au>
Date:   Thu May 20 21:08:04 2021 +0800

    Task 9

commit 4740deb1a747922af5943933d64a7f1f3b97f450
Merge: a12ea1e a040056
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Thu May 20 17:40:13 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit a12ea1eee2b64d9ddfbbe40f7e5aceb6fd96a1c3
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Thu May 20 17:39:43 2021 +0800

    Task13 tilling done

commit a0400560d032a9dcb5089aa3386ccc73688fc610
Author: fengzixin <u7233947@anu.edu.au>
Date:   Thu May 20 17:26:32 2021 +0800

    Task 9

commit 8150fbf8c8d10848197fdc62fec6159c4533c70c
Merge: 8de9c6a 18e1ab5
Author: fengzixin <u7233947@anu.edu.au>
Date:   Thu May 20 17:17:46 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 8de9c6af0b652319a67d268a4097e160c8bffb86
Author: fengzixin <u7233947@anu.edu.au>
Date:   Thu May 20 17:17:29 2021 +0800

    Task 9

commit 18e1ab5b2f7e88d1c886d32f191ab7de0be60525
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Thu May 20 02:06:31 2021 +0800

    Fixed task11

commit bb3c8bc27d02497e5a7d32a1dcd8349421d64474
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Thu May 20 02:00:41 2021 +0800

    Task 11 done

commit a8248c646ca47d5ca0f4a5005b6993fada2e60b5
Merge: 952c5d7 7cada1b
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Thu May 20 00:05:43 2021 +0800

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/Azul.java

commit 952c5d73075a8896310dc923f468b1f9990048c2
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Thu May 20 00:04:25 2021 +0800

    Fixed missing Task13

commit 7cada1b2f711472b8d64d701157ee251da09a4d7
Author: fengzixin <u7233947@anu.edu.au>
Date:   Thu May 20 00:03:44 2021 +0800

    Task 9

commit 2a9a47677c2e71c4ee960c9bf95ac53bf5585266
Merge: 543c74a a20bba1
Author: fengzixin <u7233947@anu.edu.au>
Date:   Wed May 19 20:47:40 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 543c74a21cbf912a144f8f267adad5bf155f2fc9
Author: fengzixin <u7233947@anu.edu.au>
Date:   Wed May 19 20:47:24 2021 +0800

    Task 9

commit abd2f452e13bdebc727133a401f5b7b6798987e6
Author: fengzixin <u7233947@anu.edu.au>
Date:   Wed May 19 20:45:00 2021 +0800

    Task 9

commit a20bba1b0fc5b989a04b0edd5737d63cc73b28f6
Author: fengzixin <u7233947@anu.edu.au>
Date:   Wed May 19 20:45:00 2021 +0800

    Task 9

commit 44c68b35cca97eb078429df4aec8efac8f2b7ba1
Author: fengzixin <u7233947@anu.edu.au>
Date:   Tue May 18 21:58:09 2021 +0800

    Task 9

commit 11890c97cf011152d3a47571855e3098a2da532c
Merge: 6270258 331fc56
Author: fengzixin <u7233947@anu.edu.au>
Date:   Tue May 18 21:55:45 2021 +0800

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/Azul.java

commit 62702589bb2a74b72dfeda82bb3fdfc70bcc03a5
Author: fengzixin <u7233947@anu.edu.au>
Date:   Tue May 18 21:46:52 2021 +0800

    Task 9

commit 331fc567efdd97efb3e593fb92b703b86058b793
Author: fengzixin <u7233947@anu.edu.au>
Date:   Tue May 18 21:46:52 2021 +0800

    Task 9

commit fd88303db5513338cf32641d018aa37160d10e33
Merge: cbc4d0c f4c6973
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Mon May 17 11:13:38 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit f4c69737505bde8407971f6869bbd114dda828d2
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Mon May 17 12:02:41 2021 +1000

    Fix IsMoveValidTest.testStorageToFloor() to obey row order for tiling move

commit cbc4d0ce35741fc0e11a3fb93d59e41e75579536
Merge: 4886b67 eb75bb0
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Fri May 14 12:23:42 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit eb75bb02dece936aedca0183a69fd06be00c8ce7
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Thu May 13 10:41:02 2021 +1000

    remove move string from game state in ApplyMoveTest.testFloorFull() (thanks Yuhui Pang)

commit 4886b6717728a049cee1addfcd3197476ae45c13
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue May 4 12:50:56 2021 +1000

    feedback for D2E

commit 1490b4ea634723bb9416699a4c92e61dba8996d2
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Mon May 3 06:37:02 2021 +1000

    Update E-review-u7323052.md

commit 2388852c7f1674c841075561e18dfbf537597580
Merge: 5f9128d 8eda877
Author: fengzixin <u7233947@anu.edu.au>
Date:   Mon May 3 00:52:14 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 5f9128d53b34ed2d8fd3bf4dcc12bfee376141ae
Author: fengzixin <u7233947@anu.edu.au>
Date:   Mon May 3 00:52:00 2021 +0800

    review

commit 8eda877349fb58f0a20706e2643ba56b99353a15
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Mon May 3 02:30:10 2021 +1000

    Update E-review-u7323052.md

commit 3807d772304d219ab9e55456e762e8f7281afe73
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun May 2 23:47:28 2021 +0800

    Review format

commit 683ddc0eee6869c0046c3b98023b0c438406daed
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun May 2 23:37:05 2021 +0800

    Task10 committed

commit 10b79b930f2ad5d9380d2f2efbecf0895b671094
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun May 2 22:47:44 2021 +0800

    originality

commit 38ddd1e033e2cae2552c56bf54daa1e03f589407
Author: Xuanchen Wang <u7323912@anu.edu.au>
Date:   Sun May 2 21:22:09 2021 +1000

    Update E-review-u7323912.md

commit 778b677655395ca90f9b5b602bc815eb18a6fc03
Author: Xuanchen Wang <u7323912@anu.edu.au>
Date:   Sun May 2 21:21:36 2021 +1000

    Update E-review-u7323912.md

commit e6c8e4eba00bf2d7c065dc7be0bd37fb75e170de
Author: Xuanchen Wang <u7323912@anu.edu.au>
Date:   Sun May 2 21:15:37 2021 +1000

    Update E-review-u7323912.md

commit dc8032ae3581d0f2f2fd66adc7f4759df9fb5697
Author: Xuanchen Wang u7323912@anu.edu.au <m18811652169@163.com>
Date:   Sun May 2 18:41:27 2021 +0800

    review

commit 279df9dd8cb53a3b3836b284e32d19c1c4240c4f
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun May 2 17:26:28 2021 +0800

    originality

commit 7c51d49c84701ec6949530bc94f94fca9298d67d
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun May 2 17:24:39 2021 +0800

    originality

commit 94ac15b6ca848dfc4111c81b150aca2d04aa95a4
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun May 2 17:22:20 2021 +0800

    originality

commit c4ff54c3b2478db7dab66c2ef856fff728ec3913
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun May 2 17:18:39 2021 +0800

    originality

commit a14b3100c3e99f7a91a4092f746aea110f6691ca
Merge: 48f2240 f2230bb
Author: Xuanchen Wang u7323912@anu.edu.au <m18811652169@163.com>
Date:   Sun May 2 13:52:08 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 48f22403beb5de6de0d68ac568ca343370b2f6c1
Author: Xuanchen Wang u7323912@anu.edu.au <m18811652169@163.com>
Date:   Sun May 2 13:51:55 2021 +0800

    Done with export game.jar

commit f2230bb98e936a1682ce566dc7bdfe34d2b9de18
Merge: f1ce173 4f943bb
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Fri Apr 30 17:03:08 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit f1ce17356ea30fc28b63bd594b6202e8c4afa697
Merge: 3301979 05eb1ab
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Fri Apr 30 17:02:45 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 4f943bb2e5303e8b04308e6a28b930c421b3011e
Merge: df29ad3 b5e12bb
Author: Xuanchen Wang u7323912@anu.edu.au <m18811652169@163.com>
Date:   Fri Apr 30 16:43:38 2021 +0800

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       tests/comp1110/ass2/OurTest/DragAvailableInStorageTest.java

commit df29ad368ee3946dcfb33ec23a493ecc70e30c5d
Author: Xuanchen Wang u7323912@anu.edu.au <m18811652169@163.com>
Date:   Fri Apr 30 16:42:59 2021 +0800

    Polish some methods, separate GUI methods and back-end methods

commit 05eb1ab94b736f69345e4dfd86d7975af0e6a932
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Wed Apr 28 21:01:22 2021 +1000

    Fixed invalid states in isMoveValidTest (Thanks  John (Min Jae) Kim)
    Fixed string mutation in testStorageNotFull (thanks Qin-Yu Zhao)

commit b5e12bb1e4ebc9c36834de5f164eb1af070122f1
Author: fengzixin <u7233947@anu.edu.au>
Date:   Tue Apr 27 08:48:43 2021 +0800

    originality

commit 1cbd85cd70733cf1abc1b725b5f7761efe1b70b2
Author: fengzixin <u7233947@anu.edu.au>
Date:   Tue Apr 27 01:00:34 2021 +0800

    New code

commit 1fd64972ee4257437c92799850404dbb26f7d6d1
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Mon Apr 26 02:09:58 2021 +1000

    Update D-newcode-u7323052.md

commit 33019796a939bc6f122226aba85d413e25b2c07a
Merge: 4139cdc 2e445ed
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Mon Apr 26 00:04:22 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 4139cdc1373ad536d47e3e5eb6e5892da19f5adb
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Mon Apr 26 00:03:58 2021 +0800

    DragAvailable modification

commit 2e445ed671c547bcb29559f9097229557f7144a9
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun Apr 25 23:56:02 2021 +0800

    New code

commit acc5a67e980a33d1f032da49a2553bc587c8dbc5
Merge: 832abf7 de3f9bc
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun Apr 25 23:16:10 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 832abf7947ce34456dc11adde247e51b421625d1
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun Apr 25 23:15:49 2021 +0800

    refillFactories test

commit de3f9bc6fb380ee86d436c736315adc4c16a6cc1
Merge: 0325d4d 6472f4e
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Apr 25 23:11:08 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 0325d4d9a247277388e5a188970f8623655a444e
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Apr 25 23:10:35 2021 +0800

    DragTest committed

commit 6472f4ec80deb6eda24e09753f823f70a51a66da
Merge: df3c6f8 51874b4
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun Apr 25 23:07:10 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit df3c6f81ee705217dda894e8447425dde8372202
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun Apr 25 23:06:55 2021 +0800

    originality & refillFactories test

commit 51874b4a49043764e8147af9ab7a378babfcaf9a
Author: Xuanchen Wang <u7323912@anu.edu.au>
Date:   Mon Apr 26 00:39:24 2021 +1000

    Update D-newcode-u7323912.md

commit 1b09f2ef69ef8739a7243315a01b6ec475b4f8f2
Author: Xuanchen Wang <u7323912@anu.edu.au>
Date:   Mon Apr 26 00:38:33 2021 +1000

    Update D-newcode-u7323912.md

commit d422c3e9c2fd7e3b7f902da0042145ec82cf648d
Author: Xuanchen Wang <u7323912@anu.edu.au>
Date:   Mon Apr 26 00:37:54 2021 +1000

    Update D-newcode-u7323912.md

commit fbda3e4a17675f66ea0cd7f97e78b8e6c28370a2
Author: Xuanchen Wang <u7323912@anu.edu.au>
Date:   Mon Apr 26 00:31:40 2021 +1000

    Update D-newcode-u7323912.md

commit 9e847f48dcf98eb827b71b8333c6d15a418c9b11
Author: Xuanchen Wang <u7323912@anu.edu.au>
Date:   Mon Apr 26 00:20:05 2021 +1000

    Update D-newcode-u7323912.md

commit 38b7accd2280ee2e1bf17430226c37e591c0ee1d
Author: Xuanchen Wang <u7323912@anu.edu.au>
Date:   Mon Apr 26 00:14:36 2021 +1000

    Update D-newcode-u7323912.md

commit 2425badd25f0f8f57fad8601245206ad91618a13
Author: Xuanchen Wang u7323912@anu.edu.au <m18811652169@163.com>
Date:   Sun Apr 25 22:06:11 2021 +0800

    Done with click method and test

commit fffab6b252f7978452286a60c61a080dfb06b17a
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Apr 25 22:51:38 2021 +1000

    Update D-originality-u7323052.yml

commit 4d8893aec58930b52a406113cb574a98576be26e
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Apr 25 22:47:23 2021 +1000

    Update D-newcode-u7323052.md

commit 5d5d59e8f47ed88877cc9b864fd4ec184734bb47
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Apr 25 22:28:01 2021 +1000

    Update C-best-u7233947.yml

commit c0fb9445bafe2ae857101c00a49eb4ce7bf5d4fc
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Apr 25 22:25:43 2021 +1000

    Update C-best-u7233947.yml

commit 8417242044cf84a5801f66d86e1095b159d79bbb
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Apr 25 22:22:19 2021 +1000

    Update C-best-u7233947.yml

commit e68d78ab744373e0048fa7e4d8708d5b5024bc86
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun Apr 25 20:18:27 2021 +0800

    C best code

commit 2011c233afe36ddd09e927e53bb7ddca8f8f9ebf
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun Apr 25 20:16:43 2021 +0800

    C best

commit 81a7469fe9dc011b0c40a1e5a6782044afdad2b4
Merge: 561fce6 2d053de
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun Apr 25 20:14:56 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 2d053de30f093c747af9421dee800bf656024752
Author: Xuanchen Wang <u7323912@anu.edu.au>
Date:   Sun Apr 25 22:14:15 2021 +1000

    Update C-best-u7323912.yml

commit 561fce60efbbf53e9794d03ad4ba31007a3f9340
Merge: bf605d5 e4d1f57
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun Apr 25 20:14:12 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit bf605d5db042eaafe343b77e6f2c7cc9ac796454
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun Apr 25 20:13:43 2021 +0800

    C best

commit e4d1f5717b6e4691e8fbb0cf2ef1c356b84f595a
Author: Xuanchen Wang <u7323912@anu.edu.au>
Date:   Sun Apr 25 22:12:10 2021 +1000

    Update C-best-u7323912.yml

commit c01468856fa7d5426d2ade9d9c1a65993a50f595
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Apr 25 22:11:25 2021 +1000

    Update C-best-u7323912.yml

commit 563e9b28dcfb5706e5c3a9889ba3f2d9d70f77fb
Author: Xuanchen Wang u7323912@anu.edu.au <m18811652169@163.com>
Date:   Sun Apr 25 20:08:12 2021 +0800

    Update bestC

commit 5d5a4d14942a7cd2f63e988100d232773a7f5f90
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Apr 25 20:00:34 2021 +0800

    D-newcode

commit 44f4a1dd5b72c1a0482598199fbc4189bf3b1b9e
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Apr 25 19:51:30 2021 +0800

    C-best

commit 302ae862fe85a9dde64a70cdbaa757c1cf46bc82
Merge: 3e67062 6a17992
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Apr 25 19:47:29 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 3e67062bbdc54a41fada684a503943f889671276
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Apr 25 19:47:03 2021 +0800

    C-best

commit 6a17992ed05d79173868e99ef16870d945005d26
Merge: 6ddd7a7 9bb7e31
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun Apr 25 19:23:27 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 6ddd7a7fba09c4fd24e6567e11553b4936368c14
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun Apr 25 19:23:00 2021 +0800

    FillFactory

commit 9bb7e318c33713049d06b199f388054250b44501
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Apr 25 21:20:53 2021 +1000

    Update D-originality-u1234567.yml

commit 349d224280a0a5e535dc46103f94a577558de121
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Apr 25 21:06:53 2021 +1000

    Update C-originality.yml

commit af74b1eca355ebac189a215925a7eeda6c7067c0
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Apr 25 21:05:17 2021 +1000

    Update D-originality-u1234567.yml

commit b264e842e62511a08b87a06bb009b0260babef5d
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Apr 25 19:00:03 2021 +0800

    DragAvailable committed

commit d21dd91413b4eae53e39e1340035b2d0d1a76161
Author: Xuanchen Wang u7323912@anu.edu.au <m18811652169@163.com>
Date:   Sun Apr 25 18:27:30 2021 +0800

    Redesign the skeleton of the game

commit 1a520155477d97b2f3a96330c1be3faae0cd1c1a
Merge: 06c0fb2 83b34c5
Author: Xuanchen Wang u7323912@anu.edu.au <m18811652169@163.com>
Date:   Sun Apr 25 18:21:19 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 06c0fb232dc2100fbb0e6704c5bbf39da1d9aa73
Author: Xuanchen Wang u7323912@anu.edu.au <m18811652169@163.com>
Date:   Sun Apr 25 18:20:27 2021 +0800

    Redesign the skeleton of the game

commit 83b34c52ad7385b97e6667ba54de6bcaa310d0ba
Merge: 408c87b b4d35dc
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Fri Apr 23 19:55:36 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 408c87b1c887ecfab756ad6b9a179531f235a931
Merge: 68859bc 5f039f3
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Fri Apr 23 19:54:47 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit b4d35dc6b40a392bb7e5501fd5b60a6b21b59920
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Thu Apr 22 22:15:48 2021 +1000

    feedback for D2C

commit 5f039f3ef6e8321b11c0f8befd3e5e40bd1316ce
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Apr 20 12:27:49 2021 +1000

    remove not-well-formed test for factory with 3 tiles; add test for non-existent tile

commit 68859bcb287e0954d7098ab2394dd3d894b0188d
Merge: c10e449 6562807
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Apr 18 20:45:05 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit c10e4498fc3503194a63012b29f0fbd02576127a
Merge: 3a170c6 bd931ae
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Apr 18 20:44:31 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit bd931ae0fdaa8c33d509d352133eb4af4eaecf3d
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Sun Apr 18 20:47:58 2021 +1000

    fix invalid states in GetBonusPointsTest and NextRoundTest

commit 65628072e65805cdf2e2b14ec8a3a1c943f613b5
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun Apr 18 15:35:06 2021 +0800

    originality

commit f2cfd93f7dfc3839df5d679ff7c95ef2a8448850
Author: fengzixin <u7233947@anu.edu.au>
Date:   Sun Apr 18 15:01:06 2021 +0800

    u7233947 - Task 8

commit 435da8c4d20be469dabe79c3081b3ac5094fd2c7
Author: Xuanchen Wang u7323912@anu.edu.au <m18811652169@163.com>
Date:   Sun Apr 18 13:28:33 2021 +0800

    Update calculate points function with bonus points

commit 3a170c6d629f68cecc11dfddf48b48ec0a48269b
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Fri Apr 16 09:26:45 2021 +0800

    Fixed Task7 committed

commit 6c7a158b1f3ea647eabb82563cb3a1cbdd505ccb
Merge: 259e6bb 5ad75a6
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Fri Apr 16 09:08:39 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 259e6bbaa6c4504b61ba256db125bb563bf878c6
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Fri Apr 16 09:00:35 2021 +0800

    Task7 committed

commit 5ad75a6f484846b35e8bf21e2962eec6a4fd3415
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Fri Apr 16 09:24:35 2021 +1000

    Fix non-well-formed states in NextRoundTest and GetBonusPointsTest
    
    Clarify error message in notNextRound Test factory-centre string specifically rather than entire shared state string

commit e3e39159d8e2472f9b362dad24111e7630dd5652
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Thu Apr 15 22:05:32 2021 +0800

    Task6 committed

commit 1b065abbf5c0a6df1de56a998960a260f4f8443e
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Thu Apr 15 19:57:41 2021 +1000

    several improvements to tests
    
    Add test for centre tiles not in alphabetical order, thanks Xuanchen Wang
    Fix bonus scoring for nextRoundTest. Thanks  John (Min Jae) Kim and Juren Xu
    Clone test arrays to prevent test errors from state modification
    Add test to refillFactories for non-empty factories. Fix solution of refillFactories to check for tiles in the centre
    Fix nextRound to add bonusPoints at end of game
    Fix final score of Example Game Ashleigh Johannes Yesterday 10:35

commit 5fa9891ed87143e62f29ea2df08bd4d5b31286c1
Author: Xuanchen Wang u7323912@anu.edu.au <m18811652169@163.com>
Date:   Tue Apr 13 18:27:23 2021 +0800

    fix task2 and task5, done with task4

commit 4d78bcd5dc82cc971af374b12d6bbb798fe14d97
Author: Xuanchen Wang <u7323912@anu.edu.au>
Date:   Tue Apr 13 18:18:12 2021 +0800

    fix task2 and task5, done with task4

commit 742b0da52ce7b539cd0caa8113898e0c03d19a14
Merge: 49844ff bc81214
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Mon Apr 12 20:52:27 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 49844fffbeae6f4cebc3d08ae2317cce97e044e2
Merge: d1aaf37 e46d8d4
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Mon Apr 12 20:51:01 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit e46d8d4f4391f97b8b193f8844fce7db54e53ab9
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Mon Apr 12 22:06:42 2021 +1000

    complete set of tests, including new tests for Tasks 8 and 13

commit bc81214e0515509c4152189ad800e42c6d952b00
Merge: 5f8479b d1aaf37
Author: Xuanchen Wang u7323912@anu.edu.au <m18811652169@163.com>
Date:   Mon Apr 12 18:44:24 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 5f8479bb12ea7faa1503eff8775897057965f9d3
Author: Xuanchen Wang <u7323912@anu.edu.au>
Date:   Mon Apr 12 18:44:08 2021 +0800

    Done with task5

commit d1aaf371e6d36ecaa07826577945d62998de7636
Merge: dcaad7b 0dadb0e
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Mon Apr 12 17:28:37 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit dcaad7bf993d8a1c60806373b60d7057cd7e7774
Merge: 7e8d657 b2b0023
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Mon Apr 12 17:28:07 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 0dadb0e9425359f3a1e1feda8219f87b57c82d2d
Author: Xuanchen Wang <u7323912@anu.edu.au>
Date:   Mon Apr 12 12:27:38 2021 +0800

    Done with task2 and task3

commit b2b00238ec4057e542d119cb175db0e85a2c4ec7
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Apr 6 16:53:13 2021 +1000

    fixes to incorrect strings in README (thanks to Qin-Yu Zhao)
    
    also update Javadoc for Azul.isSharedStateWellFormed to include Turn substring

commit 3cc421e276ce63352da7647e763280318720d04b
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Mar 30 13:23:17 2021 +1100

    feedback for D2B

commit 7d6793650844353cd68979276ce814f5ae976f8b
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Mon Mar 29 00:16:32 2021 +1100

    Update B-originality.yml

commit 364b3a1a86e5be4896d4cc497722facdfd0b2484
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Mon Mar 29 00:15:07 2021 +1100

    Update B-contribution.yml

commit 7e8d65758a1797617b96a9c28cdcfbe13162774b
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Sun Mar 28 21:12:45 2021 +0800

    Skeleton committed

commit b3e6062afd6bf4d483cb8e8a3c2647d1984ab584
Merge: 69c03f2 fcbb9c5
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Tue Mar 23 15:14:58 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 69c03f2c99ae7ffe8be4ecd023770ab7e9ee5e39
Merge: 7aeafa1 c11b565
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Tue Mar 23 15:14:37 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit fcbb9c52dd617702f4e99f6e1854214e12111924
Author: Cindy <u1234567@anu.edu.au>
Date:   Tue Mar 23 14:12:11 2021 +0800

    Created an instance C inside Math

commit 2eb08b8f612c88440bcede2d585b6870bb3740b0
Author: Cindy <u1234567@anu.edu.au>
Date:   Tue Mar 23 13:51:27 2021 +0800

    Created an instance C inside Math

commit ade4262c7d815479962cdf4e5d1ae3be1a211042
Author: Cindy <u1234567@anu.edu.au>
Date:   Tue Mar 23 13:49:39 2021 +0800

    Created an instance C inside Math

commit c11b565c45fb435089e189669f88b871d8c13176
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Mar 23 16:10:29 2021 +1100

    clarify Centre placement string including first player tile

commit 698fe7968b38f0f7efddecf55b206aa71e5cfb76
Author: Bob <u1234567@anu.edu.au>
Date:   Tue Mar 23 12:31:02 2021 +0800

    Added C

commit 3d68e8de0dd4fff8352c1d9dfd88c77f4a1ffa75
Author: Bob <u1234567@anu.edu.au>
Date:   Tue Mar 23 12:25:28 2021 +0800

    Created an instance C inside Math

commit 50abd0ef739eee77522fc2f91ddd954a0f1df521
Merge: 7aeafa1 a6fbd22
Author: fengzixin <u7233947@anu.edu.au>
Date:   Tue Mar 23 11:41:50 2021 +0800

    Merge remote-tracking branch 'origin/BobsExperiment'

commit 7aeafa19308c012d2027117cec4e82492f15692d
Merge: cab0f2c 0a2eec7
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Tue Mar 23 11:27:14 2021 +0800

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/gittest/Main.java

commit 0a2eec7de6b0cfec202aea15e6b0f29689d630c7
Author: 24011 <m18811652169@163.com>
Date:   Tue Mar 23 11:24:44 2021 +0800

    add new A

commit cab0f2cba74683d746e35551d6dc032058fdebe0
Author: Bob <u1234567@anu.edu.au>
Date:   Tue Mar 23 11:24:09 2021 +0800

    Created an instance of B inside Main

commit a6fbd22d8ddce9f35b4c9b3b3212b2ddc55c1748
Author: Bob <u1234567@anu.edu.au>
Date:   Tue Mar 23 11:13:39 2021 +0800

    Another experimental change to B

commit ce055b510af848c0911cb641de375232ff093c1e
Author: Bob <u1234567@anu.edu.au>
Date:   Tue Mar 23 11:12:48 2021 +0800

    Experimental change to B

commit 0d623b7a8840be580559cf49a6dac6df98a54b87
Author: Bob <u1234567@anu.edu.au>
Date:   Tue Mar 23 10:57:54 2021 +0800

    Added C

commit 8401124bcb72177b2aadacb5734b1bee96f91b32
Author: Bob <u1234567@anu.edu.au>
Date:   Tue Mar 23 10:40:46 2021 +0800

    Added C

commit 12bd83aef632700fd192debfc067aa3fe0f0d5b6
Author: Bob <u1234567@anu.edu.au>
Date:   Tue Mar 23 09:40:01 2021 +0800

    Added B

commit 86b5454f0696ea598ef649ba32492e5b430d94ec
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Tue Mar 23 09:34:45 2021 +0800

    Added B

commit 170d06e20764c0f23eb2b84540f2205b2bbc9dd7
Merge: 4bc8e4a 46914c3
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Tue Mar 23 09:30:41 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 4bc8e4a9b6da407885fa4ce4c8726ca9b2db321f
Merge: 108fcf6 4f69425
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Tue Mar 23 09:24:47 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 46914c3bcf69d5ab50166aae23b12759a308bea1
Merge: d9341ca 1df335b
Author: 24011 <m18811652169@163.com>
Date:   Tue Mar 23 09:22:43 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit d9341ca6a553620373d61d92228dc99057640908
Author: 24011 <m18811652169@163.com>
Date:   Tue Mar 23 09:22:04 2021 +0800

    Alice 1

commit 4f694254de647ef83f37b6035256d2125a2ffe04
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Mon Mar 22 13:16:12 2021 +1100

    Java 15

commit ed4ae2fdbfc811b7fda9e47176f60a16603f010f
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Sun Mar 21 20:07:43 2021 +1100

    fix name of IsPlayerStateWellFormedTest

commit 404db87e001efec37beb6c5f4e70bf11aceaef88
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Sun Mar 21 20:04:47 2021 +1100

    fix name of IsPlayerStateWellFormedTest

commit 1df335b41656306e3193effbd29c6438139b7f47
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Thu Mar 18 14:01:27 2021 +1100

    Update members.yml

commit 3b1eaa487b4ea8864776d056e52a3d39d4fe1040
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Tue Mar 16 14:01:49 2021 +1100

    Update members.yml

commit d9541f7dd57f06dbacde21f85e215f3d60dba6c8
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Tue Mar 16 13:44:28 2021 +1100

    Update members.yml

commit c36a0132b1833c3c157256451ccf7b4058d1dd67
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Tue Mar 16 13:43:59 2021 +1100

    Update members.yml

commit 108fcf6eef492e3988ea4ee1d8d9e626cb95c9aa
Author: Wangyi Li <u7323052@anu.edu.au>
Date:   Tue Mar 16 13:30:43 2021 +1100

    Update members.yml

commit 73783fca77459dd1248988752488e4d8e64e0fec
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Mar 16 10:06:29 2021 +1100

    add link to game rules; cleanup task numbers

commit 9d4a5eb49c6f1970f9ed47b739ae3abddae8b8b9
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Mar 16 01:09:23 2021 +1100

    Initial import
```
## Changes
``` diff
Only in comp1110-ass2/.idea/artifacts: game.xml
Only in comp1110-ass2/.idea: inspectionProfiles
diff -ru -x .git ../master/comp1110-ass2/.idea/libraries/JavaFX.xml comp1110-ass2/.idea/libraries/JavaFX.xml
--- ../master/comp1110-ass2/.idea/libraries/JavaFX.xml	2021-03-30 10:54:46.287233400 +1100
+++ comp1110-ass2/.idea/libraries/JavaFX.xml	2021-05-24 16:31:17.336733200 +1000
@@ -1,16 +1,10 @@
-<component name="libraryTable">
-  <library name="JavaFX">
-    <CLASSES>
-      <root url="file://$PATH_TO_FX$" />
-    </CLASSES>
-    <JAVADOC />
-    <NATIVE>
-      <root url="file://$PATH_TO_FX$" />
-    </NATIVE>
-    <SOURCES>
-      <root url="file://$PATH_TO_FX$" />
-    </SOURCES>
-    <jarDirectory url="file://$PATH_TO_FX$" recursive="false" />
-    <jarDirectory url="file://$PATH_TO_FX$" recursive="false" type="SOURCES" />
-  </library>
+<component name="libraryTable">
+  <library name="JavaFX">
+    <CLASSES />
+    <JAVADOC />
+    <NATIVE>
+      <root url="file://$PATH_TO_FX$" />
+    </NATIVE>
+    <SOURCES />
+  </library>
 </component>
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Task_10_IsMoveValidTest.xml comp1110-ass2/.idea/runConfigurations/Task_10_IsMoveValidTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Task_10_IsMoveValidTest.xml	2021-03-30 10:54:46.322389500 +1100
+++ comp1110-ass2/.idea/runConfigurations/Task_10_IsMoveValidTest.xml	2021-04-26 08:28:05.799986100 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="comp1110.ass2.gui.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Task_11_ApplyMoveTest.xml comp1110-ass2/.idea/runConfigurations/Task_11_ApplyMoveTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Task_11_ApplyMoveTest.xml	2021-03-30 10:54:46.330698700 +1100
+++ comp1110-ass2/.idea/runConfigurations/Task_11_ApplyMoveTest.xml	2021-04-26 08:28:05.806967200 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="comp1110.ass2.gui.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Task_13_GenerateActionTest.xml comp1110-ass2/.idea/runConfigurations/Task_13_GenerateActionTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Task_13_GenerateActionTest.xml	2021-04-19 11:58:35.336482100 +1000
+++ comp1110-ass2/.idea/runConfigurations/Task_13_GenerateActionTest.xml	2021-04-26 08:28:05.813303800 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="comp1110.ass2.OurTest.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Task_2_IsSharedStateWellFormedTest.xml comp1110-ass2/.idea/runConfigurations/Task_2_IsSharedStateWellFormedTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Task_2_IsSharedStateWellFormedTest.xml	2021-03-30 10:54:46.338092400 +1100
+++ comp1110-ass2/.idea/runConfigurations/Task_2_IsSharedStateWellFormedTest.xml	2021-04-26 08:28:05.819649300 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="comp1110.ass2.gui.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Task_3_IsPlayerStateWellFormedTest.xml comp1110-ass2/.idea/runConfigurations/Task_3_IsPlayerStateWellFormedTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Task_3_IsPlayerStateWellFormedTest.xml	2021-03-30 10:54:46.346099000 +1100
+++ comp1110-ass2/.idea/runConfigurations/Task_3_IsPlayerStateWellFormedTest.xml	2021-04-26 08:28:05.826703200 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="comp1110.ass2.gui.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Task_5_DrawTileFromBagTest.xml comp1110-ass2/.idea/runConfigurations/Task_5_DrawTileFromBagTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Task_5_DrawTileFromBagTest.xml	2021-03-30 10:54:46.354102300 +1100
+++ comp1110-ass2/.idea/runConfigurations/Task_5_DrawTileFromBagTest.xml	2021-04-26 08:28:05.833166400 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="comp1110.ass2.gui.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Task_6_RefillFactoriesTest.xml comp1110-ass2/.idea/runConfigurations/Task_6_RefillFactoriesTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Task_6_RefillFactoriesTest.xml	2021-03-30 10:54:46.361086100 +1100
+++ comp1110-ass2/.idea/runConfigurations/Task_6_RefillFactoriesTest.xml	2021-04-26 08:28:05.839149100 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="comp1110.ass2.gui.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Task_7_GetBonusPointsTest.xml comp1110-ass2/.idea/runConfigurations/Task_7_GetBonusPointsTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Task_7_GetBonusPointsTest.xml	2021-03-30 10:54:46.368114000 +1100
+++ comp1110-ass2/.idea/runConfigurations/Task_7_GetBonusPointsTest.xml	2021-04-26 08:28:05.848128100 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="comp1110.ass2.gui.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Task_8_NextRoundTest.xml comp1110-ass2/.idea/runConfigurations/Task_8_NextRoundTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Task_8_NextRoundTest.xml	2021-04-19 11:58:35.343291400 +1000
+++ comp1110-ass2/.idea/runConfigurations/Task_8_NextRoundTest.xml	2021-04-26 08:28:05.864085800 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="comp1110.ass2.OurTest.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Task_9_IsStateValidTest.xml comp1110-ass2/.idea/runConfigurations/Task_9_IsStateValidTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Task_9_IsStateValidTest.xml	2021-03-30 10:54:46.376046100 +1100
+++ comp1110-ass2/.idea/runConfigurations/Task_9_IsStateValidTest.xml	2021-04-26 08:28:05.880040800 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="comp1110.ass2.gui.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
Only in comp1110-ass2/.idea: vcs.xml
Only in comp1110-ass2/.idea: workspace.xml
Only in comp1110-ass2: META-INF
diff -ru -x .git ../master/comp1110-ass2/admin/B-contribution.yml comp1110-ass2/admin/B-contribution.yml
--- ../master/comp1110-ass2/admin/B-contribution.yml	2021-03-30 10:54:46.400370000 +1100
+++ comp1110-ass2/admin/B-contribution.yml	2021-03-30 11:07:00.464280600 +1100
@@ -8,19 +8,19 @@
 # be 100 or 99 (33/33/33 is fine).  (Remove entries if you have fewer than three
 # members).  
 contributions:
-  - uid: 
-    contribution: 
-  - uid:
-    contribution:
-  - uid:
-    contribution:
+  - uid: u7323052
+    contribution: 33
+  - uid: u7323912
+    contribution: 33
+  - uid: u7233947
+    contribution: 33
 
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members)
 signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
\ No newline at end of file
+  - name: Wangyi Li
+    uid: u7323052
+  - name: Xuanchen Wang
+    uid: u7323912
+  - name: Zixin Feng
+    uid: u7233947
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/admin/B-originality.yml comp1110-ass2/admin/B-originality.yml
--- ../master/comp1110-ass2/admin/B-originality.yml	2021-03-30 10:54:46.407498900 +1100
+++ comp1110-ass2/admin/B-originality.yml	2021-03-30 11:07:00.476248700 +1100
@@ -19,9 +19,7 @@
 #
 # Add as many "name+comment" entries as necessary
 # (or remove it altogether if you haven't collaborated with anyone)
-collaboration:
-  - name:
-    comment: >-
+
 
 # Use this to list any code that you used that you did not write,
 # aside from code provided by the lecturer.  Provide a comment
@@ -30,10 +28,7 @@
 #
 # Add as many "url+licence+comment" entries as necessary
 # (or remove it altogether if you haven't used any external code)
-code:
-  - comment:
-    url:
-    licence:
+
 
 # Use this to list any assets (artwork, sound, etc) that you used.
 # Provide a comment explaining your use of that asset and the URL
@@ -41,18 +36,15 @@
 #
 # Add as many "url+licence+comment" entries as necessary
 # (or remove it altogether if you haven't used any external assets)
-assets:
-  - comment:
-    url:
-    licence:
+
 
 
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members.)
 signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
+  - name: Wangyi Li
+    uid: u7323052
+  - name: Xuanchen Wang
+    uid: u7323912
+  - name: Zixin Feng
+    uid: u7233947
Only in comp1110-ass2/admin: C-best-u7233947.yml
Only in comp1110-ass2/admin: C-best-u7323052.yml
Only in comp1110-ass2/admin: C-best-u7323912.yml
diff -ru -x .git ../master/comp1110-ass2/admin/C-contribution.yml comp1110-ass2/admin/C-contribution.yml
--- ../master/comp1110-ass2/admin/C-contribution.yml	2021-03-30 10:54:46.414482800 +1100
+++ comp1110-ass2/admin/C-contribution.yml	2021-04-19 11:58:39.044960800 +1000
@@ -8,19 +8,19 @@
 # be 100 or 99 (33/33/33 is fine).  (Remove entries if you have fewer than three
 # members).  
 contributions:
-  - uid: 
-    contribution: 
-  - uid:
-    contribution:
-  - uid:
-    contribution:
+  - uid: u7323912
+    contribution: 60
+  - uid: u7323052
+    contribution: 30
+  - uid: u7233947
+    contribution: 10
 
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members)
 signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
\ No newline at end of file
+  - name: Wangyi Li
+    uid: u7323052
+  - name: Xuanchen Wang
+    uid: u7323912
+  - name: Zixin Feng
+    uid: u7233947
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/admin/C-originality.yml comp1110-ass2/admin/C-originality.yml
--- ../master/comp1110-ass2/admin/C-originality.yml	2021-03-30 10:54:46.421464100 +1100
+++ comp1110-ass2/admin/C-originality.yml	2021-04-26 08:28:05.920952100 +1000
@@ -19,40 +19,15 @@
 #
 # Add as many "name+comment" entries as necessary
 # (or remove it altogether if you haven't collaborated with anyone)
-collaboration:
-  - name:
-    comment: >-
 
-# Use this to list any code that you used that you did not write,
-# aside from code provided by the lecturer.  Provide a comment
-# explaining your use and the URL to that code and the licence for
-# that code
-#
-# Add as many "url+licence+comment" entries as necessary
-# (or remove it altogether if you haven't used any external code)
-code:
-  - comment:
-    url:
-    licence:
-
-# Use this to list any assets (artwork, sound, etc) that you used.
-# Provide a comment explaining your use of that asset and the URL
-# and license for the asset
-#
-# Add as many "url+licence+comment" entries as necessary
-# (or remove it altogether if you haven't used any external assets)
-assets:
-  - comment:
-    url:
-    licence:
 
 
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members.)
 signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
+  - name: Wangyi Li
+    uid: u7323052
+  - name: Xuanchen Wang
+    uid: u7323912
+  - name: Zixin Feng
+    uid: u7233947
Only in ../master/comp1110-ass2/admin: D-newcode-u1234567.md
Only in comp1110-ass2/admin: D-newcode-u7233947.md
Only in comp1110-ass2/admin: D-newcode-u7323052.md
Only in comp1110-ass2/admin: D-newcode-u7323912.md
Only in ../master/comp1110-ass2/admin: D-originality-u1234567.yml
Only in comp1110-ass2/admin: D-originality-u7233947.yml
Only in comp1110-ass2/admin: D-originality-u7323052.yml
Only in comp1110-ass2/admin: D-originality-u7323912.yml
diff -ru -x .git ../master/comp1110-ass2/admin/E-contribution.yml comp1110-ass2/admin/E-contribution.yml
--- ../master/comp1110-ass2/admin/E-contribution.yml	2021-03-30 10:54:46.445783500 +1100
+++ comp1110-ass2/admin/E-contribution.yml	2021-05-03 08:01:17.454474700 +1000
@@ -8,19 +8,19 @@
 # be 100 or 99 (33/33/33 is fine).  (Remove entries if you have fewer than three
 # members).  
 contributions:
-  - uid: 
-    contribution: 
-  - uid:
-    contribution:
-  - uid:
-    contribution:
+  - uid: u7233947
+    contribution: 33
+  - uid: u7323052
+    contribution: 33
+  - uid: u7323912
+    contribution: 33
 
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members)
 signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
\ No newline at end of file
+  - name: Zixin Feng
+    uid: u7233947
+  - name: Wangyi Li
+    uid: u7323052
+  - name: Xuanchen Wang
+    uid: u7323912
diff -ru -x .git ../master/comp1110-ass2/admin/E-originality.yml comp1110-ass2/admin/E-originality.yml
--- ../master/comp1110-ass2/admin/E-originality.yml	2021-03-30 10:54:46.452770600 +1100
+++ comp1110-ass2/admin/E-originality.yml	2021-05-03 08:01:17.463450700 +1000
@@ -14,45 +14,12 @@
   and all stages before it is entirely our own work, with the following
   exceptions:
 
-# Use this to list names of people who you collaborated with, and a
-# comment about what you collaborated on.
-#
-# Add as many "name+comment" entries as necessary
-# (or remove it altogether if you haven't collaborated with anyone)
-collaboration:
-  - name:
-    comment: >-
-
-# Use this to list any code that you used that you did not write,
-# aside from code provided by the lecturer.  Provide a comment
-# explaining your use and the URL to that code and the licence for
-# that code
-#
-# Add as many "url+licence+comment" entries as necessary
-# (or remove it altogether if you haven't used any external code)
-code:
-  - comment:
-    url:
-    licence:
-
-# Use this to list any assets (artwork, sound, etc) that you used.
-# Provide a comment explaining your use of that asset and the URL
-# and license for the asset
-#
-# Add as many "url+licence+comment" entries as necessary
-# (or remove it altogether if you haven't used any external assets)
-assets:
-  - comment:
-    url:
-    licence:
-
-
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members.)
 signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
+  - name: Zixin Feng
+    uid: u7233947
+  - name: Wangyi Li
+    uid: u7323052
+  - name: Xuanchen Wang
+    uid: u7323912
Only in ../master/comp1110-ass2/admin: E-review-u1234567.md
Only in comp1110-ass2/admin: E-review-u7233947.md
Only in comp1110-ass2/admin: E-review-u7323052.md
Only in comp1110-ass2/admin: E-review-u7323912.md
Only in ../master/comp1110-ass2/admin: F-best-u1234567.yml
Only in comp1110-ass2/admin: F-best-u7233947.yml
Only in comp1110-ass2/admin: F-best-u7323052.yml
Only in comp1110-ass2/admin: F-best-u7323912.yml
diff -ru -x .git ../master/comp1110-ass2/admin/F-contribution.yml comp1110-ass2/admin/F-contribution.yml
--- ../master/comp1110-ass2/admin/F-contribution.yml	2021-03-30 10:54:46.476703300 +1100
+++ comp1110-ass2/admin/F-contribution.yml	2021-05-24 16:31:17.352733500 +1000
@@ -10,19 +10,19 @@
 # be 100 or 99 (33/33/33 is fine).  (Remove entries if you have fewer than three
 # members).
 contributions:
-  - uid: 
-    contribution: 
-  - uid:
-    contribution:
-  - uid:
-    contribution:
+  - uid: u7323912
+    contribution: 50
+  - uid: u7323052
+    contribution: 30
+  - uid: u7233947
+    contribution: 20
 
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members)
 signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
+  - name: Zixin Feng
+    uid: u7233947
+  - name: Xuanchen Wang
+    uid: u7323912
+  - name: Wangyi Li
+    uid: u7323052
diff -ru -x .git ../master/comp1110-ass2/admin/F-features.md comp1110-ass2/admin/F-features.md
--- ../master/comp1110-ass2/admin/F-features.md	2021-03-30 10:54:46.483684700 +1100
+++ comp1110-ass2/admin/F-features.md	2021-05-21 09:17:43.035203200 +1000
@@ -8,5 +8,7 @@
  - A basic playable game that snaps pieces to the board and checks for validity (Task 12)
  - Playable against a computer opponent (Task 14)
  - Implements interesting game variant/s (Task 16)
+ - Automatically move tiles to floor and mosaic by using animation
+ - Choose different mosaic board for each player
 
 additional features...
diff -ru -x .git ../master/comp1110-ass2/admin/F-originality.yml comp1110-ass2/admin/F-originality.yml
--- ../master/comp1110-ass2/admin/F-originality.yml	2021-03-30 10:54:46.490666000 +1100
+++ comp1110-ass2/admin/F-originality.yml	2021-05-24 16:31:17.361733500 +1000
@@ -14,45 +14,14 @@
   everything we have submitted for for all stages of this assignment was
   entirely our own work, with the following exceptions:
 
-# Use this to list names of people who you collaborated with, and a
-# comment about what you collaborated on.
-#
-# Add as many "name+comment" entries as necessary
-# (or remove it altogether if you haven't collaborated with anyone)
-collaboration:
-  - name:
-    comment: >-
-
-# Use this to list any code that you used that you did not write,
-# aside from code provided by the lecturer.  Provide a comment
-# explaining your use and the URL to that code and the licence for
-# that code
-#
-# Add as many "url+licence+comment" entries as necessary
-# (or remove it altogether if you haven't used any external code)
-code:
-  - comment:
-    url:
-    licence:
-
-# Use this to list any assets (artwork, sound, etc) that you used.
-# Provide a comment explaining your use of that asset and the URL
-# and license for the asset
-#
-# Add as many "url+licence+comment" entries as necessary
-# (or remove it altogether if you haven't used any external assets)
-assets:
-  - comment:
-    url:
-    licence:
 
 
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members.)
 signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
+  - name: Zixin Feng
+    uid: u7233947
+  - name: Wangyi Li
+    uid: u7323052
+  - name: Xuanchen Wang
+    uid: u7323912
diff -ru -x .git ../master/comp1110-ass2/admin/G-contribution.yml comp1110-ass2/admin/G-contribution.yml
--- ../master/comp1110-ass2/admin/G-contribution.yml	2021-03-30 10:54:46.498644300 +1100
+++ comp1110-ass2/admin/G-contribution.yml	2021-05-24 16:31:17.369733400 +1000
@@ -8,19 +8,19 @@
 # be 100 or 99 (33/33/33 is fine).  (Remove entries if you have fewer than three
 # members).  
 contributions:
-  - uid: 
-    contribution: 
-  - uid:
-    contribution:
-  - uid:
-    contribution:
+  - uid: u7233947
+    contribution: 33
+  - uid: u7323052
+    contribution: 33
+  - uid: u7323912
+    contribution: 33
 
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members)
 signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
\ No newline at end of file
+  - name: Zixin Feng
+    uid: u7233947
+  - name: Wangyi Li
+    uid: u7323052
+  - name: Xuanchen Wang
+    uid: u7323912
diff -ru -x .git ../master/comp1110-ass2/admin/G-originality.yml comp1110-ass2/admin/G-originality.yml
--- ../master/comp1110-ass2/admin/G-originality.yml	2021-03-30 10:54:46.505626100 +1100
+++ comp1110-ass2/admin/G-originality.yml	2021-05-24 16:31:17.377733400 +1000
@@ -14,45 +14,14 @@
   and all stages before it is entirely our own work, with the following
   exceptions:
 
-# Use this to list names of people who you collaborated with, and a
-# comment about what you collaborated on.
-#
-# Add as many "name+comment" entries as necessary
-# (or remove it altogether if you haven't collaborated with anyone)
-collaboration:
-  - name:
-    comment: >-
-
-# Use this to list any code that you used that you did not write,
-# aside from code provided by the lecturer.  Provide a comment
-# explaining your use and the URL to that code and the licence for
-# that code
-#
-# Add as many "url+licence+comment" entries as necessary
-# (or remove it altogether if you haven't used any external code)
-code:
-  - comment:
-    url:
-    licence:
-
-# Use this to list any assets (artwork, sound, etc) that you used.
-# Provide a comment explaining your use of that asset and the URL
-# and license for the asset
-#
-# Add as many "url+licence+comment" entries as necessary
-# (or remove it altogether if you haven't used any external assets)
-assets:
-  - comment:
-    url:
-    licence:
 
 
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members.)
-signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
+signatures :
+  - name: Zixin Feng
+    uid: u7233947
+  - name: Wangyi Li
+    uid: u7323052
+  - name: Xuanchen Wang
+    uid: u7323912
diff -ru -x .git ../master/comp1110-ass2/admin/G-presentation.yml comp1110-ass2/admin/G-presentation.yml
--- ../master/comp1110-ass2/admin/G-presentation.yml	2021-03-30 10:54:46.512607100 +1100
+++ comp1110-ass2/admin/G-presentation.yml	2021-05-24 16:31:17.385734100 +1000
@@ -1,2 +1,2 @@
 # use this file to record the ANU Sharepoint URL for your video presentation
-url: "https://anu365-my.sharepoint.com/:v:/g/personal/u1234567_anu_edu_au/xxxx"
+url: https://anu365-my.sharepoint.com/:v:/g/personal/u7323052_anu_edu_au/EcxqmmvHnkpJikxtpEml6fUB7eXI0f7I1mHTSyWITZ4wTw
diff -ru -x .git ../master/comp1110-ass2/admin/members.yml comp1110-ass2/admin/members.yml
--- ../master/comp1110-ass2/admin/members.yml	2021-03-30 10:54:46.519588600 +1100
+++ comp1110-ass2/admin/members.yml	2021-03-30 11:07:00.702776200 +1100
@@ -3,9 +3,9 @@
 #
 
 members:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
+  - name: Wangyi Li
+    uid: u7323052
+  - name: Xuanchen Wang
+    uid: u7323912
+  - name: Zixin Feng
+    uid: u7233947
Only in comp1110-ass2/admin: presentation.pdf
Only in comp1110-ass2: feedback
Only in comp1110-ass2: feedback.md
Only in comp1110-ass2: game.jar
Only in comp1110-ass2: markertmp
Only in comp1110-ass2: out
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/Azul.java comp1110-ass2/src/comp1110/ass2/Azul.java
--- ../master/comp1110-ass2/src/comp1110/ass2/Azul.java	2021-04-19 11:58:35.359892300 +1000
+++ comp1110-ass2/src/comp1110/ass2/Azul.java	2021-05-21 09:17:43.184202800 +1000
@@ -1,288 +1,1883 @@
-package comp1110.ass2;
-
-public class Azul {
-    /**
-     * Given a shared state string, determine if it is well-formed.
-     * Note: you don't need to consider validity for this task.
-     * A sharedState is well-formed if it satisfies the following conditions.
-     * <p>
-     * [turn][factories][centre][bag][discard]
-     * where [turn][factories], [centre], [bag] and [discard] are replaced by the
-     * corresponding small string as described below.
-     * <p>
-     * 0. [turn] The Turn substring is one character 'A'-'D' representing a
-     * player, which indicates that it is this player's turn to make the next
-     * drafting move. (In a two-player game, the turn substring can only take
-     * the values 'A' or 'B').
-     * <p>
-     * 1. [factories] The factories substring begins with an 'F'
-     * and is followed by a collection of *up to* 5 5-character factory strings
-     * representing each factory.
-     * Each factory string is defined in the following way:
-     * 1st character is a sequential digit '0' to '4' - representing the
-     * factory number.
-     * 2nd - 5th characters are 'a' to 'e', alphabetically - representing
-     * the tiles.
-     * A factory may have between 0 and 4 tiles. If a factory has 0 tiles,
-     * it does not appear in the factories string.
-     * Factory strings are ordered by factory number.
-     * For example: given the string "F1aabc2abbb4ddee": Factory 1 has tiles
-     * 'aabc', Factory 2 has tiles 'abbb', Factory 4 has tiles 'ddee', and
-     * Factories 0 and 4 are empty.
-     * <p>
-     * 2. [centre] The centre substring starts with a 'C'
-     * This is followed by *up to* 15 characters.
-     * Each character is 'a' to 'e', alphabetically - representing a tile
-     * in the centre.
-     * The centre string is sorted alphabetically.
-     * For example: "Caaabcdde" The Centre contains three 'a' tiles, one 'b'
-     * tile, one 'c' tile, two 'd' tile and one 'e' tile.
-     * <p>
-     * 3. [bag] The bag substring starts with a 'B'
-     * and is followed by 5 2-character substrings
-     * 1st substring represents the number of 'a' tiles, from 0 - 20.
-     * 2nd substring represents the number of 'b' tiles, from 0 - 20.
-     * 3rd substring represents the number of 'c' tiles, from 0 - 20.
-     * 4th substring represents the number of 'd' tiles, from 0 - 20.
-     * 5th substring represents the number of 'e' tiles, from 0 - 20.
-     * <p>
-     * For example: "B0005201020" The bag contains zero 'a' tiles, five 'b'
-     * tiles, twenty 'c' tiles, ten 'd' tiles and twenty 'e' tiles.
-     * 4. [discard] The discard substring starts with a 'D'
-     * and is followed by 5 2-character substrings defined the same as the
-     * bag substring.
-     * For example: "D0005201020" The bag contains zero 'a' tiles, five 'b'
-     * tiles, twenty 'c' tiles, ten 'd' tiles, and twenty 'e' tiles.
-     *
-     * @param sharedState the shared state - factories, bag and discard.
-     * @return true if sharedState is well-formed, otherwise return false
-     * TASK 2
-     */
-    public static boolean isSharedStateWellFormed(String sharedState) {
-        // FIXME Task 2
-        return false;
-    }
-
-    /**
-     * Given a playerState, determine if it is well-formed.
-     * Note: you don't have to consider validity for this task.
-     * A playerState is composed of individual playerStrings.
-     * A playerState is well-formed if it satisfies the following conditions.
-     * <p>
-     * A playerString follows this pattern: [player][score][mosaic][storage][floor]
-     * where [player], [score], [mosaic], [storage] and [floor] are replaced by
-     * a corresponding substring as described below.
-     * Each playerString is sorted by Player i.e. Player A appears before Player B.
-     * <p>
-     * 1. [player] The player substring is one character 'A' to 'D' -
-     * representing the Player
-     * <p>
-     * 2. [score] The score substring is one or more digits between '0' and '9' -
-     * representing the score
-     * <p>
-     * 3. [mosaic] The Mosaic substring begins with a 'M'
-     * Which is followed by *up to* 25 3-character strings.
-     * Each 3-character string is defined as follows:
-     * 1st character is 'a' to 'e' - representing the tile colour.
-     * 2nd character is '0' to '4' - representing the row.
-     * 3rd character is '0' to '4' - representing the column.
-     * The Mosaic substring is ordered first by row, then by column.
-     * That is, "a01" comes before "a10".
-     * <p>
-     * 4. [storage] The Storage substring begins with an 'S'
-     * and is followed by *up to* 5 3-character strings.
-     * Each 3-character string is defined as follows:
-     * 1st character is '0' to '4' - representing the row - each row number must only appear once.
-     * 2nd character is 'a' to 'e' - representing the tile colour.
-     * 3rd character is '0' to '5' - representing the number of tiles stored in that row.
-     * Each 3-character string is ordered by row number.
-     * <p>
-     * 5. [floor] The Floor substring begins with an 'F'
-     * and is followed by *up to* 7 characters in alphabetical order.
-     * Each character is 'a' to 'f' - where 'f' represents the first player token.
-     * There is only one first player token.
-     * <p>
-     * An entire playerState for 2 players might look like this:
-     * "A20Ma02a13b00e42S2a13e44a1FaabbeB30Mc01b11d21S0e12b2F"
-     * If we split player A's string into its substrings, we get:
-     * [A][20][Ma02a13b00e42][S2a13e44a1][Faabbe].
-     *
-     * @param playerState the player state string
-     * @return True if the playerState is well-formed,
-     * false if the playerState is not well-formed
-     * TASK 3
-     */
-    public static boolean isPlayerStateWellFormed(String playerState) {
-        // FIXME Task 3
-        return false;
-    }
-
-    /**
-     * Given the gameState, draw a *random* tile from the bag.
-     * If the bag is empty, refill the the bag with the discard pile and then draw a tile.
-     * If the discard pile is also empty, return 'Z'.
-     *
-     * @param gameState the current game state
-     * @return the tile drawn from the bag, or 'Z' if the bag and discard pile are empty.
-     * TASK 5
-     */
-    public static char drawTileFromBag(String[] gameState) {
-        // FIXME Task 5
-        return '0';
-    }
-
-    /**
-     * Given a state, refill the factories with tiles.
-     * If the factories are not all empty, return the given state.
-     *
-     * @param gameState the state of the game.
-     * @return the updated state after the factories have been filled or
-     * the given state if not all factories are empty.
-     * TASK 6
-     */
-    public static String[] refillFactories(String[] gameState) {
-        // FIXME Task 6
-        return null;
-    }
-
-    /**
-     * Given a gameState for a completed game,
-     * return bonus points for rows, columns, and sets.
-     *
-     * @param gameState a completed game state
-     * @param player    the player for whom the score is to be returned
-     * @return the number of bonus points awarded to this player for rows,
-     * columns, and sets
-     * TASK 7
-     */
-    public static int getBonusPoints(String[] gameState, char player) {
-        // FIXME Task 7
-        return -1;
-    }
-
-    /**
-     * Given a valid gameState prepare for the next round.
-     * 1. Empty the floor area for each player and adjust their score accordingly (see the README).
-     * 2. Refill the factories from the bag.
-     * * If the bag is empty, refill the bag from the discard pile and then
-     * (continue to) refill the factories.
-     * * If the bag and discard pile do not contain enough tiles to fill all
-     * the factories, fill as many as possible.
-     * * If the factories and centre contain tiles other than the first player
-     * token, return the current state.
-     *
-     * @param gameState the game state
-     * @return the state for the next round.
-     * TASK 8
-     */
-    public static String[] nextRound(String[] gameState) {
-        // FIXME TASK 8
-        return null;
-    }
-
-    /**
-     * Given an entire game State, determine whether the state is valid.
-     * A game state is valid if it satisfies the following conditions.
-     * <p>
-     * [General]
-     * 1. The game state is well-formed.
-     * 2. There are no more than 20 of each colour of tile across all player
-     * areas, factories, bag and discard
-     * 3. Exactly one first player token 'f' must be present across all player
-     * boards and the centre.
-     * <p>
-     * [Mosaic]
-     * 1. No two tiles occupy the same location on a single player's mosaic.
-     * 2. Each row contains only 1 of each colour of tile.
-     * 3. Each column contains only 1 of each colour of tile.
-     * [Storage]
-     * 1. The maximum number of tiles stored in a row must not exceed (row_number + 1).
-     * 2. The colour of tile stored in a row must not be the same as a colour
-     * already found in the corresponding row of the mosaic.
-     * <p>
-     * [Floor]
-     * 1. There are no more than 7 tiles on a single player's floor.
-     * [Centre]
-     * 1. The number of tiles in the centre is no greater than 3 * the number of empty factories.
-     * [Factories]
-     * 1. At most one factory has less than 4, but greater than 0 tiles.
-     * Any factories with factory number greater than this factory must contain 0 tiles.
-     *
-     * @param gameState array of strings representing the game state.
-     *                  state[0] = sharedState
-     *                  state[1] = playerStates
-     * @return true if the state is valid, false if it is invalid.
-     * TASK 9
-     */
-    public static boolean isStateValid(String[] gameState) {
-        // FIXME Task 9
-        return false;
-    }
-
-    /**
-     * Given a valid gameState and a move, determine whether the move is valid.
-     * A Drafting move is a 4-character String.
-     * A Drafting move is valid if it satisfies the following conditions:
-     * <p>
-     * 1. The specified factory/centre contains at least one tile of the specified colour.
-     * 2. The storage row the tile is being placed in does not already contain a different colour.
-     * 3. The corresponding mosaic row does not already contain a tile of that colour.
-     * Note that the tile may be placed on the floor.
-     * </p>
-     * <p>
-     * A Tiling move is a 3-character String.
-     * A Tiling move is valid if it satisfies the following conditions:
-     * 1. The specified row in the Storage area is full.
-     * 2. The specified column does not already contain a tile of the same colour.
-     * 3. The specified location in the mosaic is empty.
-     * 4. If the specified column is 'F', no valid move exists from the
-     * specified row into the mosaic.
-     * </p>
-     *
-     * @param gameState the game state.
-     * @param move      A string representing a move.
-     * @return true if the move is valid, false if it is invalid.
-     * TASK 10
-     */
-    public static boolean isMoveValid(String[] gameState, String move) {
-        // FIXME Task 10
-        return false;
-    }
-
-    /**
-     * Given a gameState and a move, apply the move to the gameState.
-     * If the move is a Tiling move, you must also update the player's score.
-     * If the move is a Tiling move, you must also empty the remaining tiles
-     * into the discard.
-     * If the move is a Drafting move, you must also move any remaining tiles
-     * from the specified factory into the centre.
-     * If the move is a Drafting move and you must put tiles onto the floor,
-     * any tiles that cannot fit on the floor are placed in the discard with
-     * the following exception:
-     * If the first player tile would be placed into the discard, it is instead
-     * swapped with the last tile in the floor, when the floor is sorted
-     * alphabetically.
-     *
-     * @param gameState the game state.
-     * @param move      A string representing a move.
-     * @return the updated gameState after the move has been applied.
-     * TASK 11
-     */
-    public static String[] applyMove(String[] gameState, String move) {
-        // FIXME Task 11
-        return null;
-    }
-
-    /**
-     * Given a valid game state, return a valid move.
-     *
-     * @param gameState the game state
-     * @return a move for the current game state.
-     * TASK 13
-     */
-    public static String generateAction(String[] gameState) {
-        // FIXME Task 13
-        return null;
-        // FIXME Task 15 Implement a "smart" generateAction()
-    }
-}
+package comp1110.ass2;
+
+import java.util.*;
+import java.util.regex.Matcher;
+import java.util.regex.Pattern;
+
+public class Azul {
+    /**
+     * Given a shared state string, determine if it is well-formed.
+     * Note: you don't need to consider validity for this task.
+     * A sharedState is well-formed if it satisfies the following conditions.
+     * <p>
+     * [turn][factories][centre][bag][discard]
+     * where [turn][factories], [centre], [bag] and [discard] are replaced by the
+     * corresponding small string as described below.
+     * <p>
+     * 0. [turn] The Turn substring is one character 'A'-'D' representing a
+     * player, which indicates that it is this player's turn to make the next
+     * drafting move. (In a two-player game, the turn substring can only take
+     * the values 'A' or 'B').
+     * <p>
+     * 1. [factories] The factories substring begins with an 'F'
+     * and is followed by a collection of *up to* 5 5-character factory strings
+     * representing each factory.
+     * Each factory string is defined in the following way:
+     * 1st character is a sequential digit '0' to '4' - representing the
+     * factory number.
+     * 2nd - 5th characters are 'a' to 'e', alphabetically - representing
+     * the tiles.
+     * A factory may have between 0 and 4 tiles. If a factory has 0 tiles,
+     * it does not appear in the factories string.
+     * Factory strings are ordered by factory number.
+     * For example: given the string "F1aabc2abbb4ddee": Factory 1 has tiles
+     * 'aabc', Factory 2 has tiles 'abbb', Factory 4 has tiles 'ddee', and
+     * Factories 0 and 4 are empty.
+     * <p>
+     * 2. [centre] The centre substring starts with a 'C'
+     * This is followed by *up to* 15 characters.
+     * Each character is 'a' to 'e', alphabetically - representing a tile
+     * in the centre.
+     * The centre string is sorted alphabetically.
+     * For example: "Caaabcdde" The Centre contains three 'a' tiles, one 'b'
+     * tile, one 'c' tile, two 'd' tile and one 'e' tile.
+     * <p>
+     * 3. [bag] The bag substring starts with a 'B'
+     * and is followed by 5 2-character substrings
+     * 1st substring represents the number of 'a' tiles, from 0 - 20.
+     * 2nd substring represents the number of 'b' tiles, from 0 - 20.
+     * 3rd substring represents the number of 'c' tiles, from 0 - 20.
+     * 4th substring represents the number of 'd' tiles, from 0 - 20.
+     * 5th substring represents the number of 'e' tiles, from 0 - 20.
+     * <p>
+     * For example: "B0005201020" The bag contains zero 'a' tiles, five 'b'
+     * tiles, twenty 'c' tiles, ten 'd' tiles and twenty 'e' tiles.
+     * 4. [discard] The discard substring starts with a 'D'
+     * and is followed by 5 2-character substrings defined the same as the
+     * bag substring.
+     * For example: "D0005201020" The bag contains zero 'a' tiles, five 'b'
+     * tiles, twenty 'c' tiles, ten 'd' tiles, and twenty 'e' tiles.
+     *
+     * @param sharedState the shared state - factories, bag and discard.
+     * @return true if sharedState is well-formed, otherwise return false
+     * TASK 2
+     */
+
+    /**
+     * @Author: Xuanchen Wang
+     */
+
+    public static boolean isSharedStateWellFormed(String sharedState) {
+        // FIXME Task 2
+        String reg = "[A-D]F([0-4][a-e]{4}){0,5}C[a-f]*B([0-2][0-9]){5}D([0-2][0-9]){5}$";
+        if (sharedState.matches(reg)) {
+            Pattern p = Pattern.compile("F(([0-4][a-e]{4}){0,5})C([a-f]*)");
+            Matcher m = p.matcher(sharedState);
+            while (m.find()) {
+                String m1 = m.group(1);      //the factory part
+                for (int i = 0; i < m1.length(); i += 5) {
+                    //if the tile in every factory is not 4, return false
+                    if (m1.charAt(i) > 96) {
+                        return false;
+                    }
+                    for (int j = 1; j < 4; j++) {
+                        //if the tile is not in alphabetical order, return false
+                        if (m1.charAt(i + j) > m1.charAt(i + j + 1)) {
+                            return false;
+                        }
+                    }
+
+                }
+                String m3 = m.group(3);     //the centre part
+                //if the centre is not empty
+                if (!m3.equals("")) {
+                    for (int i = 0; i < m.end(3) - m.start(3) - 1; i++) {
+                        //if the tile is not in alphabetical order, return false
+                        if (m3.charAt(i) > m3.charAt(i + 1)) {
+                            return false;
+                        }
+                    }
+
+                }
+
+            }
+            return true;
+        } else {
+            return false;
+        }
+    }
+
+    /**
+     * Given a playerState, determine if it is well-formed.
+     * Note: you don't have to consider validity for this task.
+     * A playerState is composed of individual playerStrings.
+     * A playerState is well-formed if it satisfies the following conditions.
+     * <p>
+     * A playerString follows this pattern: [player][score][mosaic][storage][floor]
+     * where [player], [score], [mosaic], [storage] and [floor] are replaced by
+     * a corresponding substring as described below.
+     * Each playerString is sorted by Player i.e. Player A appears before Player B.
+     * <p>
+     * 1. [player] The player substring is one character 'A' to 'D' -
+     * representing the Player
+     * <p>
+     * 2. [score] The score substring is one or more digits between '0' and '9' -
+     * representing the score
+     * <p>
+     * 3. [mosaic] The Mosaic substring begins with a 'M'
+     * Which is followed by *up to* 25 3-character strings.
+     * Each 3-character string is defined as follows:
+     * 1st character is 'a' to 'e' - representing the tile colour.
+     * 2nd character is '0' to '4' - representing the row.
+     * 3rd character is '0' to '4' - representing the column.
+     * The Mosaic substring is ordered first by row, then by column.
+     * That is, "a01" comes before "a10".
+     * <p>
+     * 4. [storage] The Storage substring begins with an 'S'
+     * and is followed by *up to* 5 3-character strings.
+     * Each 3-character string is defined as follows:
+     * 1st character is '0' to '4' - representing the row - each row number must only appear once.
+     * 2nd character is 'a' to 'e' - representing the tile colour.
+     * 3rd character is '0' to '5' - representing the number of tiles stored in that row.
+     * Each 3-character string is ordered by row number.
+     * <p>
+     * 5. [floor] The Floor substring begins with an 'F'
+     * and is followed by *up to* 7 characters in alphabetical order.
+     * Each character is 'a' to 'f' - where 'f' represents the first player token.
+     * There is only one first player token.
+     * <p>
+     * An entire playerState for 2 players might look like this:
+     * "A20Ma02a13b00e42S2a13e44a1FaabbeB30Mc01b11d21S0e12b2F"
+     * If we split player A's string into its substrings, we get:
+     * [A][20][Ma02a13b00e42][S2a13e44a1][Faabbe].
+     *
+     * @param playerState the player state string
+     * @return True if the playerState is well-formed,
+     * false if the playerState is not well-formed
+     * TASK 3
+     */
+
+    /**
+     * @Author: Xuanchen Wang
+     */
+
+    public static boolean isPlayerStateWellFormed(String playerState) {
+        // FIXME Task 3
+        //Creat a  StringBuider to build the mosaic part of the reg
+        StringBuilder M = new StringBuilder("M");
+        for (int i = 0; i < 5; i++) {
+            for (int j = 0; j < 5; j++) {
+                String tmp = "([a-e]" + i + j + ")?";
+                M.append(tmp);
+            }
+        }
+        //Creat a StringBuilder to build the storage part of the reg
+        StringBuilder S = new StringBuilder("S");
+        for (int i = 0; i < 5; i++) {
+            String tmp = "(" + i + "[a-e][0-5])?";
+            S.append(tmp);
+        }
+        //Creat a StringBuilder to build the floor part of the reg
+        StringBuilder F = new StringBuilder("F");
+        for (int i = 97; i < 102; i++) {
+            String tmp = "(" + Character.toString(i) + ")*";
+            F.append(tmp);
+
+        }
+        F.append("f?");
+        //Build the reg
+        String reg = "([A-D][0-9]+" + M.toString() + S.toString() + F.toString() + ")+$";
+        return playerState.matches(reg);
+    }
+
+    /**
+     * Given the gameState, draw a *random* tile from the bag.
+     * If the bag is empty, refill the the bag with the discard pile and then draw a tile.
+     * If the discard pile is also empty, return 'Z'.
+     *
+     * @param gameState the current game state
+     * @return the tile drawn from the bag, or 'Z' if the bag and discard pile are empty.
+     * TASK 5
+     */
+
+    /**
+     * @Author: Xuanchen Wang
+     */
+
+    public static char drawTileFromBag(String[] gameState) {
+        // FIXME Task 5
+        List<Character> list = new ArrayList<>();//a list to store all the tiles
+        String sharedstate = gameState[0];
+        /*
+         * get the tiles and add them to the list
+         * */
+        String reg = "B([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})D";
+        //if the bag is empty, refill the bag with tiles in discard
+        Pattern p = Pattern.compile("B0000000000D");
+        Matcher m = p.matcher(sharedstate);
+        if (m.find()) {
+            String reg1 = "D(\\d+)";
+            Pattern pa1 = Pattern.compile(reg1);
+            Matcher ma = pa1.matcher(sharedstate);
+            while (ma.find()) {
+                //if the discard is empty, return Z
+                if (ma.group(1).equals("0000000000")) {
+                    return 'Z';
+                }
+                //refill the bag with tiles in discard
+                sharedstate = sharedstate.replaceAll("0000000000", ma.group(1));
+                sharedstate = sharedstate.replaceAll("D\\d+", "D0000000000");
+            }
+        }
+        //add the tile to the list
+        Pattern pa = Pattern.compile(reg);
+        Matcher matcher = pa.matcher(sharedstate);
+        while (matcher.find()) {
+            for (int i = 97; i < 102; i++) {
+                int num = Integer.parseInt(matcher.group(i - 96));
+                for (int j = 0; j < num; j++) {
+                    char tmp = (char) i;
+                    list.add(tmp);
+                }
+            }
+        }
+        /*
+         * Randomly select a tile
+         * */
+        Random r = new Random();
+        return list.get(r.nextInt(list.size()));
+
+
+    }
+
+    /**
+     * Given a state, refill the factories with tiles.
+     * If the factories are not all empty, return the given state.
+     *
+     * @param gameState the state of the game.
+     * @return the updated state after the factories have been filled or
+     * the given state if not all factories are empty.
+     * TASK 6
+     */
+
+    /**
+     * @Author: Wangyi Li
+     */
+
+    public static String[] refillFactories(String[] gameState) {
+        // FIXME Task 6
+        String sharedState = gameState[0];
+
+        // If the factories are all empty, refill the factories with tiles
+        Pattern p = Pattern.compile("FC(f)?B");
+        Matcher m = p.matcher(sharedState);
+        if (m.find()) {
+            Pattern p1 = Pattern.compile("B0000000000D");
+            Matcher m1 = p1.matcher(sharedState);
+            if (m1.find()) {
+                String reg1 = "D(([0-2][0-9]){5})";
+
+                Pattern pa1 = Pattern.compile(reg1);
+                Matcher ma = pa1.matcher(sharedState);
+                while(ma.find()){
+                    if(ma.group(1).equals("0000000000")){ // ma.group(1)：Bag中的数据
+                        return gameState;
+                    }
+                    sharedState = sharedState.replaceAll("0000000000", ma.group(1));
+                    sharedState = sharedState.replaceAll("D(([0-2][0-9]){5})","D0000000000"); // \\d：任意数字
+                }
+            }
+            // refill the factories with tiles
+            StringBuilder F = new StringBuilder("F");
+            for (int i = 0; i < 5; i++) {
+                F.append(i);
+                for (int j = 0; j < 4; j++) {
+                    F.append(drawTileFromBag(gameState));
+                }
+            }
+            String f = F.toString();
+            gameState[0] = sharedState.replaceAll("F", f);
+
+            // count the number of tiles take from Bag
+            int num_A = 0;
+            int num_B = 0;
+            int num_C = 0;
+            int num_D = 0;
+            int num_E = 0;
+            for (int i = 1; i < f.length(); i++) {
+                switch (f.charAt(i)) {
+                    case 'a' :
+                        num_A++;
+                        break;
+                    case 'b' :
+                        num_B++;
+                        break;
+                    case 'c' :
+                        num_C++;
+                        break;
+                    case 'd' :
+                        num_D++;
+                        break;
+                    case 'e' :
+                        num_E++;
+                        break;
+                    default:
+                }
+            }
+            // update the Bag
+            String reg = "B([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})";
+            Pattern pa = Pattern.compile(reg);
+            Matcher matcher = pa.matcher(sharedState);
+            int num[] = new int[5];
+            while (matcher.find()) {
+                for (int i = 0; i < 5; i++) {
+                    num[i] = Integer.parseInt(matcher.group(i+1));
+                }
+                num[0] -= num_A;
+                num[1] -= num_B;
+                num[2] -= num_C;
+                num[3] -= num_D;
+                num[4] -= num_E;
+            }
+            StringBuilder B = new StringBuilder("B");
+            for (int i = 0; i < 5; i++) {
+                B.append(String.format("%02d", num[i]));
+            }
+            String b = B.toString();
+            gameState[0] = gameState[0].replaceAll("B([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})", b);
+
+            return gameState;
+        }
+        // If the factories are not all empty, return the given state.
+        return gameState;
+    }
+
+    /**
+     * Given a gameState for a completed game,
+     * return bonus points for rows, columns, and sets.
+     *
+     * @param gameState a completed game state
+     * @param player    the player for whom the score is to be returned
+     * @return the number of bonus points awarded to this player for rows,
+     * columns, and sets
+     * TASK 7
+     */
+
+    /**
+     * @Author: Wangyi Li
+     */
+
+    public static int getBonusPoints(String[] gameState, char player) {
+        // FIXME Task 7
+        String playerState = gameState[1];
+
+        String reg = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})";
+        Pattern p = Pattern.compile(reg); // 获取到正则表达式 reg：
+        Matcher m = p.matcher(playerState);
+
+        m.find();
+        String a = m.group(1); // situation of mosaic
+
+        String reg1 = "(\\d){2}";
+        Pattern p1 = Pattern.compile(reg1);
+        Matcher m1 = p1.matcher(a);
+
+        // bonus points for rows and columns
+        int sum_r = 0;
+        int sum_c = 0;
+        int[] counter1 = {0,0,0,0,0};
+        int[] counter2 = {0,0,0,0,0};
+        while (m1.find()) {
+            int x1 = Integer.parseInt(m1.group())/10; // rows
+            int x2 = Integer.parseInt(m1.group())%10; // columns
+
+            switch (x1) {
+                case 0:
+                    counter1[0]++;
+                    break;
+                case 1:
+                    counter1[1]++;
+                    break;
+                case 2:
+                    counter1[2]++;
+                    break;
+                case 3:
+                    counter1[3]++;
+                    break;
+                case 4:
+                    counter1[4]++;
+                    break;
+                default:
+            }
+            switch (x2) {
+                case 0:
+                    counter2[0]++;
+                    break;
+                case 1:
+                    counter2[1]++;
+                    break;
+                case 2:
+                    counter2[2]++;
+                    break;
+                case 3:
+                    counter2[3]++;
+                    break;
+                case 4:
+                    counter2[4]++;
+                    break;
+                default:
+            }
+        }
+        for (int k : counter1) {
+            if (k == 5) {
+                sum_r += 2;
+            }
+        }
+        for (int j : counter2) {
+            if (j == 5) {
+                sum_c += 7;
+            }
+        }
+
+        // bonus points for sets.
+        String reg2 = "[a-e]";
+        Pattern p2 = Pattern.compile(reg2);
+        Matcher m2 = p2.matcher(a);
+
+        int sum_s = 0;
+        int[] counter = {0,0,0,0,0};
+        while (m2.find()) {
+            switch (m2.group()) {
+                case "a":
+                    counter[0]++;
+                    break;
+                case "b":
+                    counter[1]++;
+                    break;
+                case "c":
+                    counter[2]++;
+                    break;
+                case "d":
+                    counter[3]++;
+                    break;
+                case "e":
+                    counter[4]++;
+                    break;
+                default:
+            }
+        }
+        for (int j : counter) {
+            if (j == 5) {
+                sum_s += 10;
+            }
+        }
+        return sum_r + sum_c + sum_s;
+    }
+
+    /**
+     * Given a valid gameState prepare for the next round.
+     * 1. Empty the floor area for each player and adjust their score accordingly (see the README).
+     * 2. Refill the factories from the bag.
+     * * If the bag is empty, refill the bag from the discard pile and then
+     * (continue to) refill the factories.
+     * * If the bag and discard pile do not contain enough tiles to fill all
+     * the factories, fill as many as possible.
+     * * If the factories and centre contain tiles other than the first player
+     * token, return the current state.
+     *
+     * @param gameState the game state
+     * @return the state for the next round.
+     * TASK 8
+     */
+    /**
+     * @Author: Zixin Feng
+     */
+    public static String[] nextRound(String[] gameState) {
+        // FIXME TASK 8
+            String sharedState = gameState[0].substring(0);
+            String playerState = gameState[1].substring(0);
+            String[] result = {sharedState, playerState};
+            boolean isStorageFull = false;
+            boolean isEndOfGame = false;
+            Map<Integer, Integer> rows = new HashMap<>(); //a map to store the number of tile in each row in mosaic
+            /*
+             * If the factories and centre contain tiles other than the first player
+             * token, return the current state
+             * */
+            Pattern p = Pattern.compile("Cf?B");
+            Matcher m = p.matcher(sharedState);
+            String refilledFactory = refillFactories(result)[0]; //refill the factory
+            /*
+             *  if one of the rows in the storage area is full
+             * */
+            Pattern ps = Pattern.compile("S(([0-4][a-e][1-5])*)F");
+            Matcher ms = ps.matcher(playerState);
+            while (ms.find()) {
+                for (int i = 0; i < ms.group(1).length(); i += 3) {
+                    int rowIndex = Integer.parseInt(Character.toString(ms.group(1).charAt(i)));
+                    int tilenumber = Integer.parseInt(Character.toString(ms.group(1).charAt(i + 2)));
+                    if (tilenumber == rowIndex + 1) {
+                        isStorageFull = true;
+                        break;
+                    }
+                }
+            }
+            /*
+             * If one of the row in mosaic is full
+             * */
+            Pattern pm = Pattern.compile("M(([a-e][0-4][0-4])*)S");
+            Matcher mm = pm.matcher(playerState);
+            while (mm.find()) {
+                for (int i = 0; i < 5; i++) {
+                    rows.put(i, 0);
+                }
+                for (int i = 1; i < mm.group(1).length(); i += 3) {
+                    int tmp = Integer.parseInt(Character.toString(mm.group(1).charAt(i)));
+                    rows.put(tmp, rows.get(tmp) + 1);
+                }
+                for (int tmp : rows.values()) {
+                    if (tmp == 5) {
+                        isEndOfGame = true;
+                    }
+                }
+            }
+
+
+            if (!m.find() || sharedState.equals(refilledFactory) || isStorageFull) {
+                return gameState;
+            }
+            if (isEndOfGame) {
+                Pattern p1 = Pattern.compile("F([a-f]*)");
+                Matcher m1 = p1.matcher(playerState);
+                Map<Character, Integer> tiles = new HashMap<>();
+                for (char c = 'a'; c < 'g'; c++) {
+                    tiles.put(c, 0);
+                }
+                /*
+                 * get the tiles from floor
+                 * */
+                while (m1.find()) {
+                    for (int i = 0; i < m1.group(1).length(); i++) {
+                        char tile = m1.group(1).charAt(i);
+                        tiles.put(tile, tiles.get(tile) + 1);
+                    }
+                }
+                tiles.remove('f');
+                Pattern pd = Pattern.compile("D(\\d*)");
+                Matcher md = pd.matcher(sharedState);
+                StringBuilder discard = new StringBuilder("D");
+                while (md.find()) {
+                    int counter = 0;
+                    for (int i = 0; i < md.group(1).length(); i += 2) {
+                        int number = Integer.parseInt(md.group(1).substring(i, i + 2));
+                        number += tiles.get((char) (counter + 97));
+                        if (number < 10) {
+                            discard.append(0);
+                        }
+                        discard.append(number);
+                        counter++;
+                    }
+                }
+                sharedState = sharedState.replaceAll("D\\d*", discard.toString());
+                sharedState = sharedState.replace("C", "Cf");
+                result[0] = sharedState;
+                return calculatePoints(isEndOfGame, playerState, result);
+            }
+
+            if (refilledFactory.startsWith("A")) {
+                Pattern pf = Pattern.compile("F([a-f]*)B");
+                Matcher mf = pf.matcher(playerState);
+                while (mf.find()) {
+                    if (!mf.group(1).endsWith("f")) {
+                        refilledFactory = refilledFactory.replaceFirst("^A", "B");
+                    }
+                }
+            } else if (!playerState.endsWith("f")) {
+                refilledFactory = refilledFactory.replaceFirst("^B", "A");
+            }
+            result[0] = refilledFactory;
+
+            return calculatePoints(isEndOfGame, playerState, result);
+        }
+
+    private static String[] calculatePoints(boolean isEndOfGame, String playerState, String[] result) {
+        /*
+         * update the state of player1
+         * */
+        int number = 0; //the number of tiles in floor
+        Pattern p1 = Pattern.compile("F([a-f]*)B");
+        Matcher m1 = p1.matcher(playerState);
+        while (m1.find()) {
+            number = m1.end(1) - m1.start(1);
+        }
+        playerState = playerState.replaceAll("F[a-f]*B", "FB"); //empty the floor
+        int penalty = 0;
+        // calculate the penalty
+        switch (number) {
+            case 0 -> penalty -= 0;
+            case 1 -> penalty -= 1;
+            case 2 -> penalty -= 2;
+            case 3 -> penalty -= 4;
+            case 4 -> penalty -= 6;
+            case 5 -> penalty -= 8;
+            case 6 -> penalty -= 11;
+            default -> penalty -= 14;
+        }
+        //update the score
+        Pattern p2 = Pattern.compile("A(\\d*)M");
+        Matcher m2 = p2.matcher(playerState);
+        while (m2.find()) {
+            int score = Integer.parseInt(m2.group(1));
+            score += penalty;
+            if (score < 0) {
+                score = 0;
+            }
+            if (isEndOfGame) {
+                score += getBonusPoints(result, 'A');
+            }
+            playerState = playerState.replaceAll("A\\d*M", "A" + score + "M");
+        }
+        result[1] = playerState;
+
+        /*
+         * update the state of player2
+         * */
+        number = 0; //the number of tiles in floor
+        Pattern p3 = Pattern.compile("F([a-f]*)$");
+        Matcher m3 = p3.matcher(playerState);
+        while (m3.find()) {
+            number = m3.end(1) - m3.start(1);
+        }
+        playerState = playerState.replaceAll("F[a-f]*$", "F"); //empty the floor
+        penalty = 0;
+        // calculate the penalty
+        switch (number) {
+            case 0 -> penalty -= 0;
+            case 1 -> penalty -= 1;
+            case 2 -> penalty -= 2;
+            case 3 -> penalty -= 4;
+            case 4 -> penalty -= 6;
+            case 5 -> penalty -= 8;
+            case 6 -> penalty -= 11;
+            default -> penalty -= 14;
+        }
+        //update the score
+        Pattern p4 = Pattern.compile("B(\\d*)M");
+        Matcher m4 = p4.matcher(playerState);
+        while (m4.find()) {
+            int score = Integer.parseInt(m4.group(1));
+            score += penalty;
+            if (score < 0) {
+                score = 0;
+            }
+            if (isEndOfGame) {
+                score += getBonusPoints(result, 'B');
+            }
+            playerState = playerState.replaceAll("B\\d*M", "B" + score + "M");
+        }
+        result[1] = playerState;
+
+        return result;
+    }
+
+    /**
+     * Given an entire game State, determine whether the state is valid.
+     * A game state is valid if it satisfies the following conditions.
+     * <p>
+     * [General]
+     * 1. The game state is well-formed.
+     * 2. There are no more than 20 of each colour of tile across all player
+     * areas, factories, bag and discard
+     * 3. Exactly one first player token 'f' must be present across all player
+     * boards and the centre.
+     * <p>
+     * [Mosaic]
+     * 1. No two tiles occupy the same location on a single player's mosaic.
+     * 2. Each row contains only 1 of each colour of tile.
+     * 3. Each column contains only 1 of each colour of tile.
+     * [Storage]
+     * 1. The maximum number of tiles stored in a row must not exceed (row_number + 1).
+     * 2. The colour of tile stored in a row must not be the same as a colour
+     * already found in the corresponding row of the mosaic.
+     * <p>
+     * [Floor]
+     * 1. There are no more than 7 tiles on a single player's floor.
+     * [Centre]
+     * 1. The number of tiles in the centre is no greater than 3 * the number of empty factories.
+     * [Factories]
+     * 1. At most one factory has less than 4, but greater than 0 tiles.
+     * Any factories with factory number greater than this factory must contain 0 tiles.
+     *
+     * @param gameState array of strings representing the game state.
+     *                  state[0] = sharedState
+     *                  state[1] = playerStates
+     * @return true if the state is valid, false if it is invalid.
+     * TASK 9
+     */
+
+    /**
+     * @Author: Zixin Feng + Wangyi Li
+     */
+
+    public static boolean isStateValid(String[] gameState) {
+        // The game state is well-formed.
+        if (!isSharedStateWellFormed(gameState[0])) {
+            return false;
+        }
+        if (!isPlayerStateWellFormed(gameState[1])) {
+            return false;
+        }
+
+        int factory_noEmpty_num = 0;
+        if (isSharedStateWellFormed(gameState[0])){
+
+            Pattern p = Pattern.compile("F(([0-4][a-e]{4}){0,5})C([a-f]*)B(([0-2][0-9]){5})D(([0-2][0-9]){5})");
+            Matcher m = p.matcher(gameState[0]);
+
+            int[] factory_tile_num = new int[5];
+            int[] center_title_num = new int[6];
+            while (m.find()){
+
+                System.out.println(m.group(0));
+                //factory
+                String factory_tile = m.group(1).replaceAll("\\d+","");
+                factory_noEmpty_num = m.group(1).length() / 5;
+                for(int i = 0; i < factory_tile.length(); i++){
+
+                    factory_tile_num[factory_tile.charAt(i)- 97]++;
+                }
+
+
+
+                Arrays.sort(factory_tile_num);
+
+                if (factory_tile_num[factory_tile_num.length - 1] > 20){
+                    System.out.println(1);
+                    return  false;
+                }
+
+                //center
+                String center_tile = m.group(3);
+                for(int i = 0; i < center_tile.length(); i++){
+
+                    center_title_num[center_tile.charAt(i)- 97]++;
+                }
+
+                Arrays.sort(center_title_num);
+
+                if (center_title_num[center_title_num.length - 1] > 20){
+                    System.out.println(2);
+                    return  false;
+                }
+
+                //bag
+                String bag_tile = m.group(4);
+                for (int i = 0; i <bag_tile.length() - 1; i+=2){
+
+                    if (((bag_tile.charAt(i) - '0') == 2 && (bag_tile.charAt(i + 1) - '0' > 0)) || ((bag_tile.charAt(i) - '0') > 2)){
+                        System.out.println(3);
+                        return false;
+
+                    }
+
+                }
+
+                //discard
+                String discard_tile = m.group(6);
+                for (int i = 0; i <discard_tile.length() - 1; i+=2){
+
+                    if (((discard_tile .charAt(i) - '0') == 2 && (discard_tile .charAt(i + 1) - '0' > 0)) || ((discard_tile .charAt(i) - '0') > 2)){
+                        System.out.println(4);
+                        return false;
+
+                    }
+
+                }
+
+
+            }
+
+        }
+
+        if (isPlayerStateWellFormed(gameState[1])){
+
+            String reg = "[A-D][0-9]{1,2}M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5]){0,5})F(([a-e]){0,7})C*(([a-e]){0,100})";
+            Pattern p = Pattern.compile(reg);
+
+            Matcher m = p.matcher(gameState[1]);
+
+
+
+            while (m.find()){
+
+                System.out.println(m.group(0));
+                // System.out.println(m.group(1));
+                //mosaic, No two tiles occupy the same location on a single player's mosaic
+                int length = m.group().length() / 3;
+
+                ArrayList<Integer> arrayList = new ArrayList<>();
+                Map<String, String> mosaic_map = new HashMap<>();
+
+                for(int i = 0; i < m.group(1).length() -1; i +=3){
+
+                    String a = m.group(1).charAt(i + 1) + ""  + m.group(1).charAt(i + 2)  + "";
+
+                    if (arrayList.contains(a)){
+                        System.out.println(5);
+                        return  false;
+                    }
+
+                    mosaic_map.put(m.group(1).charAt(i + 1) + "",m.group(1).charAt(i) + "");
+                    //  mosaic_list.add(m.group(1).charAt(i));
+
+                    arrayList.add(Integer.parseInt(a));
+
+                }
+
+                //Storage The maximum number of tiles stored in a row must not exceed (row_number + 1).
+                String Storage = m.group(3);
+                // System.out.println(Storage);
+                //Storage region colour is different than the colour in Moscia
+                // List<Character> color_list = new ArrayList<>();
+                for (int i = 0; i < Storage.length() - 1;i += 3){
+
+                    int row_num = Integer.parseInt(Storage.charAt(i) + "");
+                    int tile_num = Integer.parseInt(Storage.charAt(i + 2) + "");
+
+                    if (mosaic_map.get(Storage.charAt(i)+"") != null && mosaic_map.get(Storage.charAt(i)+"").equals(Storage.charAt(i + 1) + "")){
+                        System.out.println(6);
+                        // System.out.println(Storage.charAt(i + 1));
+                        return  false;
+                    }
+
+
+
+                    //add color to list
+                    //color_list.add(Storage.charAt(i + 1));
+
+                    //The colour of tile stored in a row must not be the same as a colour
+                    if (Storage.charAt(i + 1) < 97 || Storage.charAt(i + 1) > 122){
+                        System.out.println(7);
+                        // System.out.println(Storage.charAt(i) < 97);
+                        return false;
+                    }
+
+                    if (tile_num > row_num + 1){
+
+                        System.out.println(8);
+                        return  false;
+                    }
+
+
+                }
+
+                String floor = m.group(5);
+
+                //There are no more than 7 tiles on a single player's floor.
+                if (floor.length() >= 7){
+
+                    System.out.println(9);
+                    return  false;
+                }
+
+
+
+
+                String center = m.group(7);
+                //The number of tiles in the centre is no greater than 3 * the number of empty factories.
+                if (center.length() > 3 * (5 - factory_noEmpty_num))
+                {
+                    System.out.println(5 - factory_noEmpty_num);
+                    System.out.println(10);
+                    return false;
+                }
+
+
+            }
+        }
+
+        // The colour of tile stored in a row must not be the same as a colour already found in the corresponding row of the mosaic.
+        if (!isTilesAmountRight(gameState)) {
+            return false;
+        }
+
+        // The number of tiles in the centre is no greater than 3 * the number of empty v factories.
+        String reg1 = "F(([0-4][a-e]{4}){0,5})C([a-f]*)B(([0-2][0-9]){5})D(([0-2][0-9]){5})";
+        Pattern p1 = Pattern.compile(reg1);
+        Matcher m1 = p1.matcher(gameState[0]);
+        if (m1.find()) {
+            if (m1.group(3).contains("f")) { // center
+                if (m1.group(3).length() - 1 > 3* (5 - m1.group(1).length() / 5)) {
+                    System.out.println(m1.group(3).length());
+                    System.out.println(3* (5 - m1.group(1).length() / 5));
+                    return false;
+                }
+            } else {
+                if (m1.group(3).length() - 1 > 3* (5 - m1.group(1).length() / 5)) {
+                    System.out.println(m1.group(3).length());
+                    System.out.println(3* (5 - m1.group(1).length() / 5));
+                    return false;
+                }
+            }
+        }
+        return true;
+    }
+
+    public static boolean isTilesAmountRight (String[] gameState) {
+        int[] count = new int[5];
+
+        String test = "";
+        String reg1 = "F(([0-4][a-e]{4}){0,5})C([a-f]*)B(([0-2][0-9]){5})D(([0-2][0-9]){5})";
+        Pattern p1 = Pattern.compile(reg1);
+        Matcher m1 = p1.matcher(gameState[0]);
+        if (m1.find()) {
+            test = m1.group(1) + m1.group(3); // factory + center
+
+            // bag
+            String reg_b = "B([0-2][0-9])([0-2][0-9])([0-2][0-9])([0-2][0-9])([0-2][0-9])";
+            Pattern p_b = Pattern.compile(reg_b);
+            Matcher m_b = p_b.matcher(gameState[0]);
+            if (m_b.find()) {
+                count[0] += Integer.parseInt(m_b.group(1));
+                count[1] += Integer.parseInt(m_b.group(2));
+                count[2] += Integer.parseInt(m_b.group(3));
+                count[3] += Integer.parseInt(m_b.group(4));
+                count[4] += Integer.parseInt(m_b.group(5));
+            }
+
+            // discard
+            String reg_d = "D([0-2][0-9])([0-2][0-9])([0-2][0-9])([0-2][0-9])([0-2][0-9])";
+            Pattern p_d = Pattern.compile(reg_d);
+            Matcher m_d = p_d.matcher(gameState[0]);
+            if (m_d.find()) {
+                count[0] += Integer.parseInt(m_d.group(1));
+                count[1] += Integer.parseInt(m_d.group(2));
+                count[2] += Integer.parseInt(m_d.group(3));
+                count[3] += Integer.parseInt(m_d.group(4));
+                count[4] += Integer.parseInt(m_d.group(5));
+            }
+        }
+
+        String reg2 = "M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)F(f?([a-e])*)";
+        Pattern p2 = Pattern.compile(reg2);
+        Matcher m2 = p2.matcher(gameState[1]);
+        while (m2.find()) { // mosaic
+            String reg_m = "([a-e][0-4][0-4])";
+            Pattern p_m = Pattern.compile(reg_m);
+            Matcher m_m = p_m.matcher(m2.group(1));
+            while (m_m.find()) {
+                switch (m_m.group().charAt(0) - 97) {
+                    case 0:
+                        count[0]++;
+                        break;
+                    case 1:
+                        count[1]++;
+                        break;
+                    case 2:
+                        count[2]++;
+                        break;
+                    case 3:
+                        count[3]++;
+                        break;
+                    case 4:
+                        count[4]++;
+                        break;
+                }
+            }
+
+            String reg_s = "([0-4][a-e][0-5])";
+            Pattern p_s = Pattern.compile(reg_s);
+            Matcher m_s = p_s.matcher(m2.group(3));
+            while (m_s.find()) {
+                switch (m_s.group().charAt(1) - 97) {
+                    case 0:
+                        count[0] += Integer.parseInt("" + m_s.group().charAt(2));
+                        break;
+                    case 1:
+                        count[1] += Integer.parseInt("" + m_s.group().charAt(2));
+                        break;
+                    case 2:
+                        count[2] += Integer.parseInt("" + m_s.group().charAt(2));
+                        break;
+                    case 3:
+                        count[3] += Integer.parseInt("" + m_s.group().charAt(2));
+                        break;
+                    case 4:
+                        count[4] += Integer.parseInt("" + m_s.group().charAt(2));
+                        break;
+                }
+            }
+
+            test += m2.group(5); // floor
+        }
+
+        // count factory center & floor
+        for (int i = 0; i < test.length(); i++) {
+            switch (test.charAt(i) - 97) {
+                case 0:
+                    count[0]++;
+                    break;
+                case 1:
+                    count[1]++;
+                    break;
+                case 2:
+                    count[2]++;
+                    break;
+                case 3:
+                    count[3]++;
+                    break;
+                case 4:
+                    count[4]++;
+                    break;
+                default:
+                    break;
+            }
+        }
+        if (count[0] == 20 && count[1] == 20 && count[2] == 20 && count[3] == 20 && count[4] == 20) {
+            return true;
+        }
+        return false;
+    }
+
+    /**
+     * Given a valid gameState and a move, determine whether the move is valid.
+     * A Drafting move is a 4-character String.
+     * A Drafting move is valid if it satisfies the following conditions:
+     * <p>
+     * 1. The specified factory/centre contains at least one tile of the specified colour.
+     * 2. The storage row the tile is being placed in does not already contain a different colour.
+     * 3. The corresponding mosaic row does not already contain a tile of that colour.
+     * Note that the tile may be placed on the floor.
+     * </p>
+     * <p>
+     * A Tiling move is a 3-character String.
+     * A Tiling move is valid if it satisfies the following conditions:
+     * 1. The specified row in the Storage area is full.
+     * 2. The specified column does not already contain a tile of the same colour.
+     * 3. The specified location in the mosaic is empty.
+     * 4. If the specified column is 'F', no valid move exists from the
+     * specified row into the mosaic.
+     * </p>
+     *
+     * @param gameState the game state.
+     * @param move      A string representing a move.
+     * @return true if the move is valid, false if it is invalid.
+     * TASK 10
+     */
+
+    /**
+     * @Author: Wangyi Li
+     */
+
+    public static boolean isMoveValid(String[] gameState, String move) {
+        // FIXME Task 10
+        String sharedState = gameState[0];
+        String playerState = gameState[1];
+        if (sharedState.charAt(0) != move.charAt(0)){ // player validation
+            return false;
+        }
+        if (move.length() == 4) { // Drafting move: 4-character string
+            // 1. The specified factory/centre contains at least one tile of the specified colour.
+            String reg = "F(([0-4][a-e]{4}){0,5})C([a-f]*)";
+            Pattern p = Pattern.compile(reg);
+            Matcher m = p.matcher(sharedState);
+            String colourStr = move.charAt(2) + "";
+            if (m.find()) {
+                String center = m.group(3);
+                String factory = m.group(1);
+                if (move.charAt(1) == 'C') { // from center
+                    if (!center.contains(colourStr)) {
+                        return false;
+                    }
+                } else { // from factory
+                    String reg_f = move.charAt(1) + "[a-e]{4}";
+                    Pattern p_f = Pattern.compile(reg_f);
+                    Matcher m_f = p_f.matcher(factory);
+                    if (m_f.find()) {
+                        if (!m_f.group().contains(colourStr)) {
+                            return false;
+                        }
+                    }
+                }
+            }
+
+            // 2. The storage row the tile is being placed in does not already contain a different colour.
+            char player = move.charAt(0);
+            char colour = move.charAt(2);
+            char destination = move.charAt(3);
+
+            String reg1 = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)F(f?([a-e])*)";
+            Pattern p1 = Pattern.compile(reg1);
+            Matcher m1 = p1.matcher(playerState);
+            if (m1.find()) {
+                String storage = m1.group(3);
+                if (destination !='F') {
+                    String reg_s = destination + "[a-e][0-5]";
+                    Pattern p_s = Pattern.compile(reg_s);
+                    Matcher m_s = p_s.matcher(storage);
+                    if (m_s.find()) {
+                        String storageRow = m_s.group();
+                        if (storageRow.charAt(1) != colour) {
+                            return false;
+                        }
+                    }
+                }
+
+                // 3. The corresponding mosaic row does not already contain a tile of that colour.
+                String mosaic = m1.group(1);
+                String reg2 = "[a-e]" + move.charAt(3) +"[0-4]";
+                Pattern p2 = Pattern.compile(reg2);
+                Matcher m2 = p2.matcher(mosaic);
+                while (m2.find()) {
+                    if (m2.group().charAt(0) == colour) {
+                        return false;
+                    }
+                }
+
+                // full storage
+                String reg3 = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)";
+                Pattern p3 = Pattern.compile(reg3);
+                Matcher m3 = p3.matcher(playerState);
+                if (m3.find()) {
+                    String reg_s = "([0-4][a-e][0-5])";
+                    Pattern p_s = Pattern.compile(reg_s);
+                    Matcher m_s = p_s.matcher(m3.group(3));
+
+                    while (m_s.find()) {
+                        if (move.charAt(3) == m_s.group().charAt(0) && m_s.group().charAt(0)+1 == m_s.group().charAt(2)) {
+                             return false;
+                        }
+                    }
+                }
+
+            }
+
+        } else if (move.length() == 3) { // Tiling move: 3-character string
+
+            // 1. The specified row in the Storage area is full.
+            char player = move.charAt(0);
+            char storageRow = move.charAt(1);
+            char mosaicColumn = move.charAt(2);
+            char colour;
+
+            String reg1 = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)F(f?([a-e])*)";
+            Pattern p1 = Pattern.compile(reg1);
+            Matcher m1 = p1.matcher(playerState);
+            if (m1.find()) {
+                String storage = m1.group(3);
+                String reg_s = storageRow + "[a-e][0-5]";
+                Pattern p_s = Pattern.compile(reg_s);
+                Matcher m_s = p_s.matcher(storage);
+                if (m_s.find()) {
+                    int rowMax = (int)storageRow + 1;
+                    if (m_s.group().charAt(2) != (char)rowMax) { // not full
+                        return false;
+                    }
+                    colour = m_s.group().charAt(1);
+                } else {
+                    return false;
+                }
+
+                // 2. The specified column does not already contain a tile of the same colour.
+                String mosaic = m1.group(1);
+
+                String reg2 = "[a-e][0-4]" + mosaicColumn;
+                Pattern p2 = Pattern.compile(reg2);
+                Matcher m2 = p2.matcher(mosaic);
+                while (m2.find()) {
+                    if (m2.group().charAt(0) == colour) {
+                        return false;
+                    }
+                }
+
+                // 3. The specified location in the mosaic is empty.
+                String reg3 = "[a-e]" + storageRow + mosaicColumn;
+                Pattern p3 = Pattern.compile(reg3);
+                Matcher m3 = p3.matcher(mosaic);
+                if (m3.find()) {
+                    return false;
+                }
+
+                // 4. If the specified column is 'F', no valid move exists from the specified row into the mosaic.
+                if (move.charAt(2) == 'F') {
+                    List<Character> record = new ArrayList<>();
+
+                    // record the available column
+                    String reg4 = colour + "[0-4][0-4]";
+                    Pattern p4 = Pattern.compile(reg4);
+                    Matcher m4 = p4.matcher(mosaic);
+                    while (m4.find()) {
+                        record.add(m4.group().charAt(2));
+                    }
+
+                    // record the column which has been occupied
+                    String reg5 = "[a-e]" + storageRow + "[0-4]";
+                    Pattern p5 = Pattern.compile(reg5);
+                    Matcher m5 = p5.matcher(mosaic);
+                    while (m5.find()) {
+                        record.add(m5.group().charAt(2));
+                    }
+
+                    record.sort((o1, o2) -> o1 - o2);
+                    if (record.size() != 5) {
+                        return false;
+                    }
+                    for (int i = 0; i < record.size(); i++) {
+                        if ((int)record.get(i)-48 != i){
+                            return false;
+                        }
+                    }
+                }
+            }
+        }
+        return true;
+    }
+
+    /**
+     * Given a gameState and a move, apply the move to the gameState.
+     * If the move is a Tiling move, you must also update the player's score.
+     * If the move is a Tiling move, you must also empty the remaining tiles
+     * into the discard.
+     * If the move is a Drafting move, you must also move any remaining tiles
+     * from the specified factory into the centre.
+     * If the move is a Drafting move and you must put tiles onto the floor,
+     * any tiles that cannot fit on the floor are placed in the discard with
+     * the following exception:
+     * If the first player tile would be placed into the discard, it is instead
+     * swapped with the last tile in the floor, when the floor is sorted
+     * alphabetically.
+     *
+     * @param gameState the game state.
+     * @param move      A string representing a move.
+     * @return the updated gameState after the move has been applied.
+     * TASK 11
+     */
+
+    /**
+     * @Author: Wangyi Li
+     */
+
+    public static String[] applyMove(String[] gameState, String move) {
+        // FIXME Task 11
+        String sharedState = gameState[0];
+        String playerState = gameState[1];
+
+        if (move.length() == 4) { // Drafting move: 4-character string
+            char player = move.charAt(0);
+            char pickTileFrom = move.charAt(1); // from Factory/Center
+            char selectedColour = move.charAt(2);
+            char putTileTo = move.charAt(3); // to storageRow/Floor
+
+            String reg_c = "C[a-f]*";
+            Pattern p_c = Pattern.compile(reg_c);
+            Matcher m_c = p_c.matcher(sharedState);
+
+            int count = 0; // count for same colour will be taken
+            String updatedCenter = "";
+            boolean putOnFloor = false; // determine whether need to put on floor
+            List<Character> addToXList = new ArrayList<>(); // use on floor part
+
+            if (pickTileFrom == 'C') { // pick from center
+                if (m_c.find()){
+                    for (int i = 1; i < m_c.group().length(); i++) {
+                        if (m_c.group().charAt(i) == selectedColour) {
+                            count++;
+                        }
+                    }
+                    // generate addToXList
+                    for (int i = 0; i < count; i++) {
+                        addToXList.add(selectedColour);
+                    }
+                    if (m_c.group().contains("f")) { // the 1st one take tiles from center
+                        updatedCenter = m_c.group().replaceAll("" + selectedColour, "").replaceAll("f", "");
+                        // take f to the floor
+                        putOnFloor = true;
+                        addToXList.add('f');
+                    } else {
+                        updatedCenter = m_c.group().replaceAll("" + selectedColour, "");
+                    }
+                    gameState[0] = gameState[0].replaceAll("C[a-f]*", updatedCenter);
+
+                }
+            } else { // pick tiles from factory
+                String reg_f = pickTileFrom + "[a-e]{4}";
+                Pattern p_f = Pattern.compile(reg_f);
+                Matcher m_f = p_f.matcher(sharedState);
+                if (m_f.find()) {
+                    List<String> aFactory = new ArrayList<>();
+                    for (int i = 1; i < 5; i++) {
+                        if (m_f.group().charAt(i) == selectedColour) {
+                            count++;
+                        } else {
+                            aFactory.add("" + m_f.group().charAt(i));
+                        }
+                    }
+
+                    // // 1. move any remaining tiles from the specified factory into the centre.
+                    if (m_c.find()) {
+                        List<String> centerList = new ArrayList<>();
+                        for (int i = 1; i < m_c.group().length(); i++) {
+                            centerList.add("" + m_c.group().charAt(i));
+                        }
+                        centerList.addAll(aFactory);
+                        Collections.sort(centerList);
+                        centerList.add(0,"C");
+
+                        updatedCenter = "";
+                        for (int i = 0; i < centerList.size(); i++) {
+                            updatedCenter += centerList.get(i);
+                        }
+                    }
+                    gameState[0] = gameState[0].replaceAll("C[a-f]*", updatedCenter); // update center
+                    gameState[0] = gameState[0].replaceAll(m_f.group(), ""); // update factory
+
+                    // generate addToXList
+                    for (int i = 0; i < count; i++) {
+                        addToXList.add(selectedColour);
+                    }
+                }
+            }
+
+
+            String reg = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)F(f?([a-e])*)";
+            Pattern p = Pattern.compile(reg);
+            Matcher m = p.matcher(playerState);
+
+            // Discard part
+            String reg_d = "D([0-2][0-9])([0-2][0-9])([0-2][0-9])([0-2][0-9])([0-2][0-9])";
+            Pattern p_d = Pattern.compile(reg_d);
+            Matcher m_d = p_d.matcher(sharedState);
+
+            if (m.find()) {
+                if (putTileTo != 'F') { // from move string -put to storage
+                    int storageRow = putTileTo;
+                    List<String> storageList = new ArrayList<>();
+
+                    String reg_s1 = "[0-4][a-e][0-5]";
+                    Pattern p_s1 = Pattern.compile(reg_s1);
+                    Matcher m_s1 = p_s1.matcher(m.group(3));
+
+                    int currentNum = 0; // record current tile in the pointed row in storage
+                    boolean isEmpty = true;
+                    while (m_s1.find()) {
+                        storageList.add(m_s1.group());
+                        if (m_s1.group().charAt(0) == storageRow) {
+                            currentNum = m_s1.group().charAt(2) - 48;
+                            isEmpty = false; // the row is already have tiles
+                        }
+                    }
+                    // the remaining space in pointed row
+                    int availableSpace = (storageRow-48) - currentNum + 1;
+
+                    String updatedStorage = "S";
+                    String replacedRow = "";
+                    if (isEmpty) { // there is no tile in pointed row
+                        if (availableSpace < count) { // have overflow
+                            replacedRow = "" + (char)storageRow + selectedColour + (char)(storageRow+1);
+                            // should put excess part on floor
+                            putOnFloor = true;
+                            // delete the already put tiles
+                            for (int i = 0; i < availableSpace; i++) {
+                                addToXList.remove(0);
+                            }
+                        } else {
+                            replacedRow = "" + (char) storageRow + selectedColour + count;
+                            if (putOnFloor) { // if there is f taken from center
+                                for (int i = 0; i < count; i++) {
+                                    addToXList.remove(0);
+                                }
+                            }
+                        }
+                        storageList.add(replacedRow);
+                        Collections.sort(storageList);
+                    } else {
+                        int index = 0;
+                        int newNum = 0; // the current number of tiles + new tiles
+
+                        if (availableSpace == 0) { // the row is full
+                            putOnFloor = true; // put on floor
+                        } else if (availableSpace < count) { // have overflow
+                            for (int i = 0; i < storageList.size(); i++) {
+                                if (storageList.get(i).charAt(0) == storageRow) {
+                                    index = i;
+                                }
+                            }
+                            replacedRow = storageList.get(index).replaceAll("" + selectedColour + currentNum, "" + selectedColour + (storageRow-47));
+                            storageList.set(index, replacedRow);
+                            // put overflow on floor
+                            putOnFloor = true;
+                            for (int i = 0; i < availableSpace; i++) {
+                                addToXList.remove(0);
+                            }
+                        } else if (availableSpace >= count) { // enough to put on row
+                            for (int i = 0; i < storageList.size(); i++) {
+                                if (storageList.get(i).charAt(0) == storageRow) {
+                                    index = i;
+                                }
+                            }
+                            newNum= currentNum + count;
+                            replacedRow = storageList.get(index).replaceAll("" + selectedColour + currentNum, "" + selectedColour + newNum);
+                            storageList.set(index, replacedRow);
+                            // if there is f need to update to floor
+                            if (putOnFloor) {
+                                for (int i = 0; i < count; i++) {
+                                    addToXList.remove(0);
+                                }
+                            }
+                        }
+                    }
+
+                    for (int i = 0; i < storageList.size(); i++) {
+                        updatedStorage += storageList.get(i);
+                    }
+                    String reg2 = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})";
+                    Pattern p2 = Pattern.compile(reg2);
+                    Matcher m2 = p2.matcher(gameState[1]);
+                    if (m2.find()) {
+                        gameState[1] = gameState[1].replaceAll(player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)", m2.group() + updatedStorage);
+                    }
+                }
+
+
+                if (putTileTo == 'F' || putOnFloor) { // put on floor
+                    List<Character> floorList = new ArrayList<>();
+                    for (int i = 0; i < m.group(5).length(); i++) {
+                        floorList.add(m.group(5).charAt(i));
+                    }
+
+                    floorList.addAll(addToXList);
+                    int[] countByColour = new int[5];
+                    String updatedFloor = "F";
+                    // the tile is over 7 in floor
+                    if (floorList.size() > 7) {
+                        for (int i = 7; i < floorList.size(); i++) {
+                            if (floorList.get(i) == 'f') {
+                                char temp = floorList.get(6);
+                                floorList.set(6, 'f');
+                                floorList.set(i, temp);
+                            }
+                        }
+                        for (int i = 7; i < floorList.size(); i++) {
+                            System.out.println(floorList.get(i) - 97);
+                            switch (floorList.get(i) - 97) {
+                                case 0:
+                                    countByColour[0]++;
+                                    break;
+                                case 1:
+                                    countByColour[1]++;
+                                    break;
+                                case 2:
+                                    countByColour[2]++;
+                                    break;
+                                case 3:
+                                    countByColour[3]++;
+                                    break;
+                                case 4:
+                                    countByColour[4]++;
+                                    break;
+                            }
+                        }
+                        List<Integer> discardList = new ArrayList<>();
+                        while (m_d.find()) {
+                            for (int i = 1; i < 6; i++) {
+                                discardList.add(Integer.parseInt(m_d.group(i)));
+                            }
+                        }
+                        String updatedDiscard = "D";
+                        for (int i = 0; i < countByColour.length; i++) {
+                            if ((countByColour[i] + discardList.get(i)) < 10) {
+                                updatedDiscard += "0" + (countByColour[i] + discardList.get(i));
+                            } else {
+                                updatedDiscard += (countByColour[i] + discardList.get(i));
+                            }
+                        }
+                        gameState[0] = gameState[0].replaceAll("D([0-2][0-9]){5}", updatedDiscard);
+
+                        List<Character> updatedFloorList = new ArrayList<>();
+                        for (int i = 0; i < 7; i++) {
+                            updatedFloorList.add(i, floorList.get(i));
+                        }
+                        Collections.sort(updatedFloorList);
+                        for (int i = 0; i < updatedFloorList.size(); i++) {
+                            updatedFloor += updatedFloorList.get(i);
+                        }
+                    } else {
+                        Collections.sort(floorList);
+                        for (int i = 0; i < floorList.size(); i++) {
+                            updatedFloor += floorList.get(i);
+                        }
+                    }
+                    String reg1 = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)";
+                    Pattern p1 = Pattern.compile(reg1);
+                    Matcher m1 = p1.matcher(gameState[1]);
+                    if (m1.find()) {
+                        gameState[1] = gameState[1].replaceAll(player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)F(f?([a-e])*)", m1.group() + updatedFloor);
+                    }
+                }
+            }
+            if (!gameState[0].contains(player + "FCB")) {
+                char nextPlayer = 0;
+                if (player == 'A') {
+                    nextPlayer = 'B';
+                } else {
+                    nextPlayer = 'A';
+                }
+                gameState[0] = gameState[0].replaceAll("" + player + "F", "" + nextPlayer + "F");
+            }
+
+
+        } else if (move.length() == 3) { // Tiling move: 3-character string
+            char player = move.charAt(0);
+            char storageRow = move.charAt(1);
+            char mosaicColumn = move.charAt(2);
+
+            // the specified player
+            String reg1 = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)F(f?([a-e])*)"; // 截取当前玩家的状态
+            Pattern p1 = Pattern.compile(reg1);
+            Matcher m1 = p1.matcher(playerState);
+
+            if (m1.find()) {
+                String mosaic = m1.group(1);
+                String storage = m1.group(3);
+                // storageRow
+                String reg_s = storageRow + "[a-e][0-5]";
+                Pattern p_s = Pattern.compile(reg_s);
+                Matcher m_s = p_s.matcher(storage);
+                char colour = 0;
+                if (m_s.find()) {
+                    colour = m_s.group().charAt(1);
+                }
+
+                // scoring
+                int count = 0; // the total count of row and column score
+                if (m1.group(1).equals("")) {
+                    count = 1;
+                } else {
+                    String reg_r = storageRow + "[0-4]";
+                    Pattern p_r = Pattern.compile(reg_r);
+                    Matcher m_r = p_r.matcher(mosaic);
+
+                    List<Integer> row = new ArrayList<>();
+                    while (m_r.find()) {
+                        row.add(m_r.group().charAt(1) - 48);
+                    }
+                    // row
+                    int countRow = 1;
+                    for (int i = 1; mosaicColumn - 48 + i < 5; i++) {
+                        if (row.contains(mosaicColumn - 48 + i)) {
+                            countRow++;
+                        } else {
+                            break;
+                        }
+                    }
+                    for (int i = 1; mosaicColumn - 48 - i >= 0; i++) {
+                        if (row.contains(mosaicColumn - 48 - i)) {
+                            countRow++;
+                        } else {
+                            break;
+                        }
+                    }
+
+                    // column
+                    int countColumn = 1;
+                    String reg_c = "[0-4]" + mosaicColumn;
+                    Pattern p_c = Pattern.compile(reg_c);
+                    Matcher m_c = p_c.matcher(mosaic);
+
+                    List<Integer> column = new ArrayList<>();
+                    while (m_c.find()) {
+                        column.add(m_c.group().charAt(0) - 48);
+                    }
+                    for (int i = 1; storageRow - 48 + i < 5; i++) {
+                        if (column.contains(storageRow - 48 + i)) {
+                            countColumn++;
+                        } else {
+                            break;
+                        }
+                    }
+                    for (int i = 1; storageRow - 48 - i >= 0; i++) {
+                        if (column.contains(storageRow - 48 - i)) {
+                            countColumn++;
+                        } else {
+                            break;
+                        }
+                    }
+
+                    // total count
+                    if (countColumn == 1 && countRow == 1) {
+                        count = 1;
+                    } else if (countColumn == 1 || countRow == 1) {
+                        count = countColumn + countRow - 1;
+                    } else {
+                        count = countColumn + countRow;
+                    }
+                }
+
+                // update score
+                String reg = player + "([0-9]+)";
+                Pattern p = Pattern.compile(reg);
+                Matcher m = p.matcher(playerState);
+                int updateScore = 0;
+                if (m.find()) {
+                    int oriScore = Integer.parseInt(m.group(1)); // 读取以前的分数转化为
+                    updateScore = oriScore + count;
+                }
+
+
+                // mosaic
+                String reg2 = "[a-e][0-4][0-4]";
+                Pattern p2 = Pattern.compile(reg2);
+                Matcher m2 = p2.matcher(mosaic);
+                List<String> mosaicList = new ArrayList<>();
+                while (m2.find()) {
+                    mosaicList.add(m2.group());
+                }
+                String updateTile = "" + colour + storageRow + mosaicColumn;
+                mosaicList.add(updateTile);
+                Collections.sort(mosaicList, new Comparator<String>() {
+                    @Override
+                    public int compare(String o1, String o2) {
+                        String n1 = "" + o1.charAt(1) + o1.charAt(2);
+                        String n2 = "" + o2.charAt(1) + o2.charAt(2);
+                        if (Integer.parseInt(n1) < Integer.parseInt(n2)) {
+                            return -1;
+                        }
+                        return 1;
+                    }
+                });
+
+                String updatedMosaic = "M";
+                for (int i = 0; i < mosaicList.size(); i++) {
+                    updatedMosaic += mosaicList.get(i);
+                }
+
+                // 2. If the move is a Tiling move, you must also empty the remaining tiles into the discard.
+                List<String> storageList = new ArrayList<>();
+                String reg_s2 = "[0-4][a-e][0-5]";
+                Pattern p_s2 = Pattern.compile(reg_s2);
+                Matcher m_s2 = p_s2.matcher(storage);
+                while (m_s2.find()) {
+                    if (m_s2.group().charAt(0) != storageRow) {
+                        storageList.add(m_s2.group());
+                    }
+                }
+                String replaceStorage = "S";
+                for (int i = 0; i < storageList.size(); i++) {
+                    replaceStorage += storageList.get(i);
+                }
+                gameState[1] = gameState[1].replaceAll(player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)", "" + player + updateScore + updatedMosaic + replaceStorage); // 清空storage对应行的栏
+
+                // update discard
+                String reg_d = "D([0-2][0-9])([0-2][0-9])([0-2][0-9])([0-2][0-9])([0-2][0-9])";
+                Pattern p_d = Pattern.compile(reg_d);
+                Matcher m_d = p_d.matcher(sharedState);
+                if (m_d.find()) {
+                    int oriTileAmount = Integer.parseInt(m_d.group(colour - 96)); // 96：a, 97:b, 98:c, 99:d, 100:e
+                    int updateTileAmount = oriTileAmount + (storageRow - 48); // 48: 0, 49: 1, 50: 2, 51: 3, 52: 4
+                    // adjust format
+                    String replacedTileAmount = "";
+                    if (updateTileAmount < 10) {
+                        replacedTileAmount = "0" + updateTileAmount;
+                    } else {
+                        replacedTileAmount = "" + updateTileAmount;
+                    }
+                    List<String> discardList = new ArrayList<>();
+                    for (int i = 1; i <= 5; i++) {
+                        discardList.add(m_d.group(i));
+                    }
+                    discardList.set(colour - 97, replacedTileAmount);
+
+                    String replacement = "D";
+                    for (int i = 0; i < 5; i++) {
+                        replacement += discardList.get(i);
+                    }
+                    gameState[0] = gameState[0].replaceAll(reg_d, replacement);
+                }
+
+                String reg_new = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)";
+                Pattern p_new = Pattern.compile(reg_new);
+                Matcher m_new = p_new.matcher(gameState[1]);
+                if (m_new.find()) {
+                    String updatedStorage = m_new.group(3);
+                    String reg_s1 = "[0-4][a-e][0-5]";
+                    Pattern p_s1 = Pattern.compile(reg_s1);
+                    Matcher m_s1 = p_s1.matcher(updatedStorage);
+                    int flagCount = 0;
+                    while (m_s1.find()) {
+                        if ((char) (m_s1.group().charAt(0) + 1) == m_s1.group().charAt(2)) {
+                            flagCount++;
+                        }
+                    }
+                    char nextPlayer = 0;
+                    if (player == 'A') {
+                        nextPlayer = 'B';
+                    } else {
+                        nextPlayer = 'A';
+                    }
+                    if (flagCount == 0) {
+                        gameState[0] = gameState[0].replaceAll("" + player + "F", "" + nextPlayer + "F");
+                    }
+                }
+            }
+        }
+        return gameState;
+    }
+
+    /**
+     * Given a valid game state, return a valid move.
+     *
+     * @param gameState the game state
+     * @return a move for the current game state.
+     * TASK 13
+     */
+
+    /**
+     * @Author: Wangyi Li & Zixin Feng
+     */
+
+    public static String generateAction(String[] gameState) {
+        // FIXME Task 13
+        boolean tillingMove = false;
+        if (gameState[0].contains("FCB")) {
+            tillingMove = true;
+        }
+        String move = "";
+        char player = 0;
+
+        if (tillingMove) { // tilling
+            // Tilling move: storage -> mosaic
+            List<String> moveList = new ArrayList<>();
+            player = gameState[0].charAt(0);
+
+            String reg = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)";
+            Pattern p = Pattern.compile(reg);
+            Matcher m = p.matcher(gameState[1]);
+            if (m.find()) {
+                String reg_s = "([0-4][a-e][0-5])";
+                Pattern p_s = Pattern.compile(reg_s);
+                Matcher m_s = p_s.matcher(m.group(3));
+
+                List<Character> rowList = new ArrayList<>();
+                List<Character> colourList = new ArrayList<>();
+
+                while (m_s.find()) { // find row information in storage
+                    if (m_s.group().charAt(0)+1 == m_s.group().charAt(2)) {
+                        rowList.add(m_s.group().charAt(0));
+                        colourList.add(m_s.group().charAt(1));
+                    }
+                }
+
+                boolean havePassed = false;
+                StringBuilder singleMove = new StringBuilder("" + player);
+                for (Character character : rowList) {
+                    singleMove.append(character);
+                    for (int j = 0; j < 5; j++) {
+                        singleMove.append(j);
+                        if (isMoveValid(gameState, singleMove.toString())) {
+                            moveList.add(singleMove.toString());
+                            havePassed = true;
+                        }
+                        singleMove = new StringBuilder("" + player + character);
+                    }
+                    if (havePassed) {
+                        break;
+                    }
+                }
+                Random r = new Random();
+                int index = r.nextInt(moveList.size());
+                move = moveList.get(index);
+            }
+        } else { // drafting
+            player = gameState[0].charAt(0);
+
+            List<String> singleMoveList = new ArrayList<>();
+            List<String> moveList = new ArrayList<>();
+
+            String reg = player + "F(([0-4][a-e]{4}){0,5})C([a-f]*)";
+            Pattern p = Pattern.compile(reg);
+            Matcher m = p.matcher(gameState[0]);
+            if (m.find()) {
+                if (m.group(3).equals("f")) { // no tiles on center, only take from factory
+                    String reg_f = "([0-4][a-e]{4})";
+                    Pattern p_f = Pattern.compile(reg_f);
+                    Matcher m_f = p_f.matcher(m.group(1));
+                    List<String> factoryList = new ArrayList<>();
+                    while (m_f.find()) {
+                        factoryList.add(m_f.group());
+                    }
+                    StringBuilder singleMove = new StringBuilder("" + player); // record possible move
+                    // record all possible moves without duplicate
+                    Set<String> singleMoveSet = new HashSet<>();
+                    for (String s : factoryList) {
+                        singleMove.append(s.charAt(0));
+                        for (int j = 1; j < 5; j++) {
+                            singleMove.append(s.charAt(j));
+                            singleMoveSet.add(singleMove.toString());
+                            singleMove = new StringBuilder("" + player + s.charAt(0));
+                        }
+                        singleMove = new StringBuilder("" + player);
+                    }
+                    System.out.println(singleMoveSet);
+                    singleMoveList.addAll(singleMoveSet);
+                } else { // center has other tiles except f
+                    if (m.group(1).equals("")) { // factory is empty can only take from center
+                        String singleMove = player + "C";
+                        Set<String> centerSet = new HashSet<>();
+                        for (int i = 0; i < m.group(3).length(); i++) {
+                            if (m.group(3).charAt(i)!='f') {
+                                centerSet.add(singleMove + m.group(3).charAt(i));
+                            }
+                        }
+                        singleMoveList.addAll(centerSet);
+                    } else { // can take from both factory and center
+                        String reg_f = "([0-4][a-e]{4})";
+                        Pattern p_f = Pattern.compile(reg_f);
+                        Matcher m_f = p_f.matcher(m.group(1));
+                        List<String> factoryList = new ArrayList<>();
+                        while (m_f.find()) {
+                            factoryList.add(m_f.group());
+                        }
+                        StringBuilder singleMove = new StringBuilder("" + player);
+                        Set<String> singleMoveSet = new HashSet<>();
+                        for (String s : factoryList) {
+                            singleMove.append(s.charAt(0));
+                            for (int j = 1; j < 5; j++) {
+                                singleMove.append(s.charAt(j));
+                                singleMoveSet.add(singleMove.toString());
+                                singleMove = new StringBuilder("" + player + s.charAt(0));
+                            }
+                            singleMove = new StringBuilder("" + player);
+                        }
+                        singleMoveList.addAll(singleMoveSet);
+
+                        String centerSingleMove = player + "C";
+                        Set<String> centerSet = new HashSet<>();
+                        for (int i = 0; i < m.group(3).length(); i++) {
+                            if (m.group(3).charAt(i)!='f') {
+                                centerSet.add(centerSingleMove + m.group(3).charAt(i));
+                            }
+                        }
+                        singleMoveList.addAll(centerSet);
+                    }
+                }
+
+                for (int i = 0; i < singleMoveList.size(); i++) {
+                    for (int j = 0; j < 5; j++) {
+                        if (isMoveValid(gameState, singleMoveList.get(i) + j)) {
+                            moveList.add(singleMoveList.get(i) + j);
+                        }
+                    }
+                    if (isMoveValid(gameState, singleMoveList.get(i) + "F")) {
+                        moveList.add(singleMoveList.get(i) + "F");
+                    }
+                }
+                System.out.println(moveList);
+                Random r = new Random();
+                int index = r.nextInt(moveList.size());
+                move = moveList.get(index);
+            }
+        }
+        return move;
+        // FIXME Task 15 Implement a "smart" generateAction()
+    }
+}
Only in comp1110-ass2/src/comp1110/ass2: OurAzulGame
Only in comp1110-ass2/src/comp1110/ass2: gittest
Only in comp1110-ass2/src/comp1110/ass2/gui: Bag.java
Only in comp1110-ass2/src/comp1110/ass2/gui: Center.java
Only in comp1110-ass2/src/comp1110/ass2/gui: Discard.java
Only in comp1110-ass2/src/comp1110/ass2/gui: Factory.java
Only in comp1110-ass2/src/comp1110/ass2/gui: Floor.java
Only in comp1110-ass2/src/comp1110/ass2/gui: GrayRectangle.java
Only in comp1110-ass2/src/comp1110/ass2/gui: Mosaic.java
Only in comp1110-ass2/src/comp1110/ass2/gui: Storage.java
Only in comp1110-ass2/src/comp1110/ass2/gui: Tile.java
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/gui/Viewer.java comp1110-ass2/src/comp1110/ass2/gui/Viewer.java
--- ../master/comp1110-ass2/src/comp1110/ass2/gui/Viewer.java	2021-03-30 10:54:46.646153300 +1100
+++ comp1110-ass2/src/comp1110/ass2/gui/Viewer.java	2021-04-26 08:28:06.184407100 +1000
@@ -11,6 +11,9 @@
 import javafx.scene.layout.HBox;
 import javafx.stage.Stage;
 
+import java.util.regex.Matcher;
+import java.util.regex.Pattern;
+
 public class Viewer extends Application {
 
     private static final int VIEWER_WIDTH = 1200;
@@ -30,6 +33,23 @@
      */
     void displayState(String[] state) {
         // FIXME Task 4: implement the simple state viewer
+        //remove previous placements
+        controls.getChildren().removeAll(controls.getChildren());
+        //repaint the window
+        Factory.player = 2; //how many players
+        controls.getChildren().addAll(Factory.getFactories());
+        controls.getChildren().addAll(Storage.getp1Storage());
+        controls.getChildren().addAll(Storage.getp2Storage());
+        controls.getChildren().addAll(Floor.getp1Floor());
+        controls.getChildren().addAll(Floor.getp2Floor());
+        controls.getChildren().addAll(Mosaic.getp1Mosaic());
+        controls.getChildren().addAll(Mosaic.getp2Mosaic());
+        makeControls();
+        repaintBoard(state);
+        repaintP1(state);
+        repaintP2(state);
+
+
     }
 
     /**
@@ -59,6 +79,233 @@
         controls.getChildren().add(hb);
     }
 
+    /*
+    * repaint the board
+    * */
+    public void repaintBoard(String[] state) {
+        Bag B = new Bag();
+        Center C = new Center();
+        Discard D = new Discard();
+        controls.getChildren().addAll(B, C, D);
+        //read the sharedState
+        String sharedState = state[1];
+        /*
+         * repaint the Factory area
+         * */
+        Pattern p = Pattern.compile("F(([0-4][a-e]{4}){0,5})");
+        Matcher m = p.matcher(sharedState);
+        while (m.find()) {
+            String g1 = m.group(1);  //the factory part
+            int counter = 0;
+            //repaint the factory
+            for (int i = 0; i < g1.length(); i += 5) {
+                for (int j = 1; j < 5; j++) {
+                    Tile tmp = new Tile(g1.charAt(i + j));
+                    Double X = Factory.getCoordX().get(counter).get(j - 1);
+                    Double Y = Factory.getCoordY().get(0).get(j - 1);
+                    tmp.setLayoutX(X);
+                    tmp.setLayoutY(Y);
+                    controls.getChildren().add(tmp);
+                }
+                counter++;
+
+            }
+        }
+        /*
+         * repaint the Centre area
+         * */
+        Pattern p1 = Pattern.compile("C([a-f]*)");
+        Matcher m1 = p1.matcher(sharedState);
+        while (m1.find()) {
+            String g1 = m1.group(1);
+            if (!g1.equals("")) {
+                for (int i = 0; i < m1.end(1) - m1.start(1); i++) {
+                    C.getChildren().add(new Tile(g1.charAt(i)));
+                }
+            }
+        }
+        /*
+         *repaint the Bag area
+         * */
+        Pattern p2 = Pattern.compile("B(([0-2][0-9]){5})");
+        Matcher m2 = p2.matcher(sharedState);
+        String color = "abcde";
+        int num = 0;
+        while (m2.find()) {
+            String g1 = m2.group(1);
+            int counter1 = 0;
+            for (int i = 0; i < g1.length(); i += 2) {
+                if (g1.charAt(i) == '0') {
+                    String tmp = Character.toString(g1.charAt(i + 1));
+                    num = Integer.parseInt(tmp);
+                } else {
+                    String tmp1 = Character.toString(g1.charAt(i)) + Character.toString(g1.charAt(i + 1));
+                    num = Integer.parseInt(tmp1);
+                }
+                for (int j = 0; j < num; j++) {
+                    B.getChildren().add(new Tile(color.charAt(counter1)));
+                }
+                counter1++;
+            }
+        }
+        /*
+         * repaint the Discard area
+         * */
+        Pattern p3 = Pattern.compile("D(([0-2][0-9]){5})");
+        Matcher m3 = p3.matcher(sharedState);
+        int num1 = 0;
+        while (m3.find()) {
+            String g1 = m3.group(1);
+            int counter2 = 0;
+            for (int i = 0; i < g1.length(); i += 2) {
+                if (g1.charAt(i) == '0') {
+                    String tmp = Character.toString(g1.charAt(i + 1));
+                    num1 = Integer.parseInt(tmp);
+                } else {
+                    String tmp1 = Character.toString(g1.charAt(i)) + Character.toString(g1.charAt(i + 1));
+                    num1 = Integer.parseInt(tmp1);
+                }
+                for (int j = 0; j < num1; j++) {
+                    D.getChildren().add(new Tile(color.charAt(counter2)));
+                }
+                counter2++;
+            }
+        }
+    }
+
+    /*
+    * repaint Player1 placements
+    * */
+    public void repaintP1(String[] state) {
+
+        //read player1 information from state
+        String playerState = state[0];
+        String player1State = null;
+        Pattern p = Pattern.compile("A(\\w*)B");
+        Matcher m = p.matcher(playerState);
+        while (m.find()) {
+            player1State = m.group(1);
+        }
+        /*
+         * repaint the Mosaic area
+         * */
+        Pattern p1 = Pattern.compile("M(\\w*)S");
+        Matcher m1 = p1.matcher(player1State);
+        while (m1.find()) {
+            String g1 = m1.group(1);
+            for (int i = 0; i < g1.length(); i += 3) {
+                Tile tmp = new Tile(g1.charAt(i));
+                int row = Integer.parseInt(Character.toString(g1.charAt(i + 1)));
+                int column = Integer.parseInt(Character.toString(g1.charAt(i + 2)));
+                tmp.setLayoutY(Mosaic.getP1CoordY().get(row).get(0));
+                tmp.setLayoutX(Mosaic.getp1CoordX().get(0).get(column));
+                controls.getChildren().add(tmp);
+            }
+        }
+        /*
+         * repaint the Storage area
+         * */
+        Pattern p2 = Pattern.compile("S(\\w*)F");
+        Matcher m2 = p2.matcher(player1State);
+        int num = 0;
+        while (m2.find()) {
+            String g2 = m2.group(1);
+            for (int i = 0; i < g2.length(); i += 3) {
+                num = Integer.parseInt(Character.toString(g2.charAt(i + 2)));
+                int row = Integer.parseInt(Character.toString(g2.charAt(i)));
+                for (int j = 0; j < num; j++) {
+                    Tile tmp = new Tile(g2.charAt(i + 1));
+                    tmp.setLayoutY(Storage.getP1CoordY().get(row).get(0));
+                    tmp.setLayoutX(Storage.getP1CoordX().get(row).get(j));
+                    controls.getChildren().add(tmp);
+
+                }
+            }
+        }
+        /*
+         * repaint the Floor area
+         * */
+        Pattern p3 = Pattern.compile("F(\\w*)");
+        Matcher m3 = p3.matcher(player1State);
+        while (m3.find()) {
+            String g3 = m3.group(1);
+            for (int i = 0; i < m3.end(1) - m3.start(1); i++) {
+                Tile tmp = new Tile(g3.charAt(i));
+                tmp.setLayoutY(Floor.getP1CoordY().get(0).get(0));
+                tmp.setLayoutX(Floor.getP1CoordX().get(0).get(i));
+                controls.getChildren().add(tmp);
+
+            }
+        }
+
+    }
+
+    /*
+    * repaint player2 placements
+    * */
+    public void repaintP2(String[] state) {
+        //read player2 information from state
+        String playerState = state[0];
+        String player2State = null;
+        Pattern p = Pattern.compile("B(\\w*)");
+        Matcher m = p.matcher(playerState);
+        while (m.find()) {
+            player2State = m.group(1);
+        }
+        /*
+         * repaint the Mosaic area
+         * */
+        Pattern p1 = Pattern.compile("M(\\w*)S");
+        Matcher m1 = p1.matcher(player2State);
+        while (m1.find()) {
+            String g1 = m1.group(1);
+            for (int i = 0; i < g1.length(); i += 3) {
+                Tile tmp = new Tile(g1.charAt(i));
+                int row = Integer.parseInt(Character.toString(g1.charAt(i + 1)));
+                int column = Integer.parseInt(Character.toString(g1.charAt(i + 2)));
+                tmp.setLayoutY(Mosaic.getP2CoordY().get(row).get(0));
+                tmp.setLayoutX(Mosaic.getp2CoordX().get(0).get(column));
+                controls.getChildren().add(tmp);
+            }
+        }
+        /*
+         * repaint the Storage area
+         * */
+        Pattern p2 = Pattern.compile("S(\\w*)F");
+        Matcher m2 = p2.matcher(player2State);
+        int num = 0;
+        while (m2.find()) {
+            String g2 = m2.group(1);
+            for (int i = 0; i < g2.length(); i += 3) {
+                num = Integer.parseInt(Character.toString(g2.charAt(i + 2)));
+                int row = Integer.parseInt(Character.toString(g2.charAt(i)));
+                for (int j = 0; j < num; j++) {
+                    Tile tmp = new Tile(g2.charAt(i + 1));
+                    tmp.setLayoutY(Storage.getP2CoordY().get(row).get(0));
+                    tmp.setLayoutX(Storage.getP2CoordX().get(row).get(j));
+                    controls.getChildren().add(tmp);
+
+                }
+            }
+        }
+        /*
+         * repaint the Floor area
+         * */
+        Pattern p3 = Pattern.compile("F(\\w*)");
+        Matcher m3 = p3.matcher(player2State);
+        while (m3.find()) {
+            String g3 = m3.group(1);
+            for (int i = 0; i < m3.end(1) - m3.start(1); i++) {
+                Tile tmp = new Tile(g3.charAt(i));
+                tmp.setLayoutY(Floor.getP2CoordY().get(0).get(0));
+                tmp.setLayoutX(Floor.getP2CoordX().get(0).get(i));
+                controls.getChildren().add(tmp);
+
+            }
+        }
+    }
+
+
     @Override
     public void start(Stage primaryStage) throws Exception {
         primaryStage.setTitle("Azul Viewer");
Only in comp1110-ass2/src: img
Only in comp1110-ass2/tests/comp1110/ass2: OurTest
```
