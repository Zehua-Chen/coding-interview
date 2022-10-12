export function solution(year: number): number {
  const base = Math.floor(year / 100);
  const offset = year % 100 > 0 ? 1 : 0;

  return base + offset;
}
