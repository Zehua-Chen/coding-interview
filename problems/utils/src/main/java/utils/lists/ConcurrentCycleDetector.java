package utils.lists;

import java.util.*;

class ConcurrentCycleDetector extends ThreadLocal<HashSet<Object>> {
    @Override
    protected HashSet<Object> initialValue() {
        return new HashSet<>();
    }

    public void clear() {
        this.get().clear();
    }

    public void add(Object node) {
        this.get().add(node);
    }

    public boolean contains(Object node) {
        return this.get().contains(node);
    }
}
