BASE = $(shell git rev-parse --show-toplevel)
SRC = $(BASE)/src
BUILD = $(BASE)/build

JC = javac
JFLAGS = -d $(BUILD) -Xlint:unchecked

all: bld l1 l2/c1 l2/c1 l3/c1 l3/c2 l3/c3 l4/c1 l4/c2 l5

bld: $(shell mkdir -p $(BUILD))

# LEVEL 1
l1: $(SRC)/l1/solution/Verify.java $(SRC)/utils/Tester.java
	$(JC) $(JFLAGS) $^

## LEVEL 2
l2/c1: $(SRC)/l2/c1/solution/Verify.java $(SRC)/utils/Tester.java
	$(JC) $(JFLAGS) $^

l2/c2: $(SRC)/l2/c2/solution/Verify.java $(SRC)/utils/Tester.java
	$(JC) $(JFLAGS) $^

### LEVEL 3
l3/c1: $(SRC)/l3/c1/solution/Verify.java $(SRC)/utils/Tester.java
	$(JC) $(JFLAGS) $^

l3/c2: $(SRC)/l3/c2/solution/Verify.java $(SRC)/utils/Tester.java
	$(JC) $(JFLAGS) $^

l3/c3: $(SRC)/l3/c3/solution/Verify.java $(SRC)/utils/Tester.java
	$(JC) $(JFLAGS) $^

#### LEVEL 4
l4/c1: $(SRC)/l4/c1/solution/Verify.java $(SRC)/utils/Tester.java $(SRC)/utils/Utils.java
	$(JC) $(JFLAGS) $^

l4/c2: $(SRC)/l4/c2/solution/Verify.java $(SRC)/utils/Tester.java
	$(JC) $(JFLAGS) $^
	
##### LEVEL 5
l5: $(SRC)/l5/solution/Verify.java $(SRC)/utils/Tester.java
	$(JC) $(JFLAGS) $^

##### CLEAN UP ######
clean:
	rm -rf $(BUILD)/*.class
