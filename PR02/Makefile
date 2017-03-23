JFLAGS = -g
JC = javac
JVM= $(JAVA_HOME)/bin/java
.SUFFIXES: .java .class
.java.class: ; $(JC) $(JFLAGS) $*.java

CLASSES = \
	ConvexHull.java \
	GrahamScan.java \
	JarvisMarch.java \
	QuickHull.java \
	Line.java \
	Point.java \
	PointComparator.java \
	Main.java

MAIN = Main

default: classes run

classes: $(CLASSES:.java=.class)

run: classes
	$(JVM) $(MAIN)

clean:
	$(RM) *.class
