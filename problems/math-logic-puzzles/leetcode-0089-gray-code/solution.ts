// observations
// 1. grayCode(n - 1) returns an array half of the size of that from grayCode(n)
// 2. grayCode(n) contains array of grayCode(n - 1) as the first half
// 3. Given grayCode(n - 1), making the nth bit of every element in
//    grayCode(n - 1) 1 will produce a valid second half of grayCode(n) (see
//    observation 2)
function grayCode(n: number): number[] {
  if (n === 1) {
    return [0, 1];
  }

  let numbers = grayCode(n - 1);

  // observation 3
  let mask = 1 << (n - 1);

  for (let i = numbers.length - 1; i >= 0; i--) {
    // observation 3
    numbers.push(mask | numbers[i]);
  }

  return numbers;
}
