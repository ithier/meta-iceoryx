# meta-iceoryx
Yocto layer for integrating [iceoryx](https://github.com/eclipse-iceoryx/iceoryx) into Yocto build toolchains.

A minimal reference image definition including iceoryx components, `iceoryx-base-image`, is also included.

## Quick Start with Raspberry Pi 4

The following instructions have been tested with Yocto release: `dunfell`

### Set up a Yocto workspace

```
$ mkdir -p ~/Yocto
```

### Fetch all required Yocto layers:
```
$ cd Yocto
$ export YOCTO_RELEASE=dunfell
$ git clone -b $YOCTO_RELEASE http://git.yoctoproject.org/git/poky 
$ git clone -b $YOCTO_RELEASE git clone -b dunfell https://github.com/openembedded/meta-openembedded.git
$ git clone -b $YOCTO_RELEASE git://git.yoctoproject.org/meta-raspberrypi 
$ git clone git://github.com/ithier/meta-iceoryx
```

### Configure the build environment:
```
$ cd Yocto
$ source ./poky/oe-init-build-env
```

### Configure your build:
Use a text editor to modify the following files:

**~/Yocto/build/conf/bblayers.conf**

```
POKY_BBLAYERS_CONF_VERSION = "2"

BSPDIR := "${@os.path.abspath(os.path.dirname(d.getVar('FILE', True)) + '/../..')}"

BBPATH = "${TOPDIR}"
BBFILES ?= ""

BBLAYERS ?= " \
  ${BSPDIR}/poky/meta \
  ${BSPDIR}/poky/meta-poky \
  ${BSPDIR}/meta-raspberrypi \
  ${BSPDIR}/meta-iceoryx \
  "
```

**~/Yocto/build/conf/local.conf**

(This is the default configuration with all commented out lines removed)
```
MACHINE ??= 'raspberrypi4-64'
DISTRO ?= 'poky'
PACKAGE_CLASSES ?= "package_rpm"
EXTRA_IMAGE_FEATURES ?= "debug-tweaks"
USER_CLASSES ?= "buildstats image-mklibs image-prelink"
PATCHRESOLVE = "noop"
BB_DISKMON_DIRS ??= "\
    STOPTASKS,${TMPDIR},1G,100K \
    STOPTASKS,${DL_DIR},1G,100K \
    STOPTASKS,${SSTATE_DIR},1G,100K \
    STOPTASKS,/tmp,100M,100K \
    ABORT,${TMPDIR},100M,1K \
    ABORT,${DL_DIR},100M,1K \
    ABORT,${SSTATE_DIR},100M,1K \
    ABORT,/tmp,10M,1K"
PACKAGECONFIG_append_pn-qemu-system-native = " sdl"
CONF_VERSION = "1"
```

### Build the reference image:
```
$ cd ~/Yocto/build
$ bitbake iceoryx-base-image
```
