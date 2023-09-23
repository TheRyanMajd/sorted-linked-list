#!/bin/bash -ex

mvn -q clean
mvn -q compile
mvn -q exec:java -Dexec.mainClass="com.sllRyanMajd.app.LinkedListDriver" -Dexec.args="resources/input.txt"
