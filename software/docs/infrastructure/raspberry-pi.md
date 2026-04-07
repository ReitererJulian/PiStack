
# Raspberry Pi

## Important Info

- Raspberry Pi 5 with 8GB Ram
- Raspberry Pi OS Lite
- 240GB Sata


### Access Boot SD

```
cd /etc
```

### Access Sata

```
cd /mnt/data
```

### Check Disks Mounted

```
lsblk
```
Output:
```
reiti@pi:~ $ lsblk  
NAME        MAJ:MIN RM   SIZE RO TYPE MOUNTPOINTS  
loop0         7:0    0     2G  0 loop    
sda           8:0    0 223.6G  0 disk /mnt/data  
mmcblk0     179:0    0  29.7G  0 disk    
├─mmcblk0p1 179:1    0   512M  0 part /boot/firmware  
└─mmcblk0p2 179:2    0  29.2G  0 part /  
zram0       254:0    0     2G  0 disk [SWAP]
```

```
sda -> Sata
mmcblk0 -> Boot SD
```

---

## Temperature
Using a passive cooler and a Noctua 120mm fan

Max Temp after 2 minute stress test (100% CPU usage)


### With fan (no case)

#### 100% fan speed
- Max temp: `39.7`°C

#### 50% fan speed (silent)
- Max temp: `41.9`°C

---

### Without fan (with passive cooler)

- Max temp: `68.8`°C