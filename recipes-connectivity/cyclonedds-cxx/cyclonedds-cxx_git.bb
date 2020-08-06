#
# A CXX API for Cyclone DDS.
#

SUMMARY = "A CXX API for CycloneDDS."
LICENSE = "Eclipse-2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=ca2dafd1f07f3cd353d0454d3c4d9e80"

SRC_URI = "git://github.com/eclipse-cyclonedds/cyclonedds-cxx.git;protocol=git"
SRCREV = "5a095c27477f343eb9938eb846dc3e74c1d7aacc"

DEPENDS = "cyclonedds idlpp-cxx openjdk-8-native"
RDEPENDS_${PN} = "cyclonedds"

export JAVA_HOME 
JAVA_HOME = "${STAGING_DIR_NATIVE}/${libdir_nativesdk}/jvm/openjdk-8-native/"

inherit cmake

S = "${WORKDIR}/git/"

EXTRA_OECMAKE = " \
		-DCMAKE_PREFIX_PATH=${libdir} \
		-DCMAKE_INSTALL_PREFIX=${exec_prefix} \
        -DCMAKE_SKIP_RPATH=TRUE \
		-DBUILD_EXAMPLES=OFF \
		-DBUILD_TESTING=OFF \
		-DBUILD_STRICT=OFF \
        "

FILES_${PN} = "*"