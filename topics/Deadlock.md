# Deadlock

## Problem

Dead lock arose when you have two mutexes, A and B, locked in opposite order:
- Thread 1: A, B
- Thread 2: B, A

Thread 2 lock B first, leaving thread 2 waiting to lock B. Thread 1 has A
locked, leaving thread 2 waiting to lock A. Both thread does not unlock
either mutexes, causing a dead lock

## Solution

### Avoid Locking More Than One Mutexes at a Time

If you don't lock more than one mutexes, dead lock never occurs

### Same Order

- A mutex does not happen if all mutexes are locked at the same time

### Avoid Calling User Function

- After locking a mutex, calling a user function may cause dead lock,
as they may want to lock the same mutex

### `std::lock`

- Use `std::lock` to lock two mutexes
- If using lock guard, pass `std::adopt_lock` as parameter (tells the
lock guard that that a mutex is already locked)

