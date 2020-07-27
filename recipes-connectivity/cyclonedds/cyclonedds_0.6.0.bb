SUMMARY = "Eclipse Cyclone DDS is a very performant and robust open-source DDS implementation."
SECTION = "dds"
LICENSE = "Eclipse-2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=ca2dafd1f07f3cd353d0454d3c4d9e80"

SRC_URI = "git://github.com/eclipse-cyclonedds/cyclonedds.git;protocol=git;tag=0.6.0"

DEPENDS = "openssl"
RDEPENDS_${PN} = ""

inherit cmake

S = "${WORKDIR}/git/"

EXTRA_OECMAKE = " \
        -DBUILD_IDLC=OFF \
        "
