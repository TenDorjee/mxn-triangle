# Asterisk Triangle — OT Job 54060 Technical Assessment
*Note: This README was created by AI by prompting it to convert my problem-solving processes seen in the file comments into a README.*

Java programs that draw a right-angle triangle of asterisks (`*`).

- **`triangle_3x4.java`** (Question 1): prints a fixed 3x4 triangle in as few lines as possible.
- **`triangle_mxn.java`** (Bonus): reads any M x N from the user and prints that triangle.

## How to Run

*Requires Java 11+ (for `String.repeat` and single-file source-code execution).*

```bash
java triangle_3x4.java
java triangle_mxn.java
```
## Assumptions

1. **3x4 means height x width:** 3 rows tall and 4 stars wide at the base.
2. **It is a right-angle triangle**, because the task set no other constraints.
3. **The top row has at least one star (for 3x4), and each row is at least as wide as the one above.** This ensures the shape converges to a single point.

## Problem-Solving Process

**1. I tried width x height first (3 wide, 4 tall).**

```
*        *
*        **
**       **
***      ***
```

Both options looked awkward. One has a doubled top and the other has an uneven slope.

**2. I switched to height x width (3 tall, 4 wide).**

```
**       *
***      ***
****     ****
```

The left option has a flat top with two stars, so it has four corners and is not a triangle. The right option has a single-star top and a clean slope, so I chose it.

**3. I found the pattern.** The row lengths are 1, 3, 4. Each row's width is the line from the top to the base, sampled at that row and rounded to the nearest whole star:

```
stars(i) = round(i × w / h),   i = 1..h
```

| Row (i) | i × w / h | Rounded |
|---------|-----------|---------|
| 1       | 1.33      | 1       |
| 2       | 2.67      | 3       |
| 3       | 4.00      | 4       |

The last row always equals `w`, because `h × w / h = w`. Using floor (1, 2, 4) or ceiling (2, 3, 4) would not reproduce the chosen shape, so I used rounding.

**4. I implemented it.**

- **Version 1:** nested loops with `Math.round((double) (i * w) / h)`. This version is readable but not minimal.
- **Version 2 (AI-assisted optimization):** a single-line loop using `String.repeat`. It does the rounding with integer arithmetic only:
  ```
  round(i × w / h)  ==  (2·i·w + h) / (2·h)   (integer division, rounds half up)
  ```
  This avoids floating point and casting.

**5. Bonus.** I reused the same formula in `printMxN(m, n)`. The interactive prompts and input validation were generated with AI, at my direction.

## Example Input / Output

**Question 1 (3x4)**

```
*
***
****
```

**Bonus**

```
--- Bonus Task: Interactive M x N Triangle ---
Usage: Enter height and width as positive integers.
...
Height (M): 5
Width (N): 8

Result for 5x8:
**
***
*****
******
********
```

Invalid input is rejected and the user is re-prompted:

```
Height (M): abc
Error: must be an integer.
Height (M): -2
Error: must be a positive integer.
Height (M):
```

## Limitations

- **Large height-to-width gaps distort the shape.** A terminal is a grid of characters, so very tall or very wide triangles show repeated rows or skipped widths. For example, 10x6 gives:
  ```
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
  ```
  The shape is still a valid triangle, because no row is ever narrower than the one above it width(row + 1) >= width(row).
- **Very narrow triangles can start with blank rows.** When `N < M / 2`, the first row or rows round to 0 stars. For example, 10x3 prints an empty first line.
- **Ties (x.5) round up.** This is a deliberate choice of the integer formula.
