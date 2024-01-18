## Code Review

Reviewed by: Wangyi Li, u7323052

Reviewing code written by: Zixin Feng u7233947

Component: [Task8](https://gitlab.cecs.anu.edu.au/u7323052/comp1110-ass2-tue12q/-/blob/master/src/comp1110/ass2/Azul.java#L467-653)

### Comments 

The code is neatly lined up. But it would be nice to reorder some of the code so that the related lines are as concentrated as possible (e.g. : [1](https://gitlab.cecs.anu.edu.au/u7323052/comp1110-ass2-tue12q/-/blob/master/src/comp1110/ass2/Azul.java#L479-480) & [2](https://gitlab.cecs.anu.edu.au/u7323052/comp1110-ass2-tue12q/-/blob/master/src/comp1110/ass2/Azul.java#L518-520)). More comments about the features need to be added to help with reading. The program decomposition is appropriate. It makes good calls to existing and new methods to meet task requirements. It follow Java code conventions. The variable name is correct and readable. And the style consistent throughout. The initial access to sharedState and playerState does not need to include the subString and can be removed. ([3](https://gitlab.cecs.anu.edu.au/u7323052/comp1110-ass2-tue12q/-/blob/master/src/comp1110/ass2/Azul.java#L469-470))


