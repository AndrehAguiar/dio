import time
from threading import Thread


def car(speed, pilot):
    way = 0
    while way <= 100:
        way += speed
        time.sleep(0.5)
        print(f'Car: {pilot} | {way}\n')


if __name__ == '__main__':
    Thread(target=car, args=[1, 'Car 1']).start()
    Thread(target=car, args=[2, 'Car 2']).start()
