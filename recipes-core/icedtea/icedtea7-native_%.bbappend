# 
# Fixes compilation on GCC 9.
#
LICENSE = "GPL-2.0-with-classpath-exception"
CFLAGS_append = " -Wno-error=format-overflow"