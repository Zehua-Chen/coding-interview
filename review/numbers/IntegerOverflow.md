# Overview

- **Rule of thumb**: always use at least `long` for calculating sum.

- max of int of x bits: `(2 ** (x - 1)) - 1`
- min of int of x bits: `(2 ** (x - 1)) * -1`
- `Integer.MIN_VALUE == Integer.MIN_VALUE * -1`

# Overflow Detection

```cpp
#include <iostream>

using std::cout;
using std::endl;

struct Int32 {
 private:
  static constexpr int32_t _flag = 0x80000000;
 public:
  struct OverflowException {
  };

  int32_t value;

  Int32(const int32_t value) : value(value) {
  }

  Int32 operator+(int32_t other) {
    const int32_t thisFlag = this->value & _flag;
    const int32_t otherFlag = other & _flag;

    const Int32 result = this->value + other;
    const int32_t resultFlag = result.value & _flag;

    if (thisFlag == otherFlag && thisFlag != resultFlag) {
      throw OverflowException();
    }

    return result;
  }

  Int32 operator-(int32_t other) {
    return this->operator+(other * -1);
  }
};

int main()
{
  try {
    Int32 a = 2147483647;
    a = a + 1;
  } catch(const Int32::OverflowException &e) {
    cout << "positive overflow" << endl;
  }

  try {
    Int32 a = -2147483648;
    a = a - 1;
  } catch(const Int32::OverflowException &e) {
    cout << "negative overflow" << endl;
  }

  return 0;
}
```
