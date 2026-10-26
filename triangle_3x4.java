/*
OT Job 54060 Technical Assessment

Question 1.

Task:
Using the fewest lines of code, display a triangle of 3x4 using asterisks (*).


Planning:

3x4 = width x height

Option 1:

*
*
**      
***
Awkward leading *

Option 2:

*
**
**
***
Awkward slope

Visually, I do not like how these triangles look.
Lets consider following:
3x4 = height x width

Option 3:

**
***
****
Produces a triangle with 4 vertices which by definition is not a triangle.

Option 4:

*
***
****
Option 4. looks the most visually appealing and satisfies the definition of a triangle

Assumption 1:
3x4 = 3 units in y-direction and 4 units in x-direction (height x width)

Assumption 2:
For simplicity sake and since the Task did not set constraints, lets assume a Right-Angle triangle


Pattern in the way the star grows:
There is a pattern in the number of stars 4,3,1

* 1
*** 3
**** 4

This can be expressed as:

3x4 = i*4/3
or
hxw = i*w/h


For Triangle 3x4 where height is 3 and width is 4:

Row (i) (i × w / h)    Round   Stars
1       1.33            1       1
2       2.67            3       3
3       4.00            4       4
* round to the nearest whole number

General case for any h x w traignle:

Row (i)   i × w / h     Stars
1         w / h         round(w / h)
2         2w / h        round(2w / h)
3         3w / h        round(3w / h)
...       ...           ...
h         h x w / h       w

//limitation:
When height and width gave large size gap. it produces some triangles that look distorted. However, h>w it is true the starting from the base=b and moving up a row, b+1 will never be strictly greater than b so it is a valid triangle still. I will still include
it as a disclaimer for the bonus

e.g.
10x6= (height x width)

*
*
**
**
***
****
****
*****
*****
******

*/

// Version 1:
// developed unoptimized version that satisfies the requirements

// public class Triangle {
//     public static void main(String[] args) {
//         int height = 3;
//         int width = 4;
//         for (int i=1; i<=height; i++){
//             int stars = (int) Math.round((double) (i * width) / height); // the formula: (i × w / h)
//             for (int j = 0; j < stars; j++) {
//                 System.out.print("*");
//             }
//             System.out.println();   // new row
//         }


        
        
//     }
// }


// Version 2:
// AI assisted Optimized Version

public class Triangle {
    public static void main(String[] args) {
        for (int i = 1, h = 3, w = 4; i <= h; i++) System.out.println("*".repeat((2 * i * w + h) / (2 * h)));
    }
}

