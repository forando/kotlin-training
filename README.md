# Getting Started

### Prerequisites
* JavaFX 8
* Git

### Install JavaFX (Mac/Linux)

1. Download Zulu JavaFX 8 [here](https://www.azul.com/downloads/zulu-community/?&architecture=x86-64-bit&package=jdk-fx)
2. Unzip archive and put content under `/Library/Java/JavaVirtualMachines/zulu-8-javafx.jdk`
3. insert next line into your **.bash_profile**: 
    `alias jfx="export JAVA_HOME=/Library/Java/JavaVirtualMachines/zulu-8-javafx.jdk; java -version"`
4. Open terminal and reload your .bash_profile: `source ~/.bash_profile`
5. Run: `jfx`
6. Ensure that current java version corresponds to your javaFx version