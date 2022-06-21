class Solution {
    public String simplifyPath(String path) {
        // split segments
        // resolve . and ..
        // join segments
        String[] split = path.split("/");
        var nonEmpty = new ArrayList<String>();

        // System.out.println(Arrays.toString(split));

        for (String s : split) {
            if (s.length() > 0) {
                nonEmpty.add(s);
            }
        }

        var canonical = new ArrayList<String>();

        for (String s : nonEmpty) {
            if (s.equals(".")) {
                continue;
            }

            if (s.equals("..")) {
                if (canonical.size() > 0) {
                    canonical.remove(canonical.size() - 1);
                }

                continue;
            }

            canonical.add(s);
        }

        return "/" + String.join("/", canonical);
    }
}
