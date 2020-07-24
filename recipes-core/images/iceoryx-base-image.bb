require recipes-core/images/core-image-base.bb

IMAGE_INSTALL += "iox-roudi iox-examples iox-introspection"

DISTRO_FEATURES_append += "systemd"
DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"
