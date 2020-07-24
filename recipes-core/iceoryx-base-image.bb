require recipes-core/images/core-image-base.bb

IMAGE_INSTALL += "iox-roudi iox-examples iox-introspection"

DISTRO_FEATURES_append += "systemd"

DISTRO_FEATURES_remove += "bluetooth"
DISTRO_FEATURES_remove += "3g"
DISTRO_FEATURES_remove += "opengl"
DISTRO_FEATURES_remove += "wayland"
DISTRO_FEATURES_remove += "x11"
DISTRO_FEATURES_remove += "nfc"
DISTRO_FEATURES_remove += "nfs"
DISTRO_FEATURES_remove += "ext2"

DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"