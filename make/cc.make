OBJS=$(patsubst %.cc, $(BIN)/%.cc.o, $(SRCS))
DEPS=$(patsubst $(BIN)/%.cc.o, $(BIN)/%.cc.d, $(OBJS))

all: $(EXE)

-include $(DEPS)

$(BIN):
	mkdir $@

$(BIN)/%.cc.o: %.cc | $(BIN)
	$(CXX) $(CXXFLAGS) -MMD -c $< -o $@

$(EXE): $(OBJS)
	$(LD) $(LDFLAGS) $+ -o $@

.PHONY: info
info:
	@echo sources = $(SRCS)
	@echo objects = $(OBJS)
	@echo deps = $(DEPS)

.PHONY: clean
clean:
	rm -rf $(BIN)