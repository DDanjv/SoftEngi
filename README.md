# SoftEngi

The operation we chose was to map out prime numbers under a given natural number. The value would be entered into the console, and then every prime number under that value would be listed out. 

Ideal Number Of Threads: 4

## Sections Of The API

### 1. Coordination
The Coordinators act communicate and pass variables between all other sections of the program, functioning as the highway for information.

### 2. Request / Input
The Request file reads user input from the testing file, using the delimiter

### 3. Computation
As listed previously, this section of the program calculates the prime numbers under the given value, and sends them back into the coordinator. This is the primary area for optimization in terms of speed, given it's where all the complex math occurs.

## 4. Output
The Output module reads the end of the process sent to the coordinator back to the terminal, and ends the process

![Basic Diagram Of API's](https://github.com/Ivannunez2803/SoftEngi/blob/main/IMG_5149.jpg)
