import os
import time


def get_hosts():
    with open('hosts.txt') as file:
        dump = file.read()
        dump = dump.splitlines()
        return dump


def send_pings(hosts):
    for ip in hosts:
        print("#" * 60)
        print(f"Verificando o ip: {ip}".center(60))
        print("#" * 60)
        os.system(f"ping -n 2 {ip}")
        print("=" * 60)
        time.sleep(3)


if __name__ == '__main__':
    send_pings(get_hosts())


