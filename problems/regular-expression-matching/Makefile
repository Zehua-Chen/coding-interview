LD = clang++
LDFLAGS =
CXX = clang++
CXXFLAGS = -std=c++14

all: test

bin:
	mkdir bin

bin/solution.o: solution.cc solution.h | bin/
	$(CXX) $(CXXFLAGS) -c $< -o $@

bin/main.o: main.cc solution.h | bin/
	$(CXX) $(CXXFLAGS) -c $< -o $@

test: bin/main.o bin/solution.o
	$(LD) $(LDFLAGS) $+  -o $@

.PHONY: clean

clean:
	rm -rf bin
	rm -f test
