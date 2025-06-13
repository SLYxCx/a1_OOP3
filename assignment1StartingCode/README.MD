# 1. Compile all files
``` 
javac -d . Sort.java shapes/Shape.java shapes/Prism.java shapes/SquarePrism.java shapes/TriangularPrism.java shapes/OctagonalPrism.java shapes/PentagonalPrism.java shapes/Cylinder.java shapes/Cone.java shapes/Pyramid.java sorting/BubbleSort.java sorting/SelectionSort.java sorting/InsertSort.java sorting/QuickSort.java sorting/Mergesort.java sorting/ShellSort.java
``` 

# 2. Create JAR with Sort as main class
``` 
jar cfe Sort.jar Sort *.class shapes/*.class sorting/*.class
```

# 3. choose command

java -jar Sort.jar -ffile_name -tv -sb

• -f or -F followed by file_name (the file name and path) with no spaces

• -t or -T followed by v (volume), h (height) or a (base area) with no spaces

• -s or -S followed by b (bubble), s (selection), i (insertion), m (merge), q (quick) or z (your choice of sorting algorithm) with no spaces

# 4. Test it
``` 
java -jar Sort.jar -f"\path\to\file.txt" -tv -sq
``` 
