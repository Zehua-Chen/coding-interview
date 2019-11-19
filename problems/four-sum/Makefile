LD = clang++
CXXFLAGS = -std=c++11

all: test

bin:
	mkdir bin

bin/solution.o: solution.cc solution.h | bin/
	$(CXX) $(CXXFLAGS) -c $< -o $@

bin/main.o: main.cc solution.h | bin/
	$(CXX) $(CXXFLAGS) -c $< -o $@

test: bin/main.o bin/solution.o
	$(LD) $+ -o $@

.PHONY: clean

clean:
	rm -rf bin