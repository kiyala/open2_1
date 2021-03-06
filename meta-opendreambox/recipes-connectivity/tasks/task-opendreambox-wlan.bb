SUMMARY = "OpenDreambox: WLAN support"
SECTION = "opendreambox/base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${OPENDREAMBOX_BASE}/LICENSE;md5=0a5ec7423edaca24547634f416478834"
DEPENDS = " \
  ${@base_contains('MACHINE_FEATURES', 'pci', 'madwifi-ng', '',d)} \
  ${@base_version_less_or_equal('DREAMBOX_KERNEL_VERSION', '2.6.18', '${WLAN_USB_MODULES_LEGACY}', '', d)} \
  r8192c \
  virtual/kernel \
"
PR = "r15"

inherit task

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} = " \
  wireless-tools \
  wpa-supplicant \
"

RRECOMMENDS_${PN} = " \
  ${@base_contains('MACHINE_FEATURES', 'pci', '${WLAN_PCI_MODULES}', '', d)} \
  ${@base_version_less_or_equal('DREAMBOX_KERNEL_VERSION', '2.6.18', '${WLAN_USB_MODULES_LEGACY}', '${WLAN_USB_MODULES_KERNEL}', d)} \
  r8192c \
"

WLAN_USB_MODULES_KERNEL = " \
  kernel-module-carl9170 \
  kernel-module-r8712u \
  kernel-module-rt2800usb \
  kernel-module-rt73usb \
  kernel-module-zd1211rw \
"

WLAN_USB_MODULES_LEGACY = " \
  r8712u \
  rt3070 \
  wlan-rt73 \
  zd1211b \
"

WLAN_PCI_MODULES = " \
  madwifi-ng-modules \
  madwifi-ng \
"
