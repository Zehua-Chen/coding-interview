LD = clang++
LDFLAGS =
CXXFLAGS = -std=c++11

all: test

bin:
	mkdir bin

bin/main.o: main.cc solution.h | bin/
	$(CXX) $(CXXFLAGS) -c $< -o $@

test: bin/main.o
	$(LD) $(LDFLAGS) $+  -o $@

.PHONY: clean

clean:
	rm -rf bin