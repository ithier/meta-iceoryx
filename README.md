# meta-iceoryx
Layer for integrating iceoryx into Yocto builds.

To include iceoryx in your Yocto builds, simply add this layer to your bblayers stack.

Additionally, a reference image provides a build of the default `core-image-base` with all iceoryx components.

## Quick Start with Raspberry Pi 4

#### Fetch the Yocto project's reference distribution, poky:
```
$ cd ~
$ mkdir Yocto
$ cd Yocto
$ git clone -b dunfell http://git.yoctoproject.org/git/poky 
```

#### Fetch the official Raspberry Pi BSP layer:
```
$ cd ~/Yocto
$ git clone -b dunfell git://git.yoctoproject.org/meta-raspberrypi 
```

#### Fetch this iceoryx layer:
```
$ cd ~/Yocto
$ git clone git://github.com/ithier/meta-iceoryx
```

#### Configure the build environment:
```
$ cd ~/Yocto
$ source oe-init-build-env
```

#### Configure your build:

~/Yocto/build/conf/bblayers.conf:
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

~/Yocto/build/conf/local.conf:

(Basically the default without all the commented out options)
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

#### Build the reference image
```
$ cd ~/Yocto/build
$ bitbake iceoryx-base-image
```
