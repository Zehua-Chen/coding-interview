package utils;

public class ListNode {
  public int val;
  public ListNode next;
  public ListNode(int x) { val = x; }

  public static ListNode create(int ... values) {
    ListNode root = new ListNode(values[0]);
    ListNode prev = root;

    for (int i = 1; i < values.length; i++) {
      prev.next = new ListNode(values[i]);
      prev = prev.next;
    }

    return root;
  }

  @Override
  public String toString() {
    ListNode current = this;
    StringBuilder builder = new StringBuilder();

    while (current != null) {
      builder.append(current.val);
      builder.append("->");

      current = current.next;
    }

    builder.append("end");

    return builder.toString();
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }

    if (other.getClass() != this.getClass()) {
      return false;
    }

    ListNode o = (ListNode) other;

    if (o.val != this.val) {
      return false;
    }

    if (o.next == null && this.next == null) {
      return true;
    }

    if (o.next != null && this.next == null) {
      return false;
    }

    if (o.next == null && this.next != null) {
      return false;
    }

    return o.next.equals(this.next);
  }
}
