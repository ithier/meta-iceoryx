SUMMARY = "The iceoryx utilities library that brings cxx features to c++11"
SECTION = "iceoryx"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=46d6aa0ba1fa2ed247cd8d42f20b72f4"

BRANCH = "master"
SRC_URI = "git://github.com/eclipse/iceoryx.git;protocol=ssh;branch=${BRANCH}"
SRCREV = "785d3bd67352edb06d0976979d006a91560024fe"

DEPENDS = "acl"
RDEPENDS_${PN} = ""

inherit cmake

S = "${WORKDIR}/git/iceoryx_utils"

EXTRA_OECMAKE += " \
		-DCMAKE_PREFIX_PATH=${libdir} \
		-DCMAKE_INSTALL_PREFIX=${exec_prefix} \
		-DCMAKE_BUILD_TYPE=Release -Dtest=OFF \
		"

# Install CMake modules in the default location for BitBake.
do_install_append() {

	install -d ${D}${datadir}/cmake/Modules
	install -m 0444 ${WORKDIR}/git/iceoryx_utils/cmake/IceoryxPackageHelper.cmake ${D}${datadir}/cmake/Modules
	install -m 0444 ${WORKDIR}/git/iceoryx_utils/cmake/IceoryxPlatformDetection.cmake ${D}${datadir}/cmake/Modules
}

ALLOW_EMPTY_${PN} = "1"
FILES_${PN}-staticdev += "${includedir}/* ${libdir}/* ${datadir}/*"
