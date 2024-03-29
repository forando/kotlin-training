# Getting Started

### Prerequisites
* JavaFX 8
* Git

### Install JavaFX (Mac/Linux)

1. Download Zulu JavaFX 8 [here](https://www.azul.com/downloads/zulu-community/?&architecture=x86-64-bit&package=jdk-fx)
2. Unzip archive and put content under `/Library/Java/JavaVirtualMachines/zulu-8-javafx.jdk`
3. Open this project in IntelliJ Idea and point to this **JDK** in your **Project Settings**. 
    Please, make sure that your **Gradle Settings** also configured to use the same **JDK**.
    
Next steps are Optional and only needed if you want to run the app from a console

4. insert next line into your **.bash_profile**: 
    `alias jfx="export JAVA_HOME=/Library/Java/JavaVirtualMachines/zulu-8-javafx.jdk; java -version"`
5. Open terminal and reload your .bash_profile: `source ~/.bash_profile`
6. Run: `jfx`
7. Ensure that current java version corresponds to your javaFx version

## Introduction

### Properties and backing field

#### Task 1.1
Implement IntroductionService#**greeting** property so that it returns **"Hello 1"**

Expected (first invocation):
- **Greeting:** Hello 1

Expected (second invocation):
- **Greeting:** Hello 1

Expected (third invocation):
- **Greeting:** Hello 1

#### Task 1.2
Now rewrite IntroductionService#**greeting** such that each invocations returns **"Hello + incremented_number"**

Expected (first invocation):
- **Greeting:** Hello 1

Expected (second invocation):
- **Greeting:** Hello 2

Expected (third invocation):
- **Greeting:** Hello 3

### Collections

#### Task 2.1
Implement IntroductionService#**listNames** and **listNumbers**. Use convenient builders to return collections.

Expected:
- **Names:** name1, name2, name3
- **Numbers:** 1, 2, 3

#### Task 2.2
Introduce local variable **possibleIds** of type **List of Strings**. Rewrite IntroductionService#**listNumbers** to provide
numeric representation of **possibleIds**

Given:
- **possibleIds:** ["1", "2", "20", "15"]

Expected
- **Numbers:** 1, 2, 20, 15

#### Task 2.3
Filter **possibleIds** to return only numeric values > 10 in ascending order

Given:
- **possibleIds:** ["1", "2", "20", "15"]

Expected
- **Numbers:** 15, 20

#### Task 2.4
Introduce extension function that transforms String into Int catching **NumberFormatException** with fallback == 0

Use this function inside IntroductionService#**listNumbers**

Given:
- **possibleIds:** ["1", "2", ""a", "20", "b", "15"]

Expected
- **Numbers:** 15, 20

### Nullable Types

#### Task 3.1
Introduce variable **id** of type **nullable Int** and assign it by default to **NULL**.

Inside IntroductionService#**listNumbers** transformation assign **id** to current Int (before sorting) following next rules:
- if **id** is not **NULL** do nothing
- if **id** is **NULL** assign current Int to it

Expose id with IntroductionService#**createComplexString**

Given:
- **id** = NULL
- **possibleIds:** ["1", "2", ""a", "20", "b", "15"]

Expected
- **Numbers:** 15, 20
- **Complex String:** 20

Given:
- **id** = NULL
- **possibleIds:** ["1", "2", ""a"]

Expected
- **Numbers:**
- **Complex String:**

#### Task 3.2

Expose **id** via IntroductionService#**createComplexString** prefixing it with "id = " such as:

Given:
- **id** = NULL
- **possibleIds:** ["1", "2", ""a", "20", "b", "15"]

Expected
- **Complex String:** id = 20

Given:
- **id** = NULL
- **possibleIds:** ["1", "2", ""a"]

Expected
- **Complex String:** id = -1