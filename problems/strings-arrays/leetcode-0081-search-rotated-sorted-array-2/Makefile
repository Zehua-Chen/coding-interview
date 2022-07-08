.PHONY: all clean

all: Solution.jar
	java -jar Solution.jar

clean:
	rm -f *.class *.jar

Solution.class: Solution.java
	javac Solution.java

Solution.jar: Solution.class Solution.mf
	jar cmf Solution.mf Solution.jar Solution.class
