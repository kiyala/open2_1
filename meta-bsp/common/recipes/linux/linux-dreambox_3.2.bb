DEPENDS = "carl9170fw linux-firmware zd1211-firmware"
PR = "${INC_PR}.47"

PATCHREV = "4e0356d04e89df800361b9252f990716f5523c6e"
PATCHLEVEL = "51"

SRC_URI = " \
        ${KERNELORG_MIRROR}/linux/kernel/v3.x/linux-3.2.tar.bz2;name=kernel \
        ${KERNELORG_MIRROR}/linux/kernel/v3.x/patch-3.2.${PATCHLEVEL}.bz2;apply=yes;name=kernel-patch \
        http://sources.dreamboxupdate.com/download/kernel-patches/${P}-${PATCHREV}.patch.bz2;name=dmm-patch \
        http://download.filesystems.org/unionfs/unionfs-2.x/unionfs-2.5.11_for_3.2.2.diff.gz;name=unionfs \
        file://clear_sublevel.patch \
        file://fadvise_dontneed_change.patch \
        file://fix-proc-cputype.patch \
        file://rtl8712-backport-b.patch \
        file://rtl8712-backport-c.patch \
        file://rtl8712-backport-d.patch \
        file://make-3.82-hack.patch \
        file://0001-SCSI-sd-Use-SCSI-read-write-16-with-32-bit-LBA-drive.patch \
        file://0002-add-crypto-api-xz-support.patch \
        file://0003-add-XZ-compression-support-to-UBIFS.patch \
        file://0004-block2mtd-add-possibility-to-change-the-writesize.patch \
        file://0005-block2mtd-add-possibility-to-remove-block2mtd-device.patch \
        file://0006-mtd-block2mtd-fix-recursive-call-of-mtd_writev.patch \
        file://0007-mtd-block2mtd-throttle-writes-by-calling-balance_dir.patch \
        file://0008-The-ubi-maintained-flag-must-be-set-earlier-to-preve.patch \
        file://0009-fixed-partition-is-ubi-maintained-check.patch \
        file://0001-add-memory-mapping-support-to-usbfs-used-by-sundtek-.patch \
        file://defconfig \
"

SRC_URI[kernel.md5sum] = "7ceb61f87c097fc17509844b71268935"
SRC_URI[kernel.sha256sum] = "c881fc2b53cf0da7ca4538aa44623a7de043a41f76fd5d0f51a31f6ed699d463"
SRC_URI[kernel-patch.md5sum] = "325de4129bf84f0ccea6f65a79f1811a"
SRC_URI[kernel-patch.sha256sum] = "ce35a81143c4c58e4f97063d165f7f49d81c02c73a224152ee7b13f2af031f27"
SRC_URI[dmm-patch.md5sum] = "d17d65e9978343d540e0b60767a82286"
SRC_URI[dmm-patch.sha256sum] = "576356545de7f587d164d1cee2cb17b6c1ce3efbe2e01ff785c13ec2d544d220"
SRC_URI[unionfs.md5sum] = "06e7c9f6cafd49b72184be851116c511"
SRC_URI[unionfs.sha256sum] = "ce6ffa3c17a11dcca24196c11f6efc95c59b65a5b99958e73e8d4cc8e4b1f1ef"

S = "${WORKDIR}/linux-3.2"

RDEPENDS_kernel-module-carl9170 = "carl9170fw"
RDEPENDS_kernel-module-cifs = "kernel-module-arc4 kernel-module-ecb kernel-module-hmac kernel-module-md4"
RDEPENDS_kernel-module-mac80211 = "kernel-module-aes-generic kernel-module-arc4"
RDEPENDS_kernel-module-r8712u = "linux-firmware-rtl8192su"
RDEPENDS_kernel-module-rt2800usb = "linux-firmware-rt2800usb"
RDEPENDS_kernel-module-rt73usb = "linux-firmware-rt73usb"
RDEPENDS_kernel-module-zd1211rw = "zd1211-firmware"

require linux-dreambox.inc
