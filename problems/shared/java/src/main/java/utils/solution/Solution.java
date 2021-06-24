package utils.solution;

import java.lang.reflect.*;

public abstract class Solution {
    /**
     * Create a new instance of solution
     *
     * @param cls the solution class
     * @param <T> the solution type
     * @return a new instance of solution, created using `cls`
     * @throws NoSuchMethodException thrown by `cls.getConstructor()`
     * @throws InstantiationException thrown by `constructor.newInstance()`
     * @throws IllegalAccessException thrown by `constructor.newInstance()`
     * @throws IllegalArgumentException thrown by `constructor.newInstance()`
     * @throws InvocationTargetException thrown by `constructor.newInstance()`
     */
    public static <T extends Solution> T newInstance(Class<T> cls)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException,
                    IllegalArgumentException, InvocationTargetException {
        Constructor<T> constructor = cls.getConstructor();
        return constructor.newInstance();
    }

    /**
     * Base constructor
     *
     * <p>Solutions should not have instructors that takes parameters, as in "leetcode"
     */
    public Solution() {}
}
