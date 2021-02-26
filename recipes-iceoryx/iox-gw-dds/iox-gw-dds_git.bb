SUMMARY = "An iceoryx gateway implementation for DDS networks."
SECTION = "iceoryx"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=46d6aa0ba1fa2ed247cd8d42f20b72f4"

BRANCH = "master"
SRC_URI = "git://github.com/eclipse/iceoryx.git;protocol=ssh;branch=${BRANCH}"
SRCREV = "785d3bd67352edb06d0976979d006a91560024fe"

# ===== DISABLED ===== #
# Recipe is not quite functional. Need to address Java build dependency introduced by
# idlpp-cxx.

# DEPENDS = "iox-posh iox-utils"
# RDEPENDS_${PN} = "iox-roudi"

# DEPENDS = "iox-posh iox-utils cyclonedds cyclonedds-cxx idlpp-cxx cpptoml"
# RDEPENDS_${PN} = "iox-roudi cyclonedds-cxx"

# inherit cmake

# S = "${WORKDIR}/git/iceoryx_dds"

# EXTRA_OECMAKE = " \
#             -DCMAKE_PREFIX_PATH=${libdir} \
#             -DCMAKE_INSTALL_PREFIX=${exec_prefix} \
#             -Dtest=off \
#             "
