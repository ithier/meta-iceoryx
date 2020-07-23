#
# The iceoryx posh component.
#

SUMMARY = "The iceoryx posh component."
SECTION = "iceoryx"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=46d6aa0ba1fa2ed247cd8d42f20b72f4"

BRANCH = "master"
SRC_URI = "git://github.com/eclipse/iceoryx.git;protocol=ssh;branch=${BRANCH}"
SRCREV = "7fc55026c32a2fa1eff8d812ffc6c650bb8cc66c"

PROVIDES = "iox-posh iox-roudi iox-examples"

DEPENDS = "cpptoml iox-utils"
RDEPENDS_${PN} = ""

inherit cmake

S = "${WORKDIR}/git/iceoryx_posh"

EXTRA_OECMAKE += "	-DCMAKE_PREFIX_PATH=${libdir} \
					-DCMAKE_MODULE_PATH=${libdir} \
					-DCMAKE_INSTALL_PREFIX=${exec_prefix} \
					-Dtest=OFF \
					-DTOML_CONFIG=ON"

do_install_append() {
	install -d ${D}${datadir}/cmake/Modules
	install -m 0444 ${WORKDIR}/git/iceoryx_posh/cmake/iceoryx_poshConfig.cmake ${D}${datadir}/cmake/Modules
}

FILES_${PN} += "${bindir}/* /usr/etc/*"
FILES_${PN}-staticdev += "${includedir}/* ${libdir}/* ${datadir}/*"