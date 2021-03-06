SUMMARY = "The iceoryx introspection client."
SECTION = "iceoryx"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=46d6aa0ba1fa2ed247cd8d42f20b72f4"

BRANCH = "master"
SRC_URI = "git://github.com/eclipse/iceoryx.git;protocol=ssh;branch=${BRANCH}"
SRCREV = "785d3bd67352edb06d0976979d006a91560024fe"

DEPENDS = "iox-utils iox-posh ncurses"
RDEPENDS_${PN} = "iox-roudi"

inherit cmake

S = "${WORKDIR}/git/tools/introspection"

EXTRA_OECMAKE += " \
				-DCMAKE_PREFIX_PATH=${libdir} \
				-DCMAKE_MODULE_PATH=${libdir} \
				-DCMAKE_INSTALL_PREFIX=${exec_prefix} \
			"
