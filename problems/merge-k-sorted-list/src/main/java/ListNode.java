import java.util.Objects;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();

    ListNode root = this;

    while (root != null) {
      stringBuilder.append(root.val);
      stringBuilder.append(',');

      root = root.next;
    }

    return stringBuilder.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ListNode listNode = (ListNode) o;

    if (listNode.val != this.val) {
      return false;
    }

    if (listNode.next == null && this.next == null) {
      return true;
    }

    if (listNode.next != null && this.next != null) {
      return listNode.next.equals(this.next);
    }

    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, next);
  }

  static ListNode create(int... values) {
    if (values.length == 0) {
      return null;
    }

    ListNode root = new ListNode(values[0]);
    ListNode prev = root;

    for (int i = 1; i < values.length; i++) {
      prev.next = new ListNode(values[i]);
      prev = prev.next;
    }

    return root;
  }
}
