SUMMARY = "The ADLink implementation of the C++ OMG IDL compiler."
SECTION = "dds"
LICENSE = "Eclipse-2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=ca2dafd1f07f3cd353d0454d3c4d9e80"

SRC_URI = "git://github.com/ADLINK-IST/idlpp-cxx.git;protocol=git"
SRCREV = "219e158704499d91bce8d819301c41284908ddcc"

SRC_URI += "file://0000-use-cmake-binary-dir-as-maven-repo-dir.patch "

DEPENDS = "openjdk-8-native maven-native"
RDEPENDS_${PN} = ""

export JAVA_HOME 
JAVA_HOME = "${STAGING_DIR_NATIVE}/${libdir_nativesdk}/jvm/openjdk-8-native/"

inherit cmake

S = "${WORKDIR}/git/"

EXTRA_OECMAKE = " \
		-DCMAKE_PREFIX_PATH=${libdir} \
		-DCMAKE_INSTALL_PREFIX=${exec_prefix} \
        "

FILES_${PN} += "*"