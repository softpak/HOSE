#!/bin/sh
. ../env.sh
export JARS="${JARS}:spigot-1.8.3-R0.1-SNAPSHOT.jar"

export JVM_OPTS="${JVM_OPTS} -Dcom.amd.aparapi.useAgent=true" \
export JVM_OPTS="${JVM_OPTS} -Dcom.amd.aparapi.executionMode=${1}" \
export JVM_OPTS="${JVM_OPTS} -Dcom.amd.aparapi.enableVerboseJNI=false" \

java ${JVM_OPTS} -classpath ${JARS} org.bukkit.craftbukkit.Main
#-Djava.library.path=/home/softpak/HSA/aparapi-lambda/com.amd.aparapi/dist \
#-Djava.library.path=/home/softpak/HSA/aparapi-lambda/com.amd.aparapi.jni/dist \
#-classpath ${JARS} com.amd.aparapi.sample.squares.HSASquares
#-jar spigot-1.8.3-R0.1-SNAPSHOT.jar -o true
