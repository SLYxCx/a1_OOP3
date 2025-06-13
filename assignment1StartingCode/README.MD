# 1. Compile all files
``` 
javac -d . Sort.java shapes/Shape.java shapes/Prism.java shapes/SquarePrism.java shapes/TriangularPrism.java shapes/OctagonalPrism.java shapes/PentagonalPrism.java shapes/Cylinder.java shapes/Cone.java shapes/Pyramid.java sorting/BubbleSort.java sorting/SelectionSort.java sorting/InsertSort.java sorting/QuickSort.java sorting/Mergesort.java sorting/ShellSort.java
``` 

# 2. Create JAR with Sort as main class
``` 
jar cfe Sort.jar Sort *.class shapes/*.class sorting/*.class
```

# 3. Test it
``` 
java -jar Sort.jar -f"\..\res\shapes5.txt" -tv -sq
``` 
