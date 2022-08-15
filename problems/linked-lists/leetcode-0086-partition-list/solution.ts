/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function partition(head: ListNode | null, x: number): ListNode | null {
  if (head === null) {
    return null;
  }

  let outHead: ListNode | null = null;
  let outTail: ListNode | null = null;

  function push(val: number): void {
    if (outHead === null || outTail === null) {
      outHead = new ListNode(val, null);
      outTail = outHead;
    } else {
      outTail.next = new ListNode(val, null);
      outTail = outTail.next;
    }
  }

  for (let node: ListNode | null = head; node !== null; node = node.next) {
    if (node.val < x) {
      push(node.val);
    }
  }

  for (let node: ListNode | null = head; node !== null; node = node.next) {
    if (node.val >= x) {
      push(node.val);
    }
  }

  return outHead;
}
