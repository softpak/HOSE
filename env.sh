export TOP=/home/${LOGNAME}/HSA
# Rest of this assumes layout below
#   ${TOP}
#       +---aparapi-lambda  (this dir!)
#       +---okra            (for HSA rt)
#       +---ocl             (for opencl headers and libs)
#       +---jdk1.8.0        Java 8 JDK
#       +---gradle-1.12     gradle

# set APARAPI_HOME to the directory containing this file
export APARAPI_HOME=${TOP}/aparapi-lambda
if test ! -f ${APARAPI_HOME}/env.sh ; then 
   echo "APARAPI_HOME is not set correctly (currently set to ${APARAPI_HOME})"
   exit 1
fi

# set JAVA_HOME to a java 8 sdk install (/bin and /jre are beneath here)
export JAVA_HOME=/usr/lib/jvm/java-8-oracle
if test ! -f ${JAVA_HOME}/bin/javac ; then 
   echo "JAVA_HOME is not set correctly (currently set to ${JAVA_HOME})"
   exit 1
fi

# set ANT_HOME to the directory where ant is installed (/bin is beneath here)
export ANT_HOME=/usr/share/ant
if test ! -f ${ANT_HOME}/bin/ant ; then 
   echo "ANT_HOME is not set correctly (currently set to ${ANT_HOME})"
   exit 1
fi

# OCL_LIB + OCL_INCLUDE point to OpenCL SDK installation lib and include dirs (so Aparapi com.amd.aparapi.jni can build)
#export OCL_HOME=${TOP}/AMD-APP-SDK-v2.9-RC-lnx64
#export OCL_HOME=${TOP}/ocl
export OCL_HOME=/opt/AMDAPP
export OCL_LIB=${OCL_HOME}/lib/x86_64
export OCL_INCLUDE=${OCL_HOME}/include
if test ! -d ${OCL_HOME}/include ; then 
   echo "OCL_HOME is not set correctly (currently set to ${OCL_HOME})"
   exit 1
fi

# set OKRA_HOME to your OKRA directory (/dist is underneath here)
export OKRA_HOME=${TOP}/Okra-Interface-to-HSA-Device/okra
#export OKRA_HOME=${TOP}/okra
if test ! -d ${OKRA_HOME}/dist ; then 
   echo "OKRA_HOME is not set correctly (currently set to ${OKRA_HOME})"
   exit 1
fi

#export GRADLE_HOME=${TOP}/gradle-1.12
export GRADLE_HOME=/usr/share/gradle
if test ! -d ${GRADLE_HOME}/bin ; then 
   echo "GRADLE_HOME is not set correctly (currently set to ${GRADLE_HOME})"
   exit 1
fi

echo "APARAPI_HOME:${APARAPI_HOME}"
echo "ANT_HOME:${ANT_HOME}"
#echo "APARAPI_JNI_HOME:${APARAPI_JNI_HOME}"
#echo "APARAPI_JAR_HOME:${APARAPI_JAR_HOME}"
echo "APARAPI_JNI_HOME:${APARAPI_HOME}/com.amd.aparapi.jni/dist"
echo "APARAPI_JAR_HOME:${APARAPI_HOME}/com.amd.aparapi/dist"
echo "JAVA_HOME:${JAVA_HOME}"
echo "OCL_LIB:${OCL_LIB}"
echo "OCL_INCLUDE:${OCL_INCLUDE}"
echo "OKRA_HOME:${OKRA_HOME}"
echo "GRADLE_HOME:${GRADLE_HOME}"

# This looks odd :) When we create dist zip the dist has aparapi.jar and {lib}aparapi_x86_64.{dll|dylib|so} at the root
# The following allows this env script to work for either configuration.
test -d ${APARAPI_HOME}/com.amd.aparapi.jni/dist && export APARAPI_JNI_HOME=${APARAPI_HOME}/com.amd.aparapi.jni/dist  || export APARAPI_JNI_HOME=${APARAPI_HOME}
test -d ${APARAPI_HOME}/com.amd.aparapi/dist && export APARAPI_JAR_HOME=${APARAPI_HOME}/com.amd.aparapi/dist  || export APARAPI_JAR_HOME=${APARAPI_HOME}

export PATH=${JAVA_HOME}/bin:${ANT_HOME}/bin:${OKRA_HOME}/dist/bin:${OKRA_HOME}/hsa/bin/x86_64:${GRADLE_HOME}/bin:${PATH}
echo "PATH:$PATH"

export LD_LIBRARY_PATH=${OKRA_HOME}/dist/bin:${OKRA_HOME}/hsa/bin/x86_64:${OCL_LIB}:${LD_LIBRARY_PATH}
echo "LD_LIBRARY_PATH:${LD_LIBRARY_PATH}"

export LIB_ARCH=$(uname -m)
echo "LIB_ARCH:${LIB_ARCH}"
case $(uname -s) in 
  Darwin) LIB_PREFIX=lib;;
  Linux)  LIB_PREFIX=lib;;
  Win64)  LIB_PREFIX=;;
esac
case $(uname -s) in 
  Darwin) LIB_SUFFIX=dyLib;;
  Linux)  LIB_SUFFIX=so;;
  Win64)  LIB_SUFFIX=dll;;
esac
echo "LIB_SUFFIX:${LIB_SUFFIX}"
echo "LIB_PREFIX:${LIB_PREFIX}"
export APARAPI_AGENT_NAME=${LIB_PREFIX}aparapi_agent_${LIB_ARCH}.${LIB_SUFFIX}
echo APARAPI_AGENT_NAME=${APARAPI_AGENT_NAME}


export HSA_RUNTIME=1
echo "HSA_RUNTIME:${HSA_RUNTIME}"

export JVM_OPTS=
#export JVM_OPTS="${JVM_OPTS} -Xmx2G"
#export JVM_OPTS="${JVM_OPTS} -XX:-UseCompressedOops"
export JVM_OPTS="${JVM_OPTS} -agentpath:${APARAPI_JNI_HOME}/${APARAPI_AGENT_NAME}"
export JVM_OPTS="${JVM_OPTS} -Djava.library.path=${APARAPI_JNI_HOME}:${OKRA_HOME}/dist/bin:${OKRA_HOME}/hsa/bin/x86_64"
echo "JVM_OPTS:$JVM_OPTS"

export JARS=
export JARS="${JARS}:${APARAPI_JAR_HOME}/aparapi.jar"
export JARS="${JARS}:${OKRA_HOME}/dist/okra.jar"
echo "JARS:${JARS}"
