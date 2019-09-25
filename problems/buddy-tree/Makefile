LD = clang++
CXXFLAGS = -std=c++11

all: bin test

bin:
	mkdir bin

bin/Tree.o: Tree.cpp Tree.hpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

bin/main.o: main.cpp Tree.hpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

test: bin/main.o bin/Tree.o
	$(LD) $+ -o $@

.PHONY: clean

clean:
	rm -rf bin