#!/bin/sh
java -noverify -XX:+UseG1GC -server -jar hose-1.11.2.jar true
