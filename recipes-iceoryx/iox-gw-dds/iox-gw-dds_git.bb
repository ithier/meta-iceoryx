#
# The iceoryx DDS gateway for integrating multiple iceoryx hosts across a DDS network.
#

SUMMARY = "An iceoryx gateway implementation for DDS networks."
SECTION = "iceoryx"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=46d6aa0ba1fa2ed247cd8d42f20b72f4"

BRANCH = "master"
SRC_URI = "git://github.com/eclipse/iceoryx.git;protocol=ssh;branch=${BRANCH}"
SRCREV = "7fc55026c32a2fa1eff8d812ffc6c650bb8cc66c"

DEPENDS = "iox-posh iox-utils"
RDEPENDS_${PN} = "iox-roudi"
