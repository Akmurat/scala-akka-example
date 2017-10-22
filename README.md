## Getting Started

### Requirements

  * Mac OS X, Windows, or Linux
  * OpenJDK 8 ([open-jdk website](http://openjdk.java.net/)) or OracleJDK 8 ([oracle-jdk website](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html))
  * Scala 2.12.3 ([scala website](http://scala-lang.org/))
  * SBT 1.0.2 ([sbt website](http://www.scala-sbt.org/))


### Quick Start

#### 1. Install OpenJDK, Scala, Sbt, Docker:

jdk:
> `sudo apt-get install openjdk-8-jdk`

scala:
> `wget www.scala-lang.org/files/archive/scala-2.12.3.deb`

> `sudo apt install ./scala-2.12.3.deb`

sbt:
> `echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list`

> `sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823`

> `sudo apt-get update` and `sudo apt-get install sbt`