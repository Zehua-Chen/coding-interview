# Flip Bit

```java
public class Sample {
  public int flip(int bits, int index) {
    int mask = 1 << index;
    int bitAtIndex = ((bits & mask) >>> index);

    if (bitAtIndex == 0) {
      // target bit: x | 1 is always 1
      // other bits: x | 0, x will not be changed
      bits |= mask;
    } else {
      // target bit: x & 0, would make the target bit 0
      // other bits: x & 1, if x == 1, gives 1; if x == 0, gives 0
      bits &= ~mask;
    }

    return bits;
  }
}
```
