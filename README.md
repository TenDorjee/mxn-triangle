# Asterisk Triangle — OT Job 54060 Technical Assessment
*Note: This README was created by AI by prompting it to convert my problem-solving processes seen in the file comments into a README.*
Java programs that draw a right-angle triangle of asterisks (`*`) for a given height × width.

| File | Task |
|---|---|
| `triangle_3x4.java` | **Q1:** Display a 3×4 triangle in the fewest lines of code |
| `triangle_mxn.java` | **Q2 (Bonus):** Display any M×N triangle from user input |

## How to Run

Requires **Java 11+** (uses `String.repeat`). Run each file directly with the single-file source launcher:

```bash
java triangle_3x4.java
java triangle_mxn.java
```

## Problem-Solving Process

1. **Interpreting "3×4".** I sketched several candidate shapes:
   - *Width × height (4 rows):* produced either an awkward leading `*` or an uneven slope.
   - *Height × width, `**` / `***` / `****`:* a 2-star top row gives the shape a flat top (4 vertices), so it is not a triangle.
   - *Height × width, `*` / `***` / `****`:* has a single-point top, a 4-wide base, and the cleanest slope. **Chosen.**
2. **Finding the pattern.** The chosen shape has rows of 1, 3, 4 stars. That is row `i` scaled by `width / height`, rounded:

   | Row (i) | i × w / h | Rounded |
   |---|---|---|
   | 1 | 1.33 | 1 |
   | 2 | 2.67 | 3 |
   | 3 | 4.00 | 4 |

3. **Generalizing.** For any h × w: `stars(i) = round(i × w / h)`, for `i = 1..h`. The last row is always exactly `w`.
4. **Implementing.** Version 1 used `Math.round` with a nested loop. Version 2 (AI-assisted) reduces it to one loop line using:
   - `"*".repeat(n)` to replace the inner loop
   - the integer-only round-half-up formula `(2·i·w + h) / (2·h)`, which matches `Math.round` exactly, including `.5` cases, without floating point or casts
5. **Bonus (AI-assisted from the Q1 logic).** I wrapped the formula in `printMxN(m, n)` and added a validated input loop with clear usage and error prompts.

## Assumptions

1. **"3×4" means height × width:** 3 rows tall, 4 stars wide at the base.
2. **Right-angle triangle**, left-aligned, widening from top to bottom, since the task set no constraints on shape.
3. **Fractional row widths round to the nearest whole number**, with `.5` rounding up.

## Example Input / Output

**Q1 (3×4):**
```
*
***
****
```

**Q2 (Bonus), valid input:**
```
Height (M): 10
Width (N): 10

Result for 10x10:
*
**
***
****
*****
******
*******
********
*********
**********
```

**Q2 (Bonus), invalid input:**
```
Height (M): abc
Error: must be an integer.
Height (M): -3
Error: must be a positive integer.
```

## Limitations

- **Distortion at extreme ratios.** Terminal text is a coarse grid, so very tall or very wide triangles look stepped or flattened. For example, 10×6 repeats row widths, and 3×20 jumps 7 → 13 → 20.
- **Integer overflow** is possible if `2·i·w` exceeds `int` range (around 2.1 billion). This is not realistic for console output.
