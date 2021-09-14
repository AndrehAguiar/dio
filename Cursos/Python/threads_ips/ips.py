import ipaddress


def get_ip():
    ip = '192.168.0.1'
    address = ipaddress.ip_address(ip)
    print(f'Ip: {address}')
    return address


def calc_ip(ip, n: int):
    print(ip + n)


def get_network(ip, network_type):
    ip = f"{ip}/{network_type}"
    network = ipaddress.ip_network(ip, strict=False)
    print(f'Network: {network}')
    return network


def view_all_network_ips(network):
    [print(ip) for ip in network]


if __name__ == '__main__':
    calc_ip(get_ip(), 300)
    view_all_network_ips(get_network(get_ip(), 24))
