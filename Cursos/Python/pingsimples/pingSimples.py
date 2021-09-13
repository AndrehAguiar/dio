import os


def ask_for_host_ip():
    print("#" * 60)
    return input('Digite o IP ou Host a ser verificado: ')  # Press Ctrl+F8 to toggle the breakpoint.


def check_ip_host(ip_host_to_check: str) -> str:
    print("#" * 60)
    os.system(f'ping -n 6 {ip_host_to_check}')
    print("=" * 60)


if __name__ == '__main__':
    check_ip_host(ask_for_host_ip())