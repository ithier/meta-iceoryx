SUMMARY = "An idl compiler."
SECTION = "dds"
LICENSE = "Eclipse-2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=ca2dafd1f07f3cd353d0454d3c4d9e80"

SRC_URI = "git://github.com/ADLINK-IST/idlpp-cxx.git;protocol=git"
SRCREV = "219e158704499d91bce8d819301c41284908ddcc"

DEPENDS = "java-native maven-native"
RDEPENDS_${PN} = ""

inherit cmake
OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "BOTH"

S = "${WORKDIR}/git/"

EXTRA_OECMAKE = " \
		-DCMAKE_PREFIX_PATH=${libdir} \
		-DCMAKE_INSTALL_PREFIX=${exec_prefix} \
        -DMAVEN_ROOT=${bindir_native} \
        "

