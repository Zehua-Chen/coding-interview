LD = clang++
CXXFLAGS = -std=c++11

all: test

bin/:
	mkdir bin

bin/tree.o: tree.cc tree.h bin/
	$(CXX) $(CXXFLAGS) -c $< -o $@

bin/main.o: main.cc tree.h bin/
	$(CXX) $(CXXFLAGS) -c $< -o $@

test: bin/main.o bin/tree.o
	$(LD) $+ -o $@

.PHONY: clean

clean:
	rm -rf bin