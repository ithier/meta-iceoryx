#
# A CXX API for Cyclone DDS.
#

SUMMARY = "A CXX API for CycloneDDS."
LICENSE = "Eclipse-2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=ca2dafd1f07f3cd353d0454d3c4d9e80"

SRC_URI = "git://github.com/ThijsSassen/cdds-cxx.git;protocol=git"
SRCREV = "32795f8494195a63478abfa0d9b4d5bc2a2199c5"

DEPENDS = "cyclonedds idlpp-cxx openjdk-8-native"
RDEPENDS_${PN} = "cyclonedds"

export JAVA_HOME 
JAVA_HOME = "${STAGING_DIR_NATIVE}/${libdir_nativesdk}/jvm/openjdk-8-native/"

inherit cmake

S = "${WORKDIR}/git/"

EXTRA_OECMAKE = " \
		-DCMAKE_PREFIX_PATH=${libdir} \
		-DCMAKE_INSTALL_PREFIX=${exec_prefix} \
		-DBUILD_TESTING=OFF \
        -DCMAKE_SKIP_RPATH=TRUE \
        "

FILES_${PN} = "*"