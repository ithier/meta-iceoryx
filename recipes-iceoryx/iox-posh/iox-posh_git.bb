#
# Recipe for the POSH (Posix Shared Memory) component of iceoryx.
# Includes POSH library and RouDi.
#

SUMMARY = "A library for creating iceoryx applications, and the iceoryx routing and memory management daemon."
SECTION = "iceoryx"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=46d6aa0ba1fa2ed247cd8d42f20b72f4"

BRANCH = "master"
SRC_URI = "git://github.com/eclipse/iceoryx.git;protocol=ssh;branch=${BRANCH}"
SRCREV = "7fc55026c32a2fa1eff8d812ffc6c650bb8cc66c"

DEPENDS = "cpptoml iox-utils"
RDEPENDS_${PN} = ""

RPROVIDES_${PN} = "iox-roudi"

inherit cmake

S = "${WORKDIR}/git/iceoryx_posh"

EXTRA_OECMAKE = " \
		-DCMAKE_PREFIX_PATH=${libdir} \
		-DCMAKE_MODULE_PATH=${libdir} \
		-DCMAKE_INSTALL_PREFIX=${exec_prefix} \
		-Dtest=OFF \
		-DTOML_CONFIG=ON \
        "

SYSROOT_DIRS += "${bindir}"

# Include additionally generated default configs
FILES_${PN} += "/usr/etc/*"  