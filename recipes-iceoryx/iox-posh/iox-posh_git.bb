SUMMARY = "A library for creating iceoryx applications, and the iceoryx routing and memory management daemon."
SECTION = "iceoryx"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=46d6aa0ba1fa2ed247cd8d42f20b72f4"

BRANCH = "master"
SRC_URI = "git://github.com/eclipse/iceoryx.git;protocol=ssh;branch=${BRANCH}"
SRCREV = "785d3bd67352edb06d0976979d006a91560024fe"

DEPENDS = "cpptoml iox-utils"
RDEPENDS_${PN} = ""

RPROVIDES_${PN} = "iox-roudi"

inherit cmake

S = "${WORKDIR}/git/iceoryx_posh"

EXTRA_OECMAKE = " \
		-DCMAKE_PREFIX_PATH=${libdir} \
		-DCMAKE_INSTALL_PREFIX=${exec_prefix} \
		-Dtest=OFF \
		-DTOML_CONFIG=ON \
        "

SYSROOT_DIRS += "${bindir}"

# Include additionally generated default configs
FILES_${PN} += "/usr/etc/*"