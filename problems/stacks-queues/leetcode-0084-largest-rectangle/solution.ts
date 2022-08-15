function largestRectangleArea(heights: number[]): number {
  let maxArea = 0;
  let stack: number[] = [-1];

  for (let i = 0; i < heights.length; i++) {
    while (
      stack[stack.length - 1] !== -1 &&
      heights[stack[stack.length - 1]] > heights[i]
    ) {
      let lastElementIndex = stack.pop();

      maxArea = Math.max(
        maxArea,
        heights[lastElementIndex!] * (i - stack[stack.length - 1] - 1)
      );
    }

    stack.push(i);
  }

  while (stack[stack.length - 1] !== -1) {
    let lastElementIndex = stack.pop();

    maxArea = Math.max(
      maxArea,
      heights[lastElementIndex!] *
        (heights.length - stack[stack.length - 1] - 1)
    );
  }

  return maxArea;
}
