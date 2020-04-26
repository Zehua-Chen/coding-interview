LD = clang++
CXXFLAGS = -std=c++11

all: bin test

bin:
	mkdir bin

bin/Solution.o: Solution.cc Solution.h
	$(CXX) $(CXXFLAGS) -c $< -o $@

bin/main.o: main.cc Solution.h
	$(CXX) $(CXXFLAGS) -c $< -o $@

test: bin/main.o bin/Solution.o
	$(LD) $+ -o $@

.PHONY: clean

clean:
	rm -rf bin