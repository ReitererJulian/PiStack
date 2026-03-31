# Status Script

The status script was created to see temperature, ram and cpu usage of the Raspberry PI

```python
import os
import time
import psutil

def getTemp():
    with open("/sys/class/thermal/thermal_zone0/temp") as f:
            temp = float(f.read()) / 1000
            return round(temp, 1)

try:
    print("Press STRG+C to quit")
    print("TIME      | Temp     | CPU-Usage      | RAM-Usage")
    print("-" * 42)

    while True:
        t = time.strftime("%H:%M:%S")
        temp = getTemp()
        cpu = psutil.cpu_percent()
        ram = psutil.virtual_memory().used / 1024 / 1024

        print(f"{t} | {temp}°C | {cpu}%      | {int(ram)} MB",
              end="\r")
        time.sleep(5)

except KeyboardInterrupt:
    print("\nExit")
``` 