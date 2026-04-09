# Stress test for RaspberryPi

```python
import multiprocessing
import time
import os


def load():
    while True:
        _ = 1000 * 1000


def get_temp():
    with open("/sys/class/thermal/thermal_zone0/temp") as f:
        return float(f.read()) / 1000


if __name__ == "__main__":
    duration = 120
    cores = 4
    processes = []
    max_temp = 0.0

    start_time = time.time()

    print("--- Raspberry Pi 5 stress test (2min) ---")
    print("Press STRG+C to quit")

    for _ in range(cores):
        p = multiprocessing.Process(target=load)
        p.start()
        processes.append(p)

    try:
        while time.time() - start_time < duration:
            temp = get_temp()

            if temp > max_temp:
                max_temp = temp

            print(f"Temp: {temp:.1f}°C", end="\r")
            time.sleep(1)
    except KeyboardInterrupt:
        print("\n\nTest stopped...")
        for p in processes:
            p.terminate()
        print("Exiting...")
    finally:
        for p in processes:
            p.terminate()

        print("\n" + "=" * 40)
        print(f"TEST FINISHED")
        print(f"Max temp: {max_temp:.1f}°C")
        print("=" * 40)
``` 